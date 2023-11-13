package br.com.jeferson.projectmanagement.domain.custom;

public enum RiscoProjetoEnum {
    BAIXO("baixo"),
    MEDIO("médio"),
    ALTO("alto");

    private final String descricao;

    RiscoProjetoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
