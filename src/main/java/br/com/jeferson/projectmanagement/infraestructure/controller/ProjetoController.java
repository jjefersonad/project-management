package br.com.jeferson.projectmanagement.infraestructure.controller;

import br.com.jeferson.projectmanagement.domain.dto.input.MembroInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.input.ProjetoInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.presentation.ProjetoPresentationDTO;
import br.com.jeferson.projectmanagement.domain.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoPresentationDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(projetoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoPresentationDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(projetoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProjetoPresentationDTO> create(@Valid @RequestBody ProjetoInputDTO pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.save(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoPresentationDTO> update(@Valid @RequestBody ProjetoInputDTO ProjetoInputDTO, @PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(projetoService.update(ProjetoInputDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        projetoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{id}/adicinar-membro")
    public ResponseEntity<ProjetoPresentationDTO> addMember(@Valid @RequestBody MembroInputDTO membroInputDTO, @PathVariable Long id){
        membroInputDTO.setIdproject(id);
        projetoService.addMember(membroInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
