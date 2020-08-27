package com.sydorenko;

import java.util.Scanner;

public class BankAccount {
    private int balance;
    private int previousTransaction;
    private final String customerName;
    private final long customerId;

    public BankAccount(String customerName, long customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    private void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    private void withDraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    private void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrew: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    public void showMain() {
        char option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, " + customerName);
        System.out.println("Your id is " + customerId);
        System.out.println(System.lineSeparator());
        System.out.println("A. Check balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("Select an option: ");
            option = scanner.nextLine().toUpperCase().charAt(0);

            switch (option) {
                case 'A':
                    System.out.println("Balance is " + balance);
                    break;
                case 'B':
                    System.out.print("Enter an amount of deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    scanner.nextLine();
                    break;
                case 'C':
                    System.out.print("Enter an amount of withdraw: ");
                    amount = scanner.nextInt();
                    withDraw(amount);
                    scanner.nextLine();
                    break;
                case 'D':
                    System.out.println("Previous transaction is " + previousTransaction);
                    break;
                case 'E':
                    System.out.println(System.lineSeparator());
                    break;
                default:
                    System.out.println("Wrong operation! Please try again");
            }

        } while (option != 'E');

        System.out.println("Have a nice day!");
    }
}
