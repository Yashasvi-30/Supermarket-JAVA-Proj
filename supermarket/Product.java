package supermarket;

public class Product {
    private int product_id;
    private String product_name;
    private double product_price;
    private int product_quantity;
    
//Constructor
    public Product(int id, String name, double price, int quantity) 
    {
        this.product_id = id;
        this.product_name = name;
        this.product_price = price;
        this.product_quantity = quantity;
    }

    public int getProductId() {
        return product_id;
    }

    public String getProductName() {
        return product_name;
    }

    public double getProductPrice() {
        return product_price;
    }

    public int getProductQuantity() {
        return product_quantity;
    }
}



