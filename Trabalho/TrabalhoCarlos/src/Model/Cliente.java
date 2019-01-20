package Model;

public class Cliente extends Padrao{
    private Cidade cidade;

    public Cliente() {
        super();
        this.setCidade(null);
    }

    public Cliente(Cidade cidade, int id, String nome) {
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
