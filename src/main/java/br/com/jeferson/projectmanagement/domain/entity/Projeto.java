package br.com.jeferson.projectmanagement.domain.entity;

import br.com.jeferson.projectmanagement.domain.custom.RiscoProjetoEnum;
import br.com.jeferson.projectmanagement.domain.custom.StatusProjetoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "projeto")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name ="nome", nullable = false, length = 200, columnDefinition = "VARCHAR(200)")
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name ="data_inicio", nullable = true)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    @Column(name ="data_previsao_fim", nullable = true)
    private Date dataPrevisaoFim;

    @Temporal(TemporalType.DATE)
    @Column(name ="data_fim", nullable = true)
    private Date dataFim;

    @Column(name ="descricao", nullable = true, length = 5000, columnDefinition = "VARCHAR(5000)")
    private String descricao;

    @Column(name ="status", nullable = true, length = 45, columnDefinition = "VARCHAR(45)")
    @Enumerated(EnumType.STRING)
    private StatusProjetoEnum status;

    @Column(name ="orcamento", nullable = true, columnDefinition = "FLOAT")
    private Float orcamento;

    @Column(name ="risco", nullable = true, length = 45, columnDefinition = "VARCHAR(45)")
    @Enumerated(EnumType.STRING)
    private RiscoProjetoEnum risco;

    @ManyToOne
    @JoinColumn(name = "idgerente", referencedColumnName = "id", nullable=false)
    private Pessoa gerente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "membros",
            joinColumns = { @JoinColumn(name = "idprojeto") },
            inverseJoinColumns = { @JoinColumn(name = "idpessoa") }
    )
    private Set<Pessoa> membros = new HashSet<>();
}
