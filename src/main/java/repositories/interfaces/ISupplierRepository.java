package repositories.interfaces;

import entities.Supplier;

import java.util.List;

public interface ISupplierRepository {
    boolean createSupplier(Supplier supplier);
    Supplier getSupplier(int id);
    List<Supplier> getAllSuppliers();
    Supplier updateSupplier(int id, Supplier supplier);
    boolean deleteSupplier(int id);
}
