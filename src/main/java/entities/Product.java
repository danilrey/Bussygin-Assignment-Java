package entities;

import java.util.Objects;

public abstract class Product {
    private static int ID = 0;
    public Product(String name) {
        this.name = name;
        ++ID;
        System.out.println("Product " + name + " created with ID: " + ID);
    }
    private final int ProductID = ID+1;
    private final String name;
    private double price;
    private int quantity = 1;
    public void setPrice(double price) {
        this.price = price;
        System.out.println("Price of product: " + price);
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        System.out.println("Quantity of product: " + quantity);
    }
    public void sellProduct() {
        if (quantity > 0) {
            quantity--;
            System.out.println("Product " + name + " sold, quantity left: " + quantity);
        } else {
            System.out.println("Product " + name + " is out of stock");
        }
    }
    public void buyProduct() {
        quantity++;
        System.out.println("Product " + name + " bought, quantity left: " + quantity);
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getProductID() {
        return ProductID;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(getPrice(), product.getPrice()) == 0 && getQuantity() == product.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), getQuantity());
    }
}
