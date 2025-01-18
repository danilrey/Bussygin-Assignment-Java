package Inventory_MS;

import java.util.Objects;

public class Supplier {
    public Supplier(String name) {
        this.name = name;
        ID++;
        System.out.println("Supplier " + name + " created with ID: " + ID);
    }
    private Inventory inventory;
    private static int ID = 0;
    private final int SupplierID = ID+1;
    private final String name;
    private String address;
    private String phoneNumber;
    private String email;
    private double priceForProduct;
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
        inventory.getInfo();
    }
    public void countPriceForProduct(int productID) {
        Product product = inventory.getProductById(productID);
        System.out.println("Price for product " + product.getName() + " is: " + (product.getPrice()+ priceForProduct)*product.getQuantity());
    }
    public void getInfo() {
        System.out.println("Supplier ID: " + SupplierID + "\nSupplier name: " + name + "\nSupplier address: " + address + "\nSupplier phone number: " + phoneNumber + "\nSupplier email: " + email);
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
        return SupplierID;
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
