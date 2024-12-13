/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.*;
/**
 *
 * @author dilha
 */
public class DBConnecter {
    private final static String URL= "jdbc:mysql://localhost:3306/travel-plan";
    private final static String DB_USER= "root";
    private final static String DB_PASS= "";
     static String DRIVER= "com.mysql.jdbc.Driver";
    
    public static Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        Connection con = DriverManager.getConnection(URL, DB_USER, DB_PASS);
        return con;
    }
}
