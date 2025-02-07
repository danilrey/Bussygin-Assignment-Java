package controllers;

import entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.interfaces.ISupplierRepository;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class JsonController {

    private final ISupplierRepository supplierRepository;

    @Autowired
    public JsonController(ISupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @PostMapping
    public String createSupplier(@RequestBody Supplier supplier) {
        boolean created = supplierRepository.createSupplier(supplier);
        return (created ? "Supplier was created" : "Supplier creation was failed");
    }

    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable int id) {
        Supplier supplier = supplierRepository.getSupplier(id);
        if (supplier == null) {
            System.out.println("Supplier not found");
            return null;
        }
        return supplier;
    }

    @GetMapping
    public String getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.getAllSuppliers();
        return suppliers.toString();
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {

        return supplierRepository.updateSupplier(id, supplier);
    }

    @DeleteMapping("/{id}")
    public String deleteSupplier(@PathVariable int id) {
        boolean deleted = supplierRepository.deleteSupplier(id);
        return (deleted ? "Supplier was deleted" : "Supplier deletion was failed");
    }

    public void countPriceForProduct(String productName, int supID) {
        Supplier supplier = supplierRepository.getSupplier(supID);
        if (supplier == null) {
            System.out.println("Supplier not found");
            return;
        }
        supplier.countPriceForProduct(productName);
    }
}