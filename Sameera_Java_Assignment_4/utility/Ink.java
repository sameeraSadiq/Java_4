

package utility;
import java.util.ArrayList;
import objects.*;

public class Ink {
  
  // ANSI escape codes for colors
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";

  public Ink() {
    // do nothing
  }

  public void printWelcome() {
    System.out.println(ANSI_GREEN + "*** Welcome to StockUP beta ***" + ANSI_RESET + "\n");
  }

  public void printGoodday() {
    System.out.println(ANSI_GREEN + "*** Richer Every Day with stockUP ***" + ANSI_RESET + "\n");
  }

  public void printStock(Stock stock) {
    System.out.printf("Name: %s\nSymbol: %s\nPrice: $%.2f",
      stock.getName(), stock.getSymbol(), stock.getPrice());
    System.out.println("\nHow many units of this stock would you like?? ");
  }

  public void printPortfolio(ArrayList<Stock> stocks, double networth, 
    double balance) {
    for(int i = 0; i < stocks.size(); i++) {
      System.out.printf("(%d) Name: %s Symbol: %s Price: $%.2f Qty: %d\n",
        i + 1,
        stocks.get(i).getName(),
        stocks.get(i).getSymbol(),
        stocks.get(i).getPrice(),
        stocks.get(i).getQty());
    }
    System.out.printf("Networth: $%.2f\n", networth);
    System.out.printf("Balance: $%.2f\n", balance);
  }

  public void printMarket(ArrayList<Stock> stocks) {
    for(int i = 0; i < stocks.size(); i++) {
      System.out.printf("(%d) Name: %s Symbol: %s Price: $%.2f\n",
        i + 1,
        stocks.get(i).getName(),
        stocks.get(i).getSymbol(),
        stocks.get(i).getPrice());
    }
    System.out.println("Which stock would you like to buy?: ");
  }

  public void printMenu() {
    System.out.println("\u001B[36m(1) Show Portfolio\u001B[0m"); // Cyan color for option 1
    System.out.println("\u001B[35m(2) Show Stocks\u001B[0m"); // Purple color for option 2
    System.out.println("\u001B[33m(3) Add Funds\u001B[0m"); // Yellow color for option 3
    System.out.println("\u001B[33m(4) Close\u001B[0m"); // Yellow color for option 4
    System.out.println("\u001B[31m(5) Exit\u001B[0m"); // Red color for option 5
  }

  public void printAddFunds(double balance) {
    System.out.printf("Current balance: $%.2f\nAmount to add?: ", balance);
  }

  public void printWithdrawFunds(double balance) {
    System.out.printf("Current balance: $%.2f\nAmount to withdraw:", balance);
  }

  public void printStockSwapPrompt() {
    System.out.println("Enter the index of the stock you want to exchange.");
  }

  public void printStockSwapOptions(ArrayList<Stock>stocks) {
    System.out.println("Select the stock to swap for:");
    for(int i = 0; i < stocks.size(); i++) {
      System.out.printf("(%d) Name: %s Symbol: %s Price: $%.2f\n", i+1,
      stocks.get(i).getName(),
      stocks.get(i).getSymbol(),
      stocks.get(i).getPrice());
    }
      
  }

  
}