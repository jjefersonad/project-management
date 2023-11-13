package br.com.jeferson.projectmanagement.infraestructure.service;

import br.com.jeferson.projectmanagement.domain.custom.NotFoundException;
import br.com.jeferson.projectmanagement.domain.dto.input.PessoaInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.presentation.PessoaPresentationDTO;
import br.com.jeferson.projectmanagement.domain.entity.Pessoa;
import br.com.jeferson.projectmanagement.domain.repository.PessoaRepository;
import br.com.jeferson.projectmanagement.domain.service.PessoaService;
import br.com.jeferson.projectmanagement.infraestructure.converter.PessoaConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaConverter pessoaConverter;

    @Override
    public PessoaPresentationDTO save(PessoaInputDTO pessoaInputDTO) {
        return pessoaConverter.entityToDTO(pessoaRepository.save(pessoaConverter.dtoToEntity(pessoaInputDTO)));
    }

    @Override
    public List<PessoaPresentationDTO> findAll() {
        return pessoaConverter.toPresentationDTOList(pessoaRepository.findAll());
    }

    @Override
    public PessoaPresentationDTO findById(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada com o ID: " + id));
        return pessoaConverter.entityToDTO(pessoa);

    }

    @Override
    public PessoaPresentationDTO update(PessoaInputDTO pessoaInputDTO, Long id) {
        Pessoa pessoa = pessoaConverter.dtoToEntity(pessoaInputDTO);
        PessoaPresentationDTO pessoaAnterior = this.findById(id);
        pessoa.setId(pessoaAnterior.getId());

        return pessoaConverter.entityToDTO(pessoaRepository.save(pessoa));
    }

    @Override
    public void deleteById(Long id) {
        PessoaPresentationDTO pessoaPresentationDTO = this.findById(id);
        pessoaRepository.deleteById(pessoaPresentationDTO.getId());
    }
}
