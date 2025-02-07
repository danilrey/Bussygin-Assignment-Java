package controllers;

import controllers.interfaces.IController;
import entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.interfaces.ISupplierRepository;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class JsonController implements IController {

    private final ISupplierRepository repo;

    @Autowired
    public JsonController(ISupplierRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public String createSupplier(@RequestBody Supplier supplier) {
        boolean created = repo.createSupplier(supplier);
        return (created ? "Supplier was created" : "Supplier creation was failed");
    }

    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable int id) {
        return repo.getSupplier(id);
    }

    @GetMapping
    public String getAllSuppliers() {
        List<Supplier> suppliers = repo.getAllSuppliers();
        return suppliers.toString();
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {

        return repo.updateSupplier(id, supplier);
    }

    @DeleteMapping("/{id}")
    public String deleteSupplier(@PathVariable int id) {
        boolean deleted = repo.deleteSupplier(id);
        return (deleted ? "Supplier was deleted" : "Supplier deletion was failed");
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