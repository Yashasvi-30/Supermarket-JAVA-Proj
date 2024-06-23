package people;

public class Cashier {
    private int cashierId;
    private String name;

    public Cashier(int id, String name) {
        this.cashierId = id;
        this.name = name;
    }

    public int getCashierId() {
        return cashierId;
    }

    public String getCashierName() {
        return name;
    }

    
}

