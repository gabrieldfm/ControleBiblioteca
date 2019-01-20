package Model;

import Tipos.TipoGenero;
import java.util.Calendar;
import java.util.Date;

public class Livro extends Padrao{
    private Autor autor;
    private Editora editora;
    private TipoGenero genero;
    private int anoPublicacao;
    
    public Livro() {
        super();
        this.setAutor(null);
        this.setEditora(null);
        this.setGenero(TipoGenero.FIC);
        this.setAnoPublicacao(Calendar.getInstance().get(Calendar.YEAR));
    }

    public Livro(Autor autor, Editora editora,int id, String nome, int anoPublicacao, TipoGenero genero) {
        super(id, nome);
        this.setAutor(autor);
        this.setEditora(editora);
        this.setGenero(genero);
        this.setAnoPublicacao(anoPublicacao);
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        int ano = Calendar.getInstance().get(Calendar.YEAR);
        this.anoPublicacao = anoPublicacao==0 || anoPublicacao>ano || anoPublicacao<1900? ano : anoPublicacao;
    }
    
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor==null? new Autor() : autor;
    }
    
    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora==null? new Editora() : editora;
    }
    
    public TipoGenero getGenero(){
        return genero;
    }
    public void setGenero(TipoGenero genero){
        this.genero = genero;
    }
}
