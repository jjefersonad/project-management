package br.com.jeferson.projectmanagement.domain.dto.input;

import br.com.jeferson.projectmanagement.domain.custom.RiscoProjetoEnum;
import br.com.jeferson.projectmanagement.domain.custom.StatusProjetoEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ProjetoInputDTO {
    private Long id;
    @NotNull
    @Size(max=200)
    private String nome;
    private Date dataInicio;
    private Date dataPrevisaoRealTermino;
    private Date dataRealTermino;
    private String descricao;
    private StatusProjetoEnum status;
    private Float orcamento;
    private RiscoProjetoEnum risco;
    @NotNull
    private Long gerenteResponsavelId;

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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataPrevisaoRealTermino() {
        return dataPrevisaoRealTermino;
    }

    public void setDataPrevisaoRealTermino(Date dataPrevisaoRealTermino) {
        this.dataPrevisaoRealTermino = dataPrevisaoRealTermino;
    }

    public Date getDataRealTermino() {
        return dataRealTermino;
    }

    public void setDataRealTermino(Date dataRealTermino) {
        this.dataRealTermino = dataRealTermino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusProjetoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusProjetoEnum status) {
        this.status = status;
    }

    public Float getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Float orcamento) {
        this.orcamento = orcamento;
    }

    public RiscoProjetoEnum getRisco() {
        return risco;
    }

    public void setRisco(RiscoProjetoEnum risco) {
        this.risco = risco;
    }

    public Long getGerenteResponsavelId() {
        return gerenteResponsavelId;
    }

    public void setGerenteResponsavelId(Long gerenteResponsavelId) {
        this.gerenteResponsavelId = gerenteResponsavelId;
    }
}
