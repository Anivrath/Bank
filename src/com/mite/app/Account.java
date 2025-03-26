package com.mite.app;

public interface Account {
    void displayinfo();
    void deposit(double amount);
    void withdraw(double amount);
    double getbalance();
    int getAccountNumber();
    //String  AccountType;
}
