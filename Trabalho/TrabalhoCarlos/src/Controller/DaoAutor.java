package Controller;

import Model.Autor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoAutor extends Dao{
    public int addAutor(Autor autor) throws SQLException{
        return (super.executeUpdate("INSERT INTO AUTOR (NOME,CIDADE_ID) VALUES (?,?)", autor.getNome(),autor.getCidade().getId()));
    }
    
    public int updateAutor(Autor autor) throws SQLException{
        return (super.executeUpdate("UPDATE AUTOR SET NOME=?,CIDADE_ID=? WHERE ID=?",autor.getNome(),autor.getCidade(),autor.getId()));
    }
    
    public int deleteAutor(Autor autor) throws SQLException{
        return (super.executeUpdate("DELETE FROM AUTOR WHERE ID=?", autor.getId()));
    }
    
    public Autor getAutor(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM AUTOR WHERE ID=?", pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    
    public List<Autor> getAutorList() throws SQLException{
        List <Autor> retorno = new LinkedList<>();
        
        ResultSet rs  = super.executeQuery("SELECT * FROM AUTOR ORDER BY NOME");
        while(rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    public List<Autor> getAutorList(String filtro) throws SQLException{
        List <Autor> retorno = new LinkedList<>();
        
        ResultSet rs  = super.executeQuery("SELECT * FROM AUTOR WHERE NOME LIKE ? ORDER BY NOME '%"+filtro.toUpperCase()+"%");
        
        while(rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
        
    }
    private Autor populateObject(ResultSet rs) throws SQLException{
        return (new Autor(new DaoCidade().getCidade(rs.getInt("CIDADE_ID")),rs.getInt("ID"),rs.getString("NOME")));
    }
}
