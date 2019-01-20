package Tipos;

public enum TipoCargo {
    GER("Gerente"),
    CAX("Caixa"),
    ETG("Estagiário"),
    LMP("Limpeza"),
    TES("Tesoureiro");

    private String descricao;

    private TipoCargo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    } 
}
