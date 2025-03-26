package com.mite.app;

import java.io.*;
import java.util.*;

public class CustomerListofFile {
    public static void main(String[] args) {
        // Creating some customer objects
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("abc","male",))

        // Specify the file path on the D: drive
        String filePath = "D:\\customers.txt";  // or "D:/customers.txt"

        // Write the list to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                writer.write(customer.toString());  // This calls the overridden toString() method
                writer.newLine();  // Add a newline after each customer entry
            }
            System.out.println("Customer list written to D:\\customers.txt successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
