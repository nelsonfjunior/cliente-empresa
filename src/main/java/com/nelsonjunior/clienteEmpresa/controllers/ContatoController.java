package com.nelsonjunior.clienteEmpresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelsonjunior.clienteEmpresa.dto.ContatoDto;
import com.nelsonjunior.clienteEmpresa.models.Contato;
import com.nelsonjunior.clienteEmpresa.services.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDto> findById(@PathVariable Long id){
        ContatoDto cliente = this.contatoService.getContatoById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping
    public ResponseEntity<ContatoDto> create(@RequestBody Contato contato){
        ContatoDto contatoCriado = this.contatoService.createContato(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Contato contato, @PathVariable Long id){
        contato.setId(id);
        this.contatoService.updateContato(contato);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.contatoService.deleteContato(id);
        return ResponseEntity.noContent().build();
    }
    

    
}
