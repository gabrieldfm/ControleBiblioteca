
package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conection = null;
    
    public static  Connection getConnection() throws SQLException{
        if (conection == null){
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalhocarlos", "root", "");
        }
        return conection;
    }
}
