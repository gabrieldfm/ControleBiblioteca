package Controller;

import Model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoCliente extends Dao{
    public int addCliente(Cliente cliente) throws SQLException{
        return (super.executeUpdate("INSERT INTO CLIENTE (NOME,CIDADE_ID) VALUES (?,?)", cliente.getNome(),cliente.getCidade().getId()));
    }
    
    public int updateCliente(Cliente cliente) throws SQLException{
        return (super.executeUpdate("UPDATE CLIENTE SET NOME=?,CIDADE_ID=? WHERE ID=?",cliente.getNome(),cliente.getCidade(),cliente.getId()));
    }
    
    public int deleteCliente(Cliente cliente) throws SQLException{
        return (super.executeUpdate("DELETE FROM CLIENTE WHERE ID=?", cliente.getId()));
    }
    
    public Cliente getCliente(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM CLIENTE WHERE ID=?", pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    
    public List<Cliente> getClienteList() throws SQLException{
        List <Cliente> retorno = new LinkedList<>();
        
        ResultSet rs  = super.executeQuery("SELECT * FROM CLIENTE ORDER BY NOME");
        while(rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    public List<Cliente> getClienteList(String filtro) throws SQLException{
        List <Cliente> retorno = new LinkedList<>();
        
        ResultSet rs  = super.executeQuery("SELECT * FROM CLIENTE WHERE NOME LIKE ? ORDER BY NOME '%"+filtro.toUpperCase()+"%");
        
        while(rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
        
    }
    private Cliente populateObject(ResultSet rs) throws SQLException{
        return (new Cliente(new DaoCidade().getCidade(rs.getInt("CIDADE_ID")),rs.getInt("ID"),rs.getString("NOME")));
    }
}
