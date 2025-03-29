package com.mite.app;

import java.util.ArrayList;
import java.util.Scanner;
   public   class Customer {
        private static int nextCustomerID = 0000 ;
        private String name;
        private String gender;
        private String phonenumber;
        private String address;
        private int customerID ;
        private ArrayList<Account> accounts;

        public Customer(String name, String gender, String phonenumber, String address) {
            this.name = name;
            this.gender = gender;
            this.phonenumber = phonenumber;
            this.address = address;
            this.customerID = nextCustomerID++;
            this.accounts = new ArrayList<>();
        }

        public void createAccount() {
            int newAccountNumber = customerID * 10 + accounts.size() + 1;
            Account newAccount = new SavingsAccount(newAccountNumber);
            accounts.add(newAccount);
            System.out.println("Account has been created");
            System.out.println("Account Number: " + newAccountNumber);
        }

        public boolean hasAccounts() {
            return !accounts.isEmpty();
        }

        public void listAccounts() {
            if (accounts.isEmpty()) {
                System.out.println("No accounts found for this customer!");
                return;
            }

            System.out.println("\nAccounts for customer " + name + " (ID: " + customerID + "):");
            int index = 1;
            for (Account account : accounts) {
                System.out.println(index + ". Savings Account (Acc#: " + account.getAccountNumber() + ")");
                index++;
            }
        }

        public void transactions(Scanner scanner) {
            if (accounts.isEmpty()) {
                System.out.println("No accounts found!");
                return;
            }


            listAccounts();
            System.out.print("Select account number (1-" + accounts.size() + "): ");
            int accountIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (accountIndex < 1 || accountIndex > accounts.size()) {
                System.out.println("Invalid account selection!");
                return;
            }

            Account selectedAccount = accounts.get(accountIndex - 1);

            System.out.println("\nChoose transaction type:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");

            int transaction = scanner.nextInt();
            double amount = 0;

            if (transaction == 1 || transaction == 2) {
                System.out.println("Enter amount:");
                amount = scanner.nextDouble();
            }

            switch (transaction) {
                case 1:
                    selectedAccount.deposit(amount);
                    break;
                case 2:
                    selectedAccount.withdraw(amount);
                    break;
                case 3:
                    System.out.println("Current balance: " + selectedAccount.getbalance());
                    break;
                default:
                    System.out.println("Invalid transaction");
                    break;
            }
        }

        public int getCustomerID() {
            return customerID;
        }

        public void displayCustomer() {
            System.out.println("\n*** Customer details ***");
            System.out.println("Customer ID: " + customerID);
            System.out.println("Customer name: " + name);
            System.out.println("Customer gender: " + gender);
            System.out.println("Customer phone number: " + phonenumber);
            System.out.println("Customer address: " + address);

            if (!accounts.isEmpty()) {
                System.out.println("\nAccount Information:");
                for (Account account : accounts) {
                    System.out.println("--------------------");
                    account.displayinfo();
                }
            } else {
                System.out.println("No accounts created yet");
         //hi
                }
        }
    }
