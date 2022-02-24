package kz.aitu.project.data;

import kz.aitu.project.data.interfaces.IDB;

import java.sql.*;

public class DB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/javaproject";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionURL, "postgres", "123456");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}