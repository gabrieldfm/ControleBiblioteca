package Controller;

import Model.Cidade;
import Tipos.TipoSigla;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoCidade extends Dao{
    public int addCidade(Cidade cidade) throws SQLException{
        return (super.executeUpdate("insert into cidade (nome,sigla) values (?,?)", 
                cidade.getNome(),
                cidade.getSigla().name()));
    }
    public int deleteCidade(Cidade cidade) throws SQLException{
        return (super.executeUpdate("DELETE FROM cidade WHERE ID=?", 
                cidade.getId()));
    }
    public int updateCidade(Cidade cidade) throws SQLException{
        return (super.executeUpdate("UPDATE cidade SET NOME=? WHERE ID=?",
                cidade.getId(),
                cidade.getSigla().name()));
    }
    
    public Cidade getCidade(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM CIDADE WHERE ID=?", pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    
    public List<Cidade> getCidadeList() throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cidade ORDER BY NOME");
        LinkedList<Cidade> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));
        }
        return lista;
    }
    public List<Cidade> getCidadeList(String filtro ) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cidade WHERE nome LIKE '%"+filtro+"%'");
        LinkedList<Cidade> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));
        }
        return lista;
    }
    public Cidade populateObject(ResultSet rs) throws SQLException{
        return (new Cidade(rs.getInt("ID"),rs.getString("NOME"),TipoSigla.valueOf(rs.getString("SIGLA"))));
    }
    
}
