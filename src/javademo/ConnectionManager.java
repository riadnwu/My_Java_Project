/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javademo;

import java.sql.*;

/**
 *
 * Manage the database connectionManager
 *
 * @author Asif
 */
public class ConnectionManager {

    // JDBC driver name and database URL
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/nwu_sessional";

    //  Database credentials
    private static String USER = "root";
    private static String PASS = "root";

    private static Connection conn = null;

    /**
     * static method use from everywhere without creating object
     *
     * @name getConnection
     * @return connection
     *
     */
    public static Connection getConnection() {

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            try {
                //Open a connection [to create a Connection object]
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException ex) {

                ex.printStackTrace();
            }

        } catch (ClassNotFoundException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }

        // return the connection
        return conn;
    }

}
