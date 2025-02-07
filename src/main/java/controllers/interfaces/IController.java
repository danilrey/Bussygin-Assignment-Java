package controllers.interfaces;

import entities.Supplier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IController {
    public String createSupplier(Supplier supplier);
    public Supplier getSupplier( int id);
    public String getAllSuppliers();
    public Supplier updateSupplier(int id, Supplier supplier);
    public String deleteSupplier(int id);
    public void countPriceForProduct(String productName, int supID);

}
