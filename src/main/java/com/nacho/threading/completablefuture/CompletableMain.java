package com.nacho.threading.completablefuture;

import static java.util.concurrent.CompletableFuture.allOf;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableMain {

  private static CompletableFuture<Void> completableWrite(final CompletableFuture<List<Product>> completableSearch) {
    final CompletableFuture<Void> completableWrite = completableSearch.thenAcceptAsync(new WriteTask());
    completableWrite.exceptionally(ex -> {
      System.out.println(new Date() + ": Main: Exception " + ex.getMessage());
      return null;
    });
    return completableWrite;
  }

  private static CompletableFuture<String> completableProductResult(final CompletableFuture<Product> completableBestRateProduct,
      final CompletableFuture<Product> completableBestSellingProduct) {
    final CompletableFuture<String> completableProductResult = completableBestSellingProduct.thenCombineAsync(completableBestRateProduct,
        (bestSellingProduct, bestRatedProduct) -> {
          System.out.println(new Date() + ": Main: Completable        product result: start");
          String ret = "The best selling product is " + bestSellingProduct.getTitle() + "\n";
          ret += "The best rated product is " + bestRatedProduct.getTitle();
          System.out.println(new Date() + ": Main: Completable product result: end");
          return ret;
        });
    return completableProductResult;
  }

  private static CompletableFuture<Product> completableBestSellingProduct(final CompletableFuture<List<Product>> loadFuture) {
    System.out.println(new Date() + ": Main: Then apply for best selling product....");
    final CompletableFuture<Product> completableBestSellingProduct = loadFuture.thenApplyAsync(resultList -> {
      System.out.println(new Date() + ": Main: Completable best selling: start");
      final Product bestProduct = resultList.stream() //
          .min(Comparator.comparingLong(Product::getSalesrank)) //
          .orElse(null);
      System.out.println(new Date() + ": Main: Completable best selling:    end");
      return bestProduct;
    });
    return completableBestSellingProduct;
  }

  private static CompletableFuture<Product> completableBestRateProduct(final CompletableFuture<List<Product>> loadFuture) {
    System.out.println(new Date() + ": Main: Then apply for best rated product....");
    final CompletableFuture<Product> completableBestRateProduct = loadFuture.thenApplyAsync(resultList -> {
      Product maxProduct = null;
      double maxScore = 0.0;
      System.out.println(new Date() + ": Main: Completable product:start");
      for (final Product product : resultList) {
        if (!product.getReviews().isEmpty()) {
          final double score = product.getReviews().stream().mapToDouble(review -> review.getValue()).average().getAsDouble();
          if (score > maxScore) {
            maxProduct = product;
            maxScore = score;
          }
        }
      }
      System.out.println(new Date() + ": Main: Completable product: end");
      return maxProduct;
    });
    return completableBestRateProduct;
  }

  private static CompletableFuture<List<String>> completableUsers(final CompletableFuture<List<Product>> loadFuture) {
    System.out.println(new Date() + ": Main: Then apply for users");
    final CompletableFuture<List<String>> completableUsers = loadFuture.thenApplyAsync(resultList -> {
      System.out.println(new Date() + ": Main: Completable users: start");
      final List<String> users = resultList.stream() //
          .flatMap(p -> p.getReviews().stream()) //
          .map(review -> review.getUser()) //
          .distinct() //
          .collect(Collectors.toList());
      System.out.println(new Date() + ": Main: Completable users: end");
      return users;
    });
    return completableUsers;
  }

  public static void main(final String[] args) {

    final Path file = Paths.get("data", "category");
    System.out.println(new Date() + ": Main: Loadingproducts");

    final CompletableFuture<List<Product>> loadFuture = CompletableFuture.supplyAsync(new LoadTask(file));

    System.out.println(new Date() + ": Main: Then apply for search");

    final CompletableFuture<List<Product>> completableSearch = loadFuture.thenApplyAsync(new SearchTask("love"));
    final CompletableFuture<Void> completableWrite = completableWrite(completableSearch);
    final CompletableFuture<List<String>> completableUsers = completableUsers(loadFuture);
    final CompletableFuture<Product> completableBestRateProduct = completableBestRateProduct(loadFuture);
    final CompletableFuture<Product> completableBestSellingProduct = completableBestSellingProduct(loadFuture);
    final CompletableFuture<String> completableProductResult = completableProductResult(completableBestRateProduct,
        completableBestSellingProduct);
    System.out.println(new Date() + ": Main: Waiting for results");

    final CompletableFuture<Void> finalCompletableFuture = allOf(completableProductResult, completableUsers, completableWrite);
    finalCompletableFuture.join();

    try {
      System.out.println("Number of loaded products: " + loadFuture.get().size());
      System.out.println("Number of found products: " + completableSearch.get().size());
      System.out.println("Number of users: " + completableUsers.get().size());
      System.out.println("Best rated product: " + completableBestRateProduct.get().getTitle());
      System.out.println("Best selling product: " + completableBestSellingProduct.get().getTitle());
      System.out.println("Product result: " + completableProductResult.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}