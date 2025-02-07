package controllers;

import controllers.interfaces.IController;
import entities.Supplier;
import repositories.interfaces.ISupplierRepository;

import java.util.List;

public class SupplierController implements IController {
    private final ISupplierRepository repo;

    public SupplierController(ISupplierRepository repo) {
        this.repo = repo;
    }



    public String createSupplier(Supplier supplier) {
        boolean created = repo.createSupplier(supplier);
        return (created ? "Supplier was created" : "Supplier creation was failed");
    }

    public Supplier getSupplier(int id) {
        return repo.getSupplier(id);
    }

    public String getAllSuppliers() {
        List<Supplier> suppliers = repo.getAllSuppliers();

        return suppliers.toString();
    }

    public Supplier updateSupplier(int id, Supplier supplier) {
        return repo.updateSupplier(id, supplier);
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
}
