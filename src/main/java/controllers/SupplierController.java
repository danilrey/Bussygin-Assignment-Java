package controllers;

import entities.Supplier;
import repositories.interfaces.ISupplierRepository;

import java.util.List;

public class SupplierController {
    private final ISupplierRepository repo;

    public SupplierController(ISupplierRepository repo) {
        this.repo = repo;
    }



    public String createSupplier(String name, String address, String phone, String email, double priceForProduct) {
        Supplier supplier = new Supplier(name,address,phone,email,priceForProduct);
        boolean created = repo.createSupplier(supplier);

        return (created ? "Supplier was created" : "Supplier creation was failed");
    }

    public String getSupplier(int id) {
        Supplier supplier = repo.getSupplier(id);
        return (supplier == null ? "Supplier not found" : supplier.toString());
    }

    public String getAllSuppliers() {
        List<Supplier> suppliers = repo.getAllSuppliers();

        return suppliers.toString();
    }

    public String updateSupplier(int id, String updatedField, String newValue) {
        Supplier supplier = findByID(id);
        if (supplier == null) {
            return "Supplier was not updated";
        }
        switch (updatedField) {
            case "name" -> supplier.setName(newValue);
            case "address" -> supplier.setAddress(newValue);
            case "phoneNumber" -> supplier.setPhoneNumber(newValue);
            case "email" -> supplier.setEmail(newValue);
        }
        Supplier updatedSupplier = repo.updateSupplier(id, supplier);
        return (updatedSupplier == null ? "Supplier was not updated" : supplier.toString());
    }

    public String updateSupplier(int id, double newValue) {
        Supplier supplier = findByID(id);
        if (supplier == null) {
            return "Supplier was not updated";
        }
        supplier.setPriceForProduct(newValue);
        Supplier updatedSupplier = repo.updateSupplier(id, supplier);

        return (updatedSupplier == null ? "Supplier was not updated" : supplier.toString());
    }

    public String deleteSupplier(int id) {
        boolean deleted = repo.deleteSupplier(id);
        return (deleted ? "Supplier was deleted" : "Supplier was not deleted");
    }

    public void countPriceForProduct(String productName, int supID) {
        Supplier supplier = repo.getSupplier(supID);
        if (supplier == null) {
            System.out.println("Supplier not found");
            return;
        }
        supplier.countPriceForProduct(productName);
    }

    private Supplier findByID(int id) {
        for (Supplier supplier : repo.getAllSuppliers()) {
            if (supplier.getSupplierID() == id) {
                return supplier;
            }
        }
        return null;
    }
}
