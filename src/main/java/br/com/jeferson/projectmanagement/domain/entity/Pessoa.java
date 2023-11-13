package br.com.jeferson.projectmanagement.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="nome", nullable = false, length = 100, columnDefinition = "CHARACTER VARYING(100)")
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name ="datanascimento", nullable = true, columnDefinition = "date")
    private Date datanascimento;

    @Column(name ="cpf", nullable = true, length = 14, columnDefinition = "CHARACTER VARYING(14)")
    private String cpf;

    @Column(name ="funcionario", nullable = true, columnDefinition = "boolean")
    private Boolean funcionario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "membros",
            joinColumns = { @JoinColumn(name = "idpessoa") },
            inverseJoinColumns = { @JoinColumn(name = "idprojeto") }
    )
    Set<Projeto> projetos = new HashSet<>();

}
