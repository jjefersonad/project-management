package br.com.jeferson.projectmanagement.infraestructure.service;

import br.com.jeferson.projectmanagement.domain.custom.NotFoundException;
import br.com.jeferson.projectmanagement.domain.custom.StatusProjetoEnum;
import br.com.jeferson.projectmanagement.domain.dto.input.MembroInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.input.PessoaInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.input.ProjetoInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.presentation.ProjetoPresentationDTO;
import br.com.jeferson.projectmanagement.domain.entity.Pessoa;
import br.com.jeferson.projectmanagement.domain.entity.Projeto;
import br.com.jeferson.projectmanagement.domain.repository.PessoaRepository;
import br.com.jeferson.projectmanagement.domain.repository.ProjetoRepository;
import br.com.jeferson.projectmanagement.domain.service.PessoaService;
import br.com.jeferson.projectmanagement.domain.service.ProjetoService;
import br.com.jeferson.projectmanagement.infraestructure.converter.PessoaConverter;
import br.com.jeferson.projectmanagement.infraestructure.converter.ProjetoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ProjetoConverter projetoConverter;

    @Autowired
    private PessoaConverter pessoaConverter;

    @Override
    public ProjetoPresentationDTO save(ProjetoInputDTO projetoInputDTO) {
        Projeto projeto = projetoConverter.dtoToEntity(projetoInputDTO);
        Pessoa gerente = pessoaRepository.findById(projeto.getGerente().getId())
                .orElseThrow(() -> new NotFoundException("Gerente inválido."));
        projeto.setGerente(gerente);
        return projetoConverter.entityToDTO(projetoRepository.save(projeto));
    }

    @Override
    public List<ProjetoPresentationDTO> findAll() {
        return projetoConverter.toPresentationDTOList(projetoRepository.findAll());
    }

    @Override
    public ProjetoPresentationDTO findById(Long id) {
        Projeto pessoa = projetoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Projeto não encrontrado com o ID: " + id));
        return projetoConverter.entityToDTO(pessoa);

    }

    @Override
    public ProjetoPresentationDTO update(ProjetoInputDTO projetoInputDTO, Long id) {
        Projeto projeto = projetoConverter.dtoToEntity(projetoInputDTO);
        ProjetoPresentationDTO pessoaAnterior = this.findById(id);
        projeto.setId(pessoaAnterior.getId());

        Pessoa gerente = pessoaRepository.findById(projeto.getGerente().getId())
                .orElseThrow(() -> new NotFoundException("Gerente inválido."));
        projeto.setGerente(gerente);

        return projetoConverter.entityToDTO(projetoRepository.save(projeto));
    }

    @Override
    public void deleteById(Long id) {
        ProjetoPresentationDTO projetoPresentationDTO = this.findById(id);

        if(
            projetoPresentationDTO.getStatus().equals(StatusProjetoEnum.INICIADO.getDescricao()) ||
            projetoPresentationDTO.getStatus().equals(StatusProjetoEnum.EM_ANDAMENTO.getDescricao()) ||
            projetoPresentationDTO.getStatus().equals(StatusProjetoEnum.ENCERRADO.getDescricao())
        ){
            throw new NotFoundException("Este projeto não pode ser excluído, devido ao seu status está "+projetoPresentationDTO.getStatus());
        }

        projetoRepository.deleteById(projetoPresentationDTO.getId());
    }

    @Override
    public void addMember(MembroInputDTO membroInputDTO) {
        Projeto projeto = projetoRepository.findById(membroInputDTO.getIdproject()).get();
        if(projeto == null){
            throw new NotFoundException("Projeto inválido");
        }

        Pessoa pessoa = pessoaRepository.findById(membroInputDTO.getIdpessoa()).get();
        if(pessoa == null){
            throw new NotFoundException("Pessoa inválida");
        }

        if(!pessoa.getFuncionario()){
            throw new NotFoundException("Esta pessoa não tem a função funcionário habilitado");
        }
        Set<Pessoa> pessoaSet = new HashSet<>();
        pessoaSet.add(pessoa);

        projeto.setMembros(pessoaSet);

        projetoRepository.save(projeto);
    }
}
