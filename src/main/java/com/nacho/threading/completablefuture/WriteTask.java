package com.nacho.threading.completablefuture;

import java.util.List;
import java.util.function.Consumer;

public class WriteTask implements Consumer<List<Product>> {
  @Override
  public void accept(final List<Product> products) {
  }
}