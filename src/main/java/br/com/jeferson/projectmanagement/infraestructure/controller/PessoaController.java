package br.com.jeferson.projectmanagement.infraestructure.controller;

import br.com.jeferson.projectmanagement.domain.dto.input.PessoaInputDTO;
import br.com.jeferson.projectmanagement.domain.dto.presentation.PessoaPresentationDTO;
import br.com.jeferson.projectmanagement.domain.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService PessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaPresentationDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(PessoaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaPresentationDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(PessoaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PessoaPresentationDTO> create(@Valid @RequestBody PessoaInputDTO Pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(PessoaService.save(Pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaPresentationDTO> update(@Valid @RequestBody PessoaInputDTO pessoaInputDTO, @PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(PessoaService.update(pessoaInputDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        PessoaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
