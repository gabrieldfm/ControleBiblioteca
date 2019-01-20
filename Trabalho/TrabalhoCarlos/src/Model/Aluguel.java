package Model;

import Tipos.TipoGenero;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Aluguel {
    private int id;
    private Cliente cliente;
    private Livro livro;
    private Date dataAluguel;
    private int periodo;

    public Aluguel() {
        this.setCliente(null);
        this.setLivro(null);
        this.setPeriodo(1);
        this.setId(0);
        this.setDataAluguel(Date.from(Instant.MIN));
    }

    public Aluguel(int id, Cliente cliente, Livro livro, Date dataAluguel, int periodo) {
        this.setCliente(cliente);
        this.setLivro(livro);
        this.setPeriodo(periodo);
        this.setId(id);
        this.setDataAluguel(dataAluguel);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente==null? new Cliente() : cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro==null? new Livro() : livro;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo==0 ? 1 : periodo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluguel other = (Aluguel) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
