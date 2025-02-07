package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Supplier {
    public Supplier(int ID, String name, String address, String phoneNumber, String email, double priceForProduct) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.priceForProduct = priceForProduct;

    }
    @Setter
    private Inventory inventory;
    private int ID = 0;
    @Getter
    private String name;
    @Getter
    private String address;
    @Getter
    private String phoneNumber;
    @Getter
    private String email;
    @Getter
    private double priceForProduct;

    public Supplier(String name, String address, String phone, String email, double priceForProduct) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phone;
        this.email = email;
        this.priceForProduct = priceForProduct;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Name of supplier: " + name);
    }

    public void setAddress(String address) {
        this.address = address;
        System.out.println("Address of supplier: " + address);
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        System.out.println("Phone number of supplier: " + phoneNumber);
    }
    public void setEmail(String email) {
        this.email = email;
        System.out.println("Email of supplier: " + email);
    }
    public void setPriceForProduct(double priceForProduct) {
        this.priceForProduct = priceForProduct;
        System.out.println("Price for cargo: " + priceForProduct);
    }

    public void getInventory() {
        System.out.println(inventory.toString());
    }

    public void countPriceForProduct(Product product) {
        double price = (product.getPrice()+ priceForProduct)*product.getQuantity();
        System.out.println("Price for product " + product.getName() + " is: " + price);
    }

    public void countPriceForProduct(String productName) {
        Product product = inventory.getProductByName(productName);
        if (product == null) {
            System.out.println("Product not found");
            return;
        }
        double price = (product.getPrice()+ priceForProduct)*product.getQuantity();
        System.out.println("Price for product " + product.getName() + " is: " + price);
    }

    public int getSupplierID() {
        return ID;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Double.compare(getPriceForProduct(), supplier.getPriceForProduct()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPriceForProduct());
    }

    @Override
    public String toString() {
        return "Supplier {" +
                "name='" + getName() + '\'' +
                ", ID=" + getSupplierID() +
                ", Address=" + getAddress() +
                ", Phone=" + getPhoneNumber() +
                ", Email=" + getEmail() +
                '}';
    }
}
