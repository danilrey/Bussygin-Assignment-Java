package data;

import data.interfaces.IDB;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class PostgresDB implements IDB {
    private static PostgresDB instance;

    private PostgresDB() {

    }

    public static PostgresDB getInstance() {
        if (instance == null) {
            instance = new PostgresDB();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(connectionUrl, "postgres", "0000");
        } catch (Exception e) {
            log.error("e: ", e);
            return null;
        }
    }
}