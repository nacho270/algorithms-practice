package com.nacho.threading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

  private CyclicBarrier cyclicBarrier;
  private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());
  private Random random = new Random();
  private int NUM_PARTIAL_RESULTS;
  private int NUM_WORKERS;

  class NumberCruncherThread implements Runnable {

    @Override
    public void run() {
      final String thisThreadName = Thread.currentThread().getName();
      final List<Integer> partialResult = new ArrayList<>();

      // Crunch some numbers and store the partial result
      for (int i = 0; i < NUM_PARTIAL_RESULTS; i++) {
        final Integer num = random.nextInt(10);
        System.out.println(thisThreadName + ": Crunching some numbers! Final result - " + num);
        partialResult.add(num);
      }

      partialResults.add(partialResult);
      try {
        System.out.println(thisThreadName + " waiting for others to reach barrier.");
        cyclicBarrier.await();
      } catch (final InterruptedException e) {
        // ...
      } catch (final BrokenBarrierException e) {
        // ...
      }
    }
  }

  class AggregatorThread implements Runnable {

    @Override
    public void run() {

      final String thisThreadName = Thread.currentThread().getName();

      System.out
          .println(thisThreadName + ": Computing sum of " + NUM_WORKERS + " workers, having " + NUM_PARTIAL_RESULTS + " results each.");
      int sum = 0;

      for (final List<Integer> threadResult : partialResults) {
        System.out.print("Adding ");
        for (final Integer partialResult : threadResult) {
          System.out.print(partialResult + " ");
          sum += partialResult;
        }
        System.out.println();
      }
      System.out.println(thisThreadName + ": Final result = " + sum);
    }
  }

  public void runSimulation(final int numWorkers, final int numberOfPartialResults) {
    NUM_PARTIAL_RESULTS = numberOfPartialResults;
    NUM_WORKERS = numWorkers;

    cyclicBarrier = new CyclicBarrier(NUM_WORKERS, new AggregatorThread());

    System.out.println("Spawning " + NUM_WORKERS + " worker threads to compute " + NUM_PARTIAL_RESULTS + " partial results each");

    for (int i = 0; i < NUM_WORKERS; i++) {
      final Thread worker = new Thread(new NumberCruncherThread());
      worker.setName("Thread " + i);
      worker.start();
    }
  }

  public static void main(final String[] args) {
    final CyclicBarrierDemo demo = new CyclicBarrierDemo();
    demo.runSimulation(5, 3);
  }
}
