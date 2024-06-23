

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import supermarket.Supermarket;
import people.Customer;
import supermarket.Product;

public class SupermarketManagementSystem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Welcome to the Supermarket Management System.");

        // Initialize a variable to store the current cashier ID.
        int cashierId = -1;

        // Continuously loop until a valid cashier ID is entered.
        
            System.out.print("Please enter your Cashier ID: ");
            cashierId = scanner.nextInt();
            scanner.nextLine(); // Consume newline


        

        // Main menu loop
        while (true) {
            printMainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Print Bill
                    Customer customer = getCustomerDetails(scanner);
                    System.out.println("Customer Details:");
                    System.out.println("Customer ID: " + customer.getCustomerId());
                    System.out.println("Customer Name: " + customer.getCustomerName());
                    System.out.println("Customer Phone No: " + customer.getCustomerPhoneNo());

                    List<Product> cart = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter Product ID (0 to finish): ");
                        int productId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (productId == 0) {
                            break; // Exit the loop when 0 is entered.
                        }

                        Product product = getProductById(productId);
                        if (product != null) {
                            cart.add(product);
                            System.out.println("Added Product: " + product.getProductName());
                        } else {
                            System.out.println("Product not found.");
                        }
                    }

                    // Calculate and print the bill
                    double totalBill = calculateBill(cart);
                    System.out.println("Total Bill: $" + totalBill);
                    break;

                case 2:
                    // Add Product
                    Product product = getProductAttributes(scanner);
                    Supermarket.addProduct(product);
                    System.out.println("Product Added.");
                    break;

                case 3:
                    // Remove Product
                    System.out.print("Enter Product ID to Remove: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (Supermarket.removeProduct(productId)) {
                        System.out.println("Product Removed.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    // Get Product List
                    Product[] productList = Supermarket.getProductList();
                    System.out.println("Product List:");
                    for (Product p : productList) {
                        System.out.println("Product ID: " + p.getProductId());
                        System.out.println("Product Name: " + p.getProductName());
                        System.out.println("Product Price: $" + p.getProductPrice());
                        System.out.println("Product Quantity: " + p.getProductQuantity());
                    }
                    break;

                case 5:
                    // Get Total Price
                    double totalPrice = Supermarket.getTotalPrice();
                    System.out.println("Total Price: $" + totalPrice);
                    break;

                case 6:
                    // Get Product by ID
                    System.out.print("Enter Product ID: ");
                    int prodId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Product productById = getProductById(prodId);
                    if (productById != null) {
                        System.out.println("Product Details:");
                        System.out.println("Product ID: " + productById.getProductId());
                        System.out.println("Product Name: " + productById.getProductName());
                        System.out.println("Product Price: $" + productById.getProductPrice());
                        System.out.println("Product Quantity: " + productById.getProductQuantity());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 7:
                    // Logout Cashier
                    System.out.println("Logged out Cashier with ID: " + cashierId);
                    // Return to the login screen or exit the program if needed.
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Customer getCustomerDetails(Scanner scanner) {
        System.out.println("Enter Customer Details:");

        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Customer Phone Number: ");
        String customerPhoneNumber = scanner.nextLine();

        // Create a Customer object with the entered details
        Customer customer = new Customer(customerId, customerName, customerPhoneNumber);

        System.out.println("Customer Details captured.");
        return customer;
    }

    private static Product getProductById(int productId) {
        Product[] productList = Supermarket.getProductList();
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                return product; // Found the product with the specified ID
            }   
        }

        // Product with the specified ID was not found
        return null;
    }

    private static double calculateBill(List<Product> cart) {
        double totalPrice = 0;

        System.out.println("Bill Details:");
        for (Product product : cart) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
         
            System.out.println("Product Quantity: " + product.getProductQuantity());

            double productTotalPrice = product.getProductPrice() * product.getProductQuantity();
            System.out.println("Product Total Price: $" + productTotalPrice);

            totalPrice += productTotalPrice;
            System.out.println();
        }

        System.out.println("Total Price: $" + totalPrice);
        return totalPrice;
    }



    private static Product getProductAttributes(Scanner scanner) {
        System.out.println("Enter Product Attributes:");

        System.out.print("Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Product Name: ");
        String productName = scanner.nextLine();

        System.out.print("Product Price: ");
        double productPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Product Quantity: ");
        int productQuantity = scanner.nextInt();

        // Create a Product object with the entered attributes
        return new Product(productId, productName, productPrice, productQuantity);
    }

    private static void printMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Print Bill");
        System.out.println("2. Add Product");
        System.out.println("3. Remove Product");
        System.out.println("4. Get Product List");
        System.out.println("5. Get Total Price");
        System.out.println("6. Get Product by ID");
        System.out.println("7. Logout Cashier");
        System.out.print("Enter your choice: ");
    }
}
