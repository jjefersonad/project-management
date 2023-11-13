package br.com.jeferson.projectmanagement.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "membros")
public class Membro {

    @EqualsAndHashCode.Include
    @Id
    @Column(name="idpessoa")
    private Long idpessoa;

    @EqualsAndHashCode.Include
    @Id
    @Column(name="idprojeto")
    private Long idprojeto;

    @Column(name="cargo")
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "idpessoa", referencedColumnName = "id", nullable=false, insertable = false, updatable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "idprojeto", referencedColumnName = "id", nullable=false, insertable = false, updatable = false)
    private Projeto projeto;
}
