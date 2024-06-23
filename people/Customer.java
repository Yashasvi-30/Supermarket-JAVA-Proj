package people;

public class Customer {
    private int customer_id;
    private String customer_name;
    private String customer_phoneno;

    public Customer(int id, String name, String phone) {
        this.customer_id = id;
        this.customer_name = name;
        this.customer_phoneno = phone;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public String getCustomerPhoneNo() {
        return customer_phoneno;
    }


}


