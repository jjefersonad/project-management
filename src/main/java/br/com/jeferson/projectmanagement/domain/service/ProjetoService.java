package br.com.jeferson.projectmanagement.domain.service;

import br.com.jeferson.projectmanagement.domain.dto.input.MembroInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.input.PessoaInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.input.ProjetoInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.presentation.PessoaPresentationDTO;
import br.com.jeferson.projectmanagement.domain.dto.presentation.ProjetoPresentationDTO;

import java.util.List;

public interface ProjetoService {
    ProjetoPresentationDTO save(ProjetoInputDTO pessoaInputDTO);

    List<ProjetoPresentationDTO> findAll();

    ProjetoPresentationDTO findById(Long id);

    ProjetoPresentationDTO update(ProjetoInputDTO pessoaInputDTO, Long id);

    void deleteById(Long id);

    void addMember(MembroInputDTO membroInputDTO);
}
