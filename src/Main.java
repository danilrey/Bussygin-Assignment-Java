import Inventory_MS.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop");
        product1.setPrice(1000);
        product1.setQuantity(5);
        product1.getInfo();
        Product product2 = new Product("Phone");
        product2.setPrice(500);
        product2.setQuantity(10);
        product2.getInfo();
        Product product3 = new Product("Tablet");
        product3.setPrice(300);
        product3.setQuantity(7);
        product3.getInfo();
        Product product4 = new Product("PC");
        product4.setPrice(1500);
        product4.setQuantity(3);
        product4.getInfo();
        Product product5 = new Product("Smart Watch");
        product5.setPrice(200);
        product5.setQuantity(15);
        product5.getInfo();
        Inventory inventory = new Inventory("Shop");
        inventory.setAddress("New York");
        inventory.setPhoneNumber("123456789");
        inventory.setEmail("12345@mail.com");
        inventory.addProducts(new Product[]{product1, product2, product3, product4, product5});
        inventory.getInfo();
        inventory.getProductsInPriceOrder();
        inventory.getProductsInQuantityOrder();
        Supplier supplier = new Supplier("Supplier");
        supplier.setAddress("Los Angeles");
        supplier.setPhoneNumber("987654321");
        supplier.setEmail("efere@mail.com");
        supplier.setPriceForProduct(10);
        supplier.setInventory(inventory);
        supplier.getInventory();
        int ID = product3.getProductID();
        supplier.countPriceForProduct(ID);

    }
}