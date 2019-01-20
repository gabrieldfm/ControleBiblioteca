package Model;

public class Autor extends Padrao{
    private Cidade cidade;

    public Autor() {
        super();
        this.setCidade(null);
    }

    public Autor(Cidade cidade, int id, String nome) {
        super(id, nome);
        this.setCidade(cidade);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade==null? new Cidade() : cidade;
    }
}
