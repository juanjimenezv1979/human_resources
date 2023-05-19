
package com.iudigital.human_resources.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Aqui se configura toda la conexion a la base de datos MySQL
 */
public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/human_resources";
    
    private static final String USER = "Root";
    
    private static final String PASSWORD = "Vale1808.";
    
    public static Connection getConnection () throws SQLException {
        
      return DriverManager.getConnection (URL, USER, PASSWORD);
    }
    
}
