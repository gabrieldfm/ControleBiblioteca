package Model;

import Tipos.TipoCargo;

public class Funcionario extends Padrao{
    private Cidade cidade;
    private TipoCargo cargo;

    public Funcionario() {
        super();
        this.setCidade(null);
        this.setCargo(TipoCargo.CAX);
    }

    public Funcionario(Cidade cidade, int id, String nome, TipoCargo cargo) {
        super(id, nome);
        this.setCidade(cidade);
        this.setCargo(cargo);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade==null? new Cidade() : cidade;
    }
    
    public TipoCargo getCargo(){
        return cargo;
    }
    public void setCargo(TipoCargo cargo){
        this.cargo = cargo;
    }
}
