package com.nacho.threading.primes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ConcurrentPrimeFinder extends AbstractPrimeFinder {
  private final int poolSize;
  private final int numberOfParts;

  public ConcurrentPrimeFinder(final int thePoolSize, final int theNumberOfParts) {
    poolSize = thePoolSize;
    numberOfParts = theNumberOfParts;
  }

  @Override
  public int countPrimes(final int number) {
    int count = 0;
    try {
      final List<Callable<Integer>> partitions = new ArrayList<>();
      final int chunksPerPartition = number / numberOfParts;
      for (int i = 0; i < numberOfParts; i++) {
        final int lower = i * chunksPerPartition + 1;
        final int upper = i == numberOfParts - 1 ? number : lower + chunksPerPartition - 1;
        partitions.add(() -> countPrimesInRange(lower, upper));
      }
      final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
      final List<Future<Integer>> resultFromParts = executorPool.invokeAll(partitions, 10000, TimeUnit.SECONDS);
      executorPool.shutdown();
      for (final Future<Integer> result : resultFromParts) {
        count += result.get();
      }
    } catch (final Exception ex) {
      throw new RuntimeException(ex);
    }
    return count;
  }

  public static void main(final String[] args) {
    new ConcurrentPrimeFinder(6, 1000000).timeAndCompute(1000000);
  }
}