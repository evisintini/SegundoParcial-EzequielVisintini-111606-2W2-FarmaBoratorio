/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorBD;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 2w2 111606 Ezequiel Favio Visintini
 */
public class GestorBD {
    
    private Connection conn;

    private void abrirConexion() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Farmaboratorio", "sa", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
     
    
    
    
}
