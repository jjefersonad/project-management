package br.com.jeferson.projectmanagement.domain.repository;

import br.com.jeferson.projectmanagement.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
