package entities;

import entities.Inventory;
import entities.Product;

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
    private Inventory inventory;
    private int ID = 0;
    private final String name;
    private String address;
    private String phoneNumber;
    private String email;
    private double priceForProduct;

    public Supplier(String name, String address, String phone, String email, double priceForProduct) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phone;
        this.email = email;
        this.priceForProduct = priceForProduct;
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
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        System.out.println("Inventory set for supplier");
    }
    public void getInventory() {
        inventory.toString();
    }
    public void countPriceForProduct(int productID) {
        Product product = inventory.getProductById(productID);
        System.out.println("Price for product " + product.getName() + " is: " + (product.getPrice()+ priceForProduct)*product.getQuantity());
    }
    public void getInfo() {
        System.out.println("Supplier ID: " + ID + "\nSupplier name: " + name + "\nSupplier address: " + address + "\nSupplier phone number: " + phoneNumber + "\nSupplier email: " + email);
    }
    public void deleteSupplier() {
        System.out.println("Supplier " + name + " deleted");
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public int getSupplierID() {
        return ID;
    }
    public double getPriceForProduct() {
        return priceForProduct;
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
                ", Phone=" + getPhoneNumber() +
                ", Email=" + getEmail() +
                '}';
    }
}
