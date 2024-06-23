package supermarket;
import java.util.*;

public class Supermarket {
    private static Product[] products = new Product[100]; // Assuming a maximum of 100 products
    private static int productCount = 0;
    private static double total_price = 0;

    // Add a product to the supermarket's product list
    public static void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
        } else {
            System.out.println("Product inventory is full. Cannot add more products.");
        }
    }

    // Remove a product from the supermarket's product list
    public static  boolean removeProduct(int productId) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductId() == productId) {
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                productCount--;
                break;
            }
        }
        return true;
    }

    // Get a list of all the products in the supermarket
    public static Product[] getProductList() {
        Product[] productList = Arrays.copyOf(products, productCount);
        return productList;
    }

    // Get the total price of all the products in the supermarket
    public static double getTotalPrice() {
        total_price = 0;
        for (int i = 0; i < productCount; i++) {
            total_price += products[i].getProductPrice() * products[i].getProductQuantity();
        }
        return total_price;
    }

    // Get a product by its ID
    public static  Product getProductById(int productId) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductId() == productId) {
                return products[i];
            }
        }
        return null; // Product not found
    }
}

