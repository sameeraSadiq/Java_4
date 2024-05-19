

package utility;

import java.util.Scanner;

public class Validator {
  
  public Validator() {
    // do nothing
  }

  public int selValidation(Ink ink, Scanner input, int min, int max) {
    boolean valid = false;
    int choice = 0;
    while(!valid) {
      ink.printMenu();
      try {
        choice = input.nextInt();
        if(choice >= min && choice <= max){
          valid = true;
        }
        else {
          System.out.println("Selection out of range!");
        }
      }
      catch (Exception e) {
        System.out.println("Please read the menu and make a valid selection!");
        valid = false; //  in case
      } 
      finally { // runs if there's an error or NOT!! always runs
        input.nextLine(); // clear the input
      }
    }
    return choice;
  }

  public double fundValidation(Ink ink, Scanner input, double balance) {
    double amount = 0;
    boolean valid = false;
    while(!valid) {
      ink.printAddFunds(balance);
      try {
        amount = input.nextDouble();
        if(amount > 0){
          valid = true;
        }
        else {
          System.out.println("Enter a positive number!");
        }
      } 
      catch (Exception e) {
        System.out.println("Please read the directions!");
        valid = false; // just in case
      } 
      finally { // runs if there's an error or NOT!! always runs
        input.nextLine(); // clear the input
      }
    }
    return amount;
  }

} // class