package com.mite.app;

public class SavingsAccount implements Account {
        private double balance;
        private int accountNumber;

        public SavingsAccount(int accountNumber) {
            this.balance = 100.0;
            this.accountNumber = accountNumber;
        }

        public void displayinfo() {
            System.out.println("Account type: Savings");
            System.out.println("Account number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
            if (amount > 0) {
                balance = balance + amount;
                System.out.println("Deposited: " + amount);
            } else {
                System.out.println("Invalid Deposit amount");
            }
        }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "balance=" + this.balance +
                ", accountNumber=" + this.accountNumber ;
                //"AccountType"+AccountType;//
    }

    public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance = balance - amount;
                System.out.println("Withdrawn amount: " + amount);
            } else {
                System.out.println("Insufficient balance");
            }
        }

        public double getbalance() {
            return balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }
    }

