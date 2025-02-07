package com.example.demo;

import controllers.JsonController;
import controllers.interfaces.IController;
import data.PostgresDB;
import data.interfaces.IDB;
import entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import repositories.interfaces.ISupplierRepository;
import repositories.supplierRepository;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return _ -> {
            Product product1 = new ElectronicProduct("Laptop", 36);
            product1.setPrice(1000);
            product1.setQuantity(5);
            Product product2 = new ElectronicProduct("Phone", 24);
            product2.setPrice(500);
            product2.setQuantity(10);
            Product product3 = new ElectronicProduct("Tablet", 12);
            product3.setPrice(300);
            product3.setQuantity(7);
            Product product4 = new ElectronicProduct("PC", 0);
            product4.setPrice(1500);
            product4.setQuantity(3);
            Product product5 = new ElectronicProduct("Smart Watch", 6);
            product5.setPrice(200);
            product5.setQuantity(15);
            Product food1 = new FoodProduct("Apple", "01.01.2025");
            food1.setPrice(1);
            food1.setQuantity(100);
            Product food2 = new FoodProduct("Banana", "01.10.2026");
            food2.setPrice(2);
            food2.setQuantity(50);
            Product food3 = new FoodProduct("Orange", "20.12.2029");
            food3.setPrice(3);
            food3.setQuantity(30);
            Product food4 = new FoodProduct("Pineapple", "15.05.2024");
            food4.setPrice(5);
            food4.setQuantity(20);
            Product food5 = new FoodProduct("Watermelon", "10.07.2023");
            food5.setPrice(10);
            food5.setQuantity(10);

            //setting inventory
            Inventory inventory = new Inventory("Shop");
            inventory.setAddress("New York");
            inventory.setPhoneNumber("123456789");
            inventory.setEmail("12345@mail.com");
            inventory.addProducts(new Product[]{product1, product2, product3, product4, product5,
                    food1, food2, food3, food4, food5});
            inventory.getProductsInPriceOrder();
            inventory.getProductsInQuantityOrder();

            IDB db = PostgresDB.getInstance();
            ISupplierRepository repo = new supplierRepository(db, inventory);
            IController controller = new JsonController(repo);
//            IController controller = new SupplierController(repo);
            MyApplication app = new MyApplication(controller);
            app.start();
        };
    }
}