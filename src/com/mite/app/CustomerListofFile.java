//package com.mite.app;
//
//import java.io.*;
//import java.util.*;
//
//class Customer {
//    private String name;
//    private String gender;
//
//    // Default constructor
//    public Customer() {
//        this.name = "Default Name"; // You can set a default name or leave it empty
//        this.gender = "Unknown";     // You can set a default gender or leave it empty
//    }
//
//    // Parameterized constructor
//    public Customer(String name, String gender) {
//        this.name = name;
//        this.gender = gender;
//    }
//
//    @Override
//    public String toString() {
//        return "Name: " + name + ", Gender: " + gender;
//    }
//}
//
//public class CustomerListofFile {
//    public static void main(String[] args) {
//        // Creating some customer objects
//        List<Customer> customers = new ArrayList<>();
//        customers.add(new Customer("Alice", "Female"));
//        customers.add(new Customer("Bob", "Male"));
//
//        // Specify the file path on the D: drive
//        String filePath = "D:\\customers.txt";  // or "D:/customers.txt"
//
//        // Write the list to the file
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            for (Customer customer : customers) {
//                writer.write(customer.toString());  // This calls the overridden toString() method
//                writer.newLine();  // Add a newline after each customer entry
//            }
//            System.out.println("Customer list written to D:\\customers.txt successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}