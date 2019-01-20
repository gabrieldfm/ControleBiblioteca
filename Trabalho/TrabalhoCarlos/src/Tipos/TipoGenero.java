package Tipos;

public enum TipoGenero {
    INF("Infantil"),
    ROM("Romance"),
    FIC("Ficção"),
    AUT("Auto-Ajuda"),
    AVE("Aventura"),
    HIS("História");

    private String descricao;

    private TipoGenero(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    } 
}
