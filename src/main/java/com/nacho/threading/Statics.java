package com.nacho.threading;

import java.util.ArrayList;
import java.util.List;

public class Statics {

  public static final List<Integer> LIST = new ArrayList<>();

  static {
    System.out.println(Thread.currentThread().getName() + " - " + "LOADING");
    for (int i = 0; i < Integer.MAX_VALUE / 80; i++) {
      LIST.add(i);
    }
    System.out.println(Thread.currentThread().getName() + " - " + "FINISHED");
  }

  public static void main(final String[] args) throws InterruptedException {
    final Runnable r = () -> {
      System.out.println(Thread.currentThread().getName() + " - " + System.identityHashCode(Statics.LIST) + " - " + Statics.LIST.size());
    };

    final Thread t1 = new Thread(r, "THREAD-1");
    final Thread t2 = new Thread(r, "THREAD-2");

    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
}
