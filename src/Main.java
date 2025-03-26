import com.mite.app.SavingsAccount;
import com.mite.app.Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;
// main functiom
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Customer> customers = new LinkedList<>();

        while (true) {
            System.out.println("\nBanking Menu");
            System.out.println("1. Register Customer");
            System.out.println("2. Create Account");
            System.out.println("3. List Customer Accounts");
            System.out.println("4. Transactions");
            System.out.println("5. Display Customer Details");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();

                    System.out.println("Enter your gender:");
                    String gender = scanner.nextLine();

                    System.out.println("Enter your address:");
                    String address = scanner.nextLine();

                    String phonenumber;
                    while (true) {
                        System.out.println("Enter the phone number:");
                        phonenumber = scanner.nextLine();
                        if (phonenumber.matches("\\d{10}")) {
                            break;
                        }
                        System.out.println("Invalid phone number");
                    }

                    Customer newCustomer = new Customer(name, gender, phonenumber, address);
                    customers.add(newCustomer);
                    System.out.println("Customer registered successfully");
                    System.out.println("Your customer ID is: " + newCustomer.getCustomerID());
                    break;

                case 2:
                    System.out.println("Enter customer ID:");
                    int custID = scanner.nextInt();
                    scanner.nextLine();

                    Customer customer = findCustomer(customers, custID);
                    if (customer != null) {
                        customer.createAccount();
                    } else {
                        System.out.println("No customer exists with that ID");
                    }
                    break;

                case 3:
                    System.out.println("Enter customer ID:");
                    int listCustID = scanner.nextInt();
                    scanner.nextLine();

                    Customer listCustomer = findCustomer(customers, listCustID);
                    if (listCustomer != null) {
                        listCustomer.listAccounts();
                    } else {
                        System.out.println("No customer exists with that ID");
                    }
                    break;

                case 4:
                    System.out.println("Enter customer ID:");
                    int transCustID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Customer transCustomer = findCustomer(customers, transCustID);
                    if (transCustomer != null) {
                        if (transCustomer.hasAccounts()) {
                            transCustomer.transactions(scanner);
                        } else {
                            System.out.println("This customer doesn't have any accounts yet!");
                        }
                    } else {
                        System.out.println("No customer found with that ID.");
                    }
                    break;

                case 5:
                    System.out.println("Enter customer ID:");
                    int displayCustID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Customer displayCustomer = findCustomer(customers, displayCustID);
                    if (displayCustomer != null) {
                        displayCustomer.displayCustomer();
                    } else {
                        System.out.println("No customer found with that ID.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using our banking system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                case 7:
                    String filePath = "D://customers.txt";

                    // Write the list to the file
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                        for (Customer customertemp : customers) {
                            writer.write(customertemp.toString());
                            writer.newLine();  // Add a newline after each customer entry
                        }
                        System.out.println("Customer list written to file successfully.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Customer findCustomer(LinkedList<Customer> customers, int customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null;
    }
}