package Controller;

import Model.Livro;
import Model.Autor;
import Model.Editora;
import Tipos.TipoGenero;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoLivro extends Dao{
    public int addLivro(Livro livro) throws SQLException{
        return (super.executeUpdate("INSERT INTO LIVRO (NOME,ANO_PUBLICACAO,GENERO,AUTOR_ID,EDITORA_ID) VALUES (?,?,?,?,?)", livro.getNome(),livro.getAnoPublicacao(),livro.getGenero().name(),livro.getAutor(), livro.getEditora()));
    }
    
    public int updateLivro(Livro livro) throws SQLException{
        return (super.executeUpdate("UPDATE LIVRO SET NOME=?,ANO_PUBLICACAO=?,GENERO=?,AUTOR_ID=?,EDITORA_ID=? WHERE ID=?",livro.getNome(),livro.getAnoPublicacao(),livro.getGenero().name(),livro.getAutor(), livro.getEditora(), livro.getId()));
    }
    
    public int deleteLivro(Livro livro) throws SQLException{
        return (super.executeUpdate("DELETE FROM LIVRO WHERE ID=?", livro.getId()));
    }
    
    public Livro getLivro(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM LIVRO WHERE ID=?", pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    
    public List<Livro> getFuncionarioList() throws SQLException{
        List <Livro> retorno = new LinkedList<>();
        
        ResultSet rs  = super.executeQuery("SELECT * FROM LIVRO ORDER BY NOME");
        while(rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    public List<Livro> getFuncionarioList(String filtro) throws SQLException{
        List <Livro> retorno = new LinkedList<>();
        
        ResultSet rs  = super.executeQuery("SELECT * FROM LIVRO WHERE NOME LIKE ? ORDER BY NOME '%"+filtro.toUpperCase()+"%");
        
        while(rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
        
    }
    private Livro populateObject(ResultSet rs) throws SQLException{
        return (new Livro(new DaoAutor().getAutor(rs.getInt("AUTOR_ID")),
                new DaoEditora().getEditora(rs.getInt("EDITORA_ID")),
                rs.getInt("ID"),rs.getString("NOME"), rs.getInt("ANO_PUBLICACAO"),TipoGenero.valueOf(rs.getString("GENERO"))));
    }
}
