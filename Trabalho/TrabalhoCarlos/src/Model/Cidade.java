package Model;

import Tipos.TipoSigla;

public class Cidade extends Padrao{
    private TipoSigla sigla;
    
    public Cidade(){
        super();
        this.setSigla(TipoSigla.SC);
    }
    public Cidade(int id, String nome, TipoSigla sigla){
        super(id,nome);
        this.setSigla(sigla);
    }
    public TipoSigla getSigla(){
        return sigla;
    }
    public void setSigla(TipoSigla sigla){
        this.sigla = sigla;
    }
}
