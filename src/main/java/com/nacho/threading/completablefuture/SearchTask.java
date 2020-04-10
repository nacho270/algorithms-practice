package com.nacho.threading.completablefuture;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchTask implements Function<List<Product>, List<Product>> {

  private String query;

  public SearchTask(final String query) {
    this.query = query;
  }

  @Override
  public List<Product> apply(final List<Product> products) {
    System.out.println(new Date() + ": CompletableTask: start");
    final List<Product> ret = products.stream() //
        .filter(product -> product.getTitle().toLowerCase().contains(query)) //
        .collect(Collectors.toList());
    System.out.println(new Date() + ": CompletableTask: end:" + ret.size());
    return ret;
  }
}