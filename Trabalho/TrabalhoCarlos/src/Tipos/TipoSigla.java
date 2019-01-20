package Tipos;

public enum TipoSigla {
    AC("Acre"),
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    PR("Parana"),
    SP("São Paulo"),
    RJ("Rio de janeiro"),
    ES("Espirito Santo"),
    MG("Minas Gerais"),
    MT("Mato Grosso do Sul"),
    MS("Mato Grosso do Norte"),
    GO("Goias"),
    TO("Tocantins"),
    DF("Distrito Federal"),
    BA("Bahia"),
    AL("Alagoas"),
    SE("Sergipe"),
    RO("Rondonia"),
    AM("Amazonas"); 
    
    private String descricao;

    private TipoSigla(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    } 
    
}