
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    //retorna um Statement
    public Statement getStatement() throws SQLException{
        return Dados.Conexao.getConnection().createStatement();
    }
    //retorna um PreparedStatement
    public PreparedStatement getStatement(String SQL) throws SQLException{
        return Dados.Conexao.getConnection().prepareStatement(SQL);
    }
    //executa um comando SQL com update
    public int executeUpdate(String SQL,Object... args) throws SQLException{
        PreparedStatement pst = getStatement(SQL);
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i+1), args[i]);
        }
        return pst.executeUpdate();
    }
    
    public ResultSet executeQuery(String SQL,Object... args) throws SQLException{
        PreparedStatement pst = getStatement(SQL);
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i+1), args[i]);
        }
        return pst.executeQuery();
    }
}
