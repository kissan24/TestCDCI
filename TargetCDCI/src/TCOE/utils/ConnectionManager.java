/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TCOE.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

    public Connection createConnection() throws ClassNotFoundException, SQLException {
          Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a2", "root", "tcs#1234");
      
        return con;
    }
    
}
