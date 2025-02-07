package com.example.demo;

import controllers.interfaces.IController;
import entities.Supplier;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final IController controller;
    private final Scanner scan;

    public MyApplication(IController controller) {
        this.controller = controller;
        scan = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to my app");
            System.out.println("Select option:");
            System.out.println("1. Get all Suppliers");
            System.out.println("2. Get Supplier by id");
            System.out.println("3. Create Supplier");
            System.out.println("4. Update Supplier");
            System.out.println("5. Delete Supplier");
            System.out.println("6. Count price for product");
            System.out.println("0. Exit\n");
            try {
                System.out.println("Enter option 0-6");
                int option = scan.nextInt();
                if (option == 1) {
                    getAllSuppliersMenu();
                } else if (option == 2) {
                    getSupplierByIdMenu();
                } else if (option == 3) {
                    createSupplierMenu();
                } else if (option == 4) {
                    updateSupplierMenu();
                } else if (option == 5) {
                    deleteSupplierMenu();
                } else if (option == 6) {
                    countPriceForProductMenu();
                } else {
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                scan.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("********************");
        }
    }

    public void getAllSuppliersMenu() {
        String result = controller.getAllSuppliers();
        System.out.println(result);
    }

    public void getSupplierByIdMenu() {
        System.out.println("Enter ID:");
        int id = scan.nextInt();
        Supplier supplier = controller.getSupplier(id);
        String result = (supplier == null ? "Supplier was not found" : supplier.toString());
        System.out.println(result);
    }

    public void createSupplierMenu() {
        System.out.println("Enter name:");
        String name = scan.next();
        System.out.println("Enter address:");
        String address = scan.next();
        System.out.println("Enter phone number:");
        String phoneNumber = scan.next();
        System.out.println("Enter email:");
        String email = scan.next();
        System.out.println("Enter price for product:");
        double priceForProduct = scan.nextDouble();
        Supplier supplier = new Supplier(name,address,phoneNumber,email,priceForProduct);
        String result = String.valueOf(controller.createSupplier(supplier));
        System.out.println(result);
    }

    public void updateSupplierMenu() {
        System.out.println("Enter ID:");
        int id = scan.nextInt();
        Supplier supplier = controller.getSupplier(id);
        System.out.println("Choose what you want to update:");
        System.out.println("1. Name");
        System.out.println("2. Address");
        System.out.println("3. Phone number");
        System.out.println("4. Email");
        System.out.println("5. Price for product");
        int option = scan.nextInt();
        System.out.println("Enter new value:");
        if (option == 5) {
            double newValue = scan.nextDouble();
            supplier.setPriceForProduct(newValue);
            String result = String.valueOf(controller.updateSupplier(id, supplier));
            System.out.println(result);
        } else {
            String newValue = scan.next();
            if (option == 1) {
                supplier.setName(newValue);
                String result = String.valueOf(controller.updateSupplier(id, supplier));
                System.out.println(result);
            } else if (option == 2) {
                supplier.setAddress(newValue);
                String result = String.valueOf(controller.updateSupplier(id, supplier));
                System.out.println(result);
            } else if (option == 3) {
                supplier.setPhoneNumber(newValue);
                String result = String.valueOf(controller.updateSupplier(id, supplier));
                System.out.println(result);
            } else if (option == 4) {
                supplier.setEmail(newValue);
                String result = String.valueOf(controller.updateSupplier(id, supplier));
                System.out.println(result);
            }
        }
    }

    public void deleteSupplierMenu() {
        System.out.println("Enter ID:");
        int id = scan.nextInt();
        String result = String.valueOf(controller.deleteSupplier(id));
        System.out.println(result);
    }

    public void countPriceForProductMenu() {
        System.out.println("Enter product name:");
        scan.nextLine();
        String productName = scan.nextLine();
        System.out.println("Enter supplier ID:");
        int supID = scan.nextInt();
        controller.countPriceForProduct(productName, supID);
    }

}
