package Model;

public class Editora extends Padrao{
    private Cidade cidade;

    public Editora() {
        super();
        this.setCidade(null);
    }

    public Editora(Cidade cidade, int id, String nome) {
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
