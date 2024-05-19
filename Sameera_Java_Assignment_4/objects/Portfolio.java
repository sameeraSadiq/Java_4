
package objects;

import java.util.ArrayList;
import java.util.Calendar;

public class Portfolio {

  private Calendar openDate = Calendar.getInstance();
  private Calendar closeDate = Calendar.getInstance(); 
  private double balance;
  private double networth;
  private ArrayList<Stock> stocks = new ArrayList<>();
  
  public Portfolio(double deposit) {
    this.balance = deposit;
    this.networth = 0.0;
  }

  // Calculate net worth new
  public double calculateNetWorth() {
    double total = 0;
    for (Stock stock: stocks) {
      total += stock.getPrice() * stock.getQty();
    }

    this.networth = total;
    return this.networth;
  }

  // close account
  public void closeAccount() {
    for(Stock stock: stocks) {
      balance += stock.getPrice() * stock.getQty();
    }
    stocks.clear();
  }

  // withdrwafunds
  public void withdrawFunds(double amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
    }
  }

  // STOCKS
  public void addStock(Stock stock) {
    stocks.add(stock);
  }

  public void buyStock(Stock stock, int qty, double purchaseAmount) {
    if (purchaseAmount <= balance) {
      balance -= purchaseAmount;
      stock.setQty(qty);
      stocks.add(stock);
    }
  }

  public void sellStock(int idx) {
    if (idx >= 0 && idx < stocks.size()) {
      double price = stocks.get(idx).getPrice();
      int qty = stocks.get(idx).getQty();
      double amount = price * qty;
      balance += amount;
      stocks.remove(idx);
    }
  }

  // GETTERS
  public Calendar getOpenDate() {
    return openDate;
  }
  public Calendar getCloseDate() {
    return closeDate;
  }
  public double getBalance() {
    return balance;
  }
  public double getNetworth() {
    return networth;
  }
  public ArrayList<Stock> getStocks() {
    return stocks;
  }

  // SETTERS
  public void setCloseDate() {
    this.closeDate = Calendar.getInstance();
  }
  public void addFunds(double amount) {
    if(amount > 0)
      this.balance += amount;
  }
  
}