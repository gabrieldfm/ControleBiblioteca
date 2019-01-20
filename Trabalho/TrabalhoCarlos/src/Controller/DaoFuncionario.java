package Controller;

import Model.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import Tipos.TipoCargo;

public class DaoFuncionario extends Dao{
    public int addFuncionario(Funcionario funcionario) throws SQLException{
        return (super.executeUpdate("INSERT INTO FUNCIONARIO (NOME,CARGO,CIDADE_ID) VALUES (?,?,?)", funcionario.getNome(),funcionario.getCargo().name(),funcionario.getCidade().getId()));
    }
    
    public int updateFuncionario(Funcionario funcionario) throws SQLException{
        return (super.executeUpdate("UPDATE FUNCIONARIO SET NOME=?,CARGO=?,CIDADE_ID=? WHERE ID=?",funcionario.getNome(),funcionario.getCargo().name(),funcionario.getCidade(),funcionario.getId()));
    }
    
    public int deleteFuncionario(Funcionario funcionario) throws SQLException{
        return (super.executeUpdate("DELETE FROM FUNCIONARIO WHERE ID=?", funcionario.getId()));
    }
    
    public Funcionario getFuncionario(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM FUNCIONARIO WHERE ID=?", pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    
    public List<Funcionario> getFuncionarioList() throws SQLException{
        List <Funcionario> retorno = new LinkedList<>();
        
        ResultSet rs  = super.executeQuery("SELECT * FROM FUNCIONARIO ORDER BY NOME");
        while(rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    public List<Funcionario> getFuncionarioList(String filtro) throws SQLException{
        List <Funcionario> retorno = new LinkedList<>();
        
        ResultSet rs  = super.executeQuery("SELECT * FROM FUNCIONARIO WHERE NOME LIKE ? ORDER BY NOME '%"+filtro.toUpperCase()+"%");
        
        while(rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
        
    }
    private Funcionario populateObject(ResultSet rs) throws SQLException{
        return (new Funcionario(new DaoCidade().getCidade(rs.getInt("CIDADE_ID")),rs.getInt("ID"),rs.getString("NOME"), TipoCargo.valueOf(rs.getString("CARGO"))));
    }
}
