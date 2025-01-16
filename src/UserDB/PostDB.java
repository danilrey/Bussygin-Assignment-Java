package UserDB;
import Inventory_MS.Supplier;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PostDB {
    private String host;
    private String username;
    private String password;
    private String dbName;

    private Connection connection;

    public PostDB(String host, String username, String password, String dbName) {
        setHost(host);
        setUsername(username);
        setPassword(password);
        setDBName(dbName);
        this.connectionUrl = host + "/" + dbName;
    }

    private final String connectionUrl;
    private Connection con = null;
    private ResultSet rs = null;
    private Statement stmt = null;

    public void setHost(String host) {
        this.host = host;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setDBName(String dbName) {
        this.dbName = dbName;
    }

    public String getHost() {
        return host;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getDbName() {
        return dbName;
    }

    public ArrayList<Supplier> FillSuppliers() {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, username, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from supplier");

            while(rs.next())
                suppliers.add(new Supplier(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDouble("price_for_product")));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return suppliers;
    }

    public void close() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}