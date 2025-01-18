import controllers.SupplierController;

import javax.xml.transform.Source;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final SupplierController controller;
    private final Scanner scan;

    public MyApplication(SupplierController controller) {
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
            System.out.println("0. Exit\n");
            try {
                System.out.println("Enter option 0-3");
                int option = scan.nextInt();
                if (option == 1) {
                    getAllSuppliersMenu();
                } else if (option == 2) {
                    getSupplierByIdMenu();
                } else if (option == 3) {
                    createSupplierMenu();
                } else {
                    break;
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
        String result = controller.getSupplier(id);
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
        String result = controller.createSupplier(name, address, phoneNumber, email, priceForProduct);
        System.out.println(result);
    }

}
