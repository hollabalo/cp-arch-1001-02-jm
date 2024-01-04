/**
 * @author johnmichael.gerona
 * @created 1/4/24
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

public class ATMSystem {

    private BankAccount account;

    public static void main(String[] args) {
        // set dummy account
        BankAccount account = new BankAccount(new BigDecimal("5000.00"));

        // initialize system
        ATMSystem a = new ATMSystem(account);

        // render texts
        boolean run = true;
        Scanner scan = null;
        while(run) {
            renderHomeScreen();
            scan = new Scanner(System.in);
            switch(scan.nextInt()) {
                case 1: deposit(a); break;
                case 2: withdraw(a); break;
                case 3: balance(a); break;
                case 4: run = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
        scan.close();
        System.out.println("Exiting the ATM Simulation. Goodbye!");
    }

    private static void renderHomeScreen() {
        String[] homeScreenText = {
                "\n",
                "Welcome to the ATM Simulation",
                "Options:",
                "1. Deposit",
                "2. Withdrawal",
                "3. Check Balance",
                "4. Exit"
        };
        for (String text : homeScreenText) {
            System.out.println(text);
        }
    }

    private static void deposit(ATMSystem a) {
        BankAccount account = a.account;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the deposit amount:");
        String inputAmount = scan.nextLine();

        try {
            BigDecimal newBal = a.account.deposit(new BigDecimal(inputAmount));
            System.out.println("Deposit successful. New balance: " + newBal);
        } catch(AmountException e) {
            System.out.println(e.getMessage() + ". Please try again. Returning to main menu.");
        } catch(Exception e) {
            System.out.println("Invalid input. Please try again. Returning to main menu.");
        }
    }

    private static void withdraw(ATMSystem a) {
        BankAccount account = a.account;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the withdraw amount:");
        String inputAmount = scan.nextLine();

        try {
            BigDecimal newBal = a.account.withdraw(new BigDecimal(inputAmount));
            System.out.println("Withdraw successful. New balance: " + newBal);
        } catch(AmountException e) {
            System.out.println(e.getMessage() + ". Please try again. Returning to main menu.");
        } catch(Exception e) {
            System.out.println("Invalid input. Please try again. Returning to main menu.");
        }
    }

    private static void balance(ATMSystem a) {
        BankAccount account = a.account;
        System.out.println("Account balance: " + a.account.getBalance());
    }

    public ATMSystem(BankAccount account) {
        this.account = account;
    }

}
