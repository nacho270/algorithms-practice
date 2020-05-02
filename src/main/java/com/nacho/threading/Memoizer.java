package com.nacho.threading;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Memoizer<A, V> {

  private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

  public V compute(final A key) {
    while (true) {
      Future<V> f = cache.get(key);
      if (f == null) {
        final Callable<V> call = () -> null;
        final FutureTask<V> futureTask = new FutureTask<>(call);
        f = cache.putIfAbsent(key, futureTask);
        if (f == null) {
          f = futureTask;
          futureTask.run();
        }
      }
      try {
        return f.get();
      } catch (final Exception e) {
        cache.remove(key, f);
      }
    }
  }
}
