


import objects.*;
import utility.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StockUp {
  private static final Scanner input = new Scanner(System.in);
  private static final Ink ink = new Ink();
  private static final Validator validator = new Validator();
  private static final Market market = new Market();
  private static Portfolio portfolio;

  private static int min = 1; // used for menu selections
  private static int max = 5; // we need a way to set that based on menu items!!
  private static boolean isDone = false;

  public static void main(String[] args) {

    ink.printWelcome();

    // sets the starting balance for our portfolio
    System.out.println("How much money are you starting with?");
    double deposit = validator.fundValidation(ink, input, 0);
    portfolio = new Portfolio(deposit);

    seedStocks(); // seed out stocks with some pretend stocks
    seedMarket(); // creates our test Market stocks

    while(!isDone) {
      int choice = validator.selValidation(ink, input, min, max);
    
      switch (choice) {
        case 1: // print portfolio
          ink.printPortfolio(portfolio.getStocks(), portfolio.calculateNetWorth(),
            portfolio.getBalance());
          break;
        case 2: // print market
          ink.printMarket(market.getStocks());
          break;
        case 3: // add funds
          double addAmount = validator.fundValidation(ink, input, 0);
          portfolio.addFunds(addAmount);
          // print the new balance
          System.out.printf("New balance: $%.2f\n", portfolio.getBalance());
          break;
        case 4:
          portfolio.closeAccount();
          System.out.println("Account closed. All stocks have been sold.");
          break;
        case 5:
        isDone = true;
        break;
      }
    }
    ink.printGoodday();
  }

  public static void seedStocks() {
    // the purpose is to create some TEST stocks!
    Stock stock = new Stock("Microsoft", "MSFT", 420.00, 100);
    portfolio.addStock(stock);
    stock = new Stock("Uber", "UBR", 120.00, 50);
    portfolio.addStock(stock);
    stock = new Stock("Nvidia", "NVD", 250.00, 90);
    portfolio.addStock(stock);
  }

  public static void seedMarket() {
    ArrayList<Stock> stocks = new ArrayList<>();
    // the purpose is to create some TEST stocks for the Market
    Stock stock = new Stock("Adobe", "ADB", 20.00, 0);
    stocks.add(stock);
    stock = new Stock("Netflix", "NFX", 120.00, 0);
    stocks.add(stock);
    stock = new Stock("Apple", "APL", 250.00, 0);
    stocks.add(stock);
    stock = new Stock("Disney", "MOUSE", 1250.00, 0);
    stocks.add(stock);
    stock = new Stock("Microsoft", "MSFT", 420.00, 0);
    stocks.add(stock);
    stock = new Stock("Uber", "UBR", 120.00, 0);
    stocks.add(stock);
    stock = new Stock("Nvidia", "NVD", 900.00, 0);
    stocks.add(stock);
    market.setStocks(stocks);
  }
}