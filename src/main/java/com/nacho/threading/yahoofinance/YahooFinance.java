package com.nacho.threading.yahoofinance;

import java.io.IOException;
import java.util.Random;

public class YahooFinance {

  private static final Random rand = new Random();

  public static double getPrice(final String ticker) throws IOException {
//    final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
//
//    final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
//
//    // Date,Open,High,Low,Close,Volume,Adj Close
//    // 2011-03-17,336.83,339.61,330.66,334.64,23519400,334.64
//    final String discardHeader = reader.readLine();
//    final String data = reader.readLine();
//    final String[] dataItems = data.split(",");
//    final double priceIsTheLastValue = Double.valueOf(dataItems[dataItems.length - 1]);
    System.out.println("Getting price for: " + ticker);
    sleep(500);

    return rand.nextDouble();
  }

  private static void sleep(final long millis) {
    try {
      Thread.sleep(millis);
    } catch (final InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}