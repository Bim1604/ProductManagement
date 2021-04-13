/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangtd.utl;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DBHelper {
    static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String url = "jdbc:sqlserver://localhost:1433; databaseName = ProductManagement;" + "user=sa;password=123456";
    
    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        Connection c = null;
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url);
        } catch (SQLServerException sqls) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database");
        } catch (ClassNotFoundException | SQLException cnf) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database");
        }
        return c;        
    }
}
