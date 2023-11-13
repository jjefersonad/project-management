package br.com.jeferson.projectmanagement.domain.dto.presentation;

import lombok.Data;

import java.util.Date;

@Data
public class PessoaPresentationDTO {
    private Long id;
    private String nome;
    private Date datanascimento;
    private String cpf;
    private Boolean funcionario;

    public PessoaPresentationDTO() {
    }

    public PessoaPresentationDTO(Long id, String nome, Date datanascimento, String cpf, Boolean funcionario) {
        this.id = id;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.cpf = cpf;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }
}
