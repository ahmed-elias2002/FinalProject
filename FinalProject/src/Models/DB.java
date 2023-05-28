/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ahmed Elias
 */
public class DB {

    private static DB db = null;

    private DB() {

    }

    public static DB getInstance() {
        if (db == null) {
            db = new DB();
            return db;
        } else {
            return db;
        }
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_appointments?serverTimezone=UTC", "root", "");
        return conn;
    }
}
