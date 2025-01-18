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
}
