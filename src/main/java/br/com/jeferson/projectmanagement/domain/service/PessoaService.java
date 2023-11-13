package br.com.jeferson.projectmanagement.domain.service;

import br.com.jeferson.projectmanagement.domain.dto.input.PessoaInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.presentation.PessoaPresentationDTO;

import java.util.List;

public interface PessoaService {
    PessoaPresentationDTO save(PessoaInputDTO pessoaInputDTO);

    List<PessoaPresentationDTO> findAll();

    PessoaPresentationDTO findById(Long id);

    PessoaPresentationDTO update(PessoaInputDTO pessoaInputDTO, Long id);

    void deleteById(Long id);
}
