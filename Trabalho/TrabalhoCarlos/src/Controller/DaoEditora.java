package Controller;

import Model.Editora;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoEditora extends Dao{
    public int addEditora(Editora editora) throws SQLException{
        return (super.executeUpdate("INSERT INTO EDITORA (NOME,CIDADE_ID) VALUES (?,?)", editora.getNome(),editora.getCidade().getId()));
    }
    
    public int updateEditora(Editora editora) throws SQLException{
        return (super.executeUpdate("UPDATE EDITORA SET NOME=?,CIDADE_ID=? WHERE ID=?",editora.getNome(),editora.getCidade(),editora.getId()));
    }
    
    public int deleteEditora(Editora editora) throws SQLException{
        return (super.executeUpdate("DELETE FROM EDITORA WHERE ID=?", editora.getId()));
    }
    
    public Editora getEditora(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM EDITORA WHERE ID=?", pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    
    public List<Editora> getEditoraList() throws SQLException{
        List <Editora> retorno = new LinkedList<>();
        
        ResultSet rs  = super.executeQuery("SELECT * FROM EDITORA ORDER BY NOME");
        while(rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    public List<Editora> getEditoraList(String filtro) throws SQLException{
        List <Editora> retorno = new LinkedList<>();
        
        ResultSet rs  = super.executeQuery("SELECT * FROM EDITORA WHERE NOME LIKE ? ORDER BY NOME '%"+filtro.toUpperCase()+"%");
        
        while(rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
        
    }
    private Editora populateObject(ResultSet rs) throws SQLException{
        return (new Editora(new DaoCidade().getCidade(rs.getInt("CIDADE_ID")),rs.getInt("ID"),rs.getString("NOME")));
    }
}
