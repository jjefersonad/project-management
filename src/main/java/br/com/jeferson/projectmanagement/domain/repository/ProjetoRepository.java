package br.com.jeferson.projectmanagement.domain.repository;

import br.com.jeferson.projectmanagement.domain.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
