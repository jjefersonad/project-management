package br.com.jeferson.projectmanagement.infraestructure.converter;

import br.com.jeferson.projectmanagement.domain.dto.input.ProjetoInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.presentation.ProjetoPresentationDTO;
import br.com.jeferson.projectmanagement.domain.entity.Projeto;
import br.com.jeferson.projectmanagement.domain.entity.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjetoConverter {

    private final ModelMapper modelMapper;

    public ProjetoConverter() {
        this.modelMapper = new ModelMapper();
    }

    public ProjetoPresentationDTO entityToDTO(Projeto entity) {
        ProjetoPresentationDTO projetoPresentationDTO = new ProjetoPresentationDTO();
        projetoPresentationDTO.setId(entity.getId());
        projetoPresentationDTO.setNome(entity.getNome());
        projetoPresentationDTO.setDataInicio(entity.getDataInicio());
        projetoPresentationDTO.setDataPrevisaoFim(entity.getDataPrevisaoFim());
        projetoPresentationDTO.setDataFim(entity.getDataFim());
        projetoPresentationDTO.setDescricao(entity.getDescricao());
        projetoPresentationDTO.setStatus(entity.getStatus().getDescricao());
        projetoPresentationDTO.setOrcamento(entity.getOrcamento());
        projetoPresentationDTO.setRisco(entity.getRisco().getDescricao());
        projetoPresentationDTO.setDescricao(entity.getDescricao());
        projetoPresentationDTO.setGerente(entity.getGerente());
        return projetoPresentationDTO;
    }

    public Projeto dtoToEntity(ProjetoInputDTO dto) {
        Projeto projeto = new Projeto();
        projeto.setNome(dto.getNome());
        projeto.setDataInicio(dto.getDataInicio());
        projeto.setDataPrevisaoFim(dto.getDataPrevisaoRealTermino());
        projeto.setDataFim(dto.getDataRealTermino());
        projeto.setDescricao(dto.getDescricao());
        projeto.setStatus(dto.getStatus());
        projeto.setOrcamento(dto.getOrcamento());
        projeto.setRisco(dto.getRisco());
        projeto.setDescricao(dto.getDescricao());

        Pessoa pessoa = new Pessoa();
        pessoa.setId(dto.getGerenteResponsavelId());
        projeto.setGerente(pessoa);

        return projeto;
    }

    public List<ProjetoPresentationDTO> toPresentationDTOList(List<Projeto> projetoList) {
        if(projetoList.isEmpty()){
            return null;
        }
        return projetoList.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

}
