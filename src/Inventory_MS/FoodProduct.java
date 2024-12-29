package Inventory_MS;

public final class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String name, String expirationDate) {
        super(name);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Expiration date: " + expirationDate);
    }

    @Override
    public String toString() {
        return "FoodProduct {" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", expirationDate='" + getExpirationDate() + '\'' +
                '}';
    }
}
