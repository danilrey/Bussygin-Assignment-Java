package entities;

import lombok.Getter;

@Getter
public class Inventory {
    public Inventory(String name) {
        this.name = name;
        ID++;
        System.out.println("Inventory " + name + " created with ID: " + ID);
    }
    private Product[] products;
    private static int ID = 0;
    private final int InventoryID = ID+1;
    private final String name;
    private String address;
    private String phoneNumber;
    private String email;
    public void setAddress(String address) {
        this.address = address;
        System.out.println("Address of inventory: " + address);
    }
    public void addProducts(Product[] product) {
        this.products = product;
        System.out.println("Products added to inventory");
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        System.out.println("Phone number of inventory: " + phoneNumber);
    }
    public void setEmail(String email) {
        this.email = email;
        System.out.println("Email of inventory: " + email);
    }
    public void getProductsInPriceOrder() {
        for (int i = 0; i < products.length; i++) {
            for (int j = i + 1; j < products.length; j++) {
                if (products[i].getPrice() < products[j].getPrice()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
    public void getProductsInQuantityOrder() {
        for (int i = 0; i < products.length; i++) {
            for (int j = i + 1; j < products.length; j++) {
                if (products[i].getQuantity() < products[j].getQuantity()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Inventory {" +
                "name='" + getName() + '\'' +
                ", ID=" + getInventoryID() +
                ", Phone=" + getPhoneNumber() +
                ", Email=" + getEmail() +
                '}';
    }
}
