package br.com.jeferson.projectmanagement.infraestructure.converter;

import br.com.jeferson.projectmanagement.domain.dto.input.PessoaInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.presentation.PessoaPresentationDTO;
import br.com.jeferson.projectmanagement.domain.entity.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaConverter {

    private final ModelMapper modelMapper;

    public PessoaConverter() {
        this.modelMapper = new ModelMapper();
    }

    public PessoaPresentationDTO entityToDTO(Pessoa entity) {
        return modelMapper.map(entity, PessoaPresentationDTO.class);
    }

    public Pessoa dtoToEntity(PessoaInputDTO dto) {
        return modelMapper.map(dto, Pessoa.class);
    }

    public List<PessoaPresentationDTO> toPresentationDTOList(List<Pessoa> pessoaList) {
        if(pessoaList.isEmpty()){
            return null;
        }
        return pessoaList.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

}
