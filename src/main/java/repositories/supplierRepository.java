package repositories;

import java.sql.*;
import data.interfaces.IDB;
import entities.Inventory;
import entities.Supplier;
import repositories.interfaces.ISupplierRepository;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

public class supplierRepository implements ISupplierRepository {
    private final IDB db;
    private final Inventory inventory;

    public supplierRepository(IDB db, Inventory inventory) {
        this.db = db;
        this.inventory = inventory;
    }

    @Override
    public boolean createSupplier(Supplier supplier) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO supplier(name,address,phone,email,price_for_product) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,supplier.getName());
            st.setString(2, supplier.getAddress());
            st.setString(3,supplier.getPhoneNumber());
            st.setString(4,supplier.getEmail());
            st.setDouble(5,supplier.getPriceForProduct());
            st.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Supplier getSupplier(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,address,phone,email,price_for_product FROM supplier WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Supplier supplier = new Supplier(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getDouble("price_for_product"));
                supplier.setInventory(inventory);
                return supplier;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,address,phone,email,price_for_product FROM supplier";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            List<Supplier> suppliers = new LinkedList<>();
            while (rs.next()) {
                Supplier supplier = new Supplier(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDouble("price_for_product"));
                supplier.setInventory(inventory);
                suppliers.add(supplier);
            }
            return suppliers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Supplier updateSupplier(int id, Supplier supplier) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE supplier SET name=?,address=?,phone=?,email=?,price_for_product=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,supplier.getName());
            st.setString(2, supplier.getAddress());
            st.setString(3,supplier.getPhoneNumber());
            st.setString(4,supplier.getEmail());
            st.setDouble(5,supplier.getPriceForProduct());
            st.setInt(6,id);
            st.execute();
            return supplier;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean deleteSupplier(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM supplier WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            st.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
