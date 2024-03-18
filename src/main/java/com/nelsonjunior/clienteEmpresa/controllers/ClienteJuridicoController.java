package com.nelsonjunior.clienteEmpresa.controllers;

import java.util.List;

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

import com.nelsonjunior.clienteEmpresa.dto.ClienteJuridicoDto;
import com.nelsonjunior.clienteEmpresa.models.ClienteJuridico;
import com.nelsonjunior.clienteEmpresa.services.ClienteJuridicoService;

@RestController
@RequestMapping("/clientes-juridicos")
public class ClienteJuridicoController {

    @Autowired
    private ClienteJuridicoService clienteJuridicoService;
    

    @GetMapping("/{id}")
    public ResponseEntity<ClienteJuridicoDto> getClienteJuridicoById(@PathVariable Long id) {
        ClienteJuridicoDto clienteJuridico = clienteJuridicoService.getClienteJuridicoById(id);
        return ResponseEntity.ok().body(clienteJuridico);
    }

    @GetMapping("/contato-ativo")
    public ResponseEntity<List<ClienteJuridicoDto>> getAllClienteJuridico(){
        List<ClienteJuridicoDto> clientesJuridicos = clienteJuridicoService.getAllClienteJuridico();
        return ResponseEntity.ok().body(clientesJuridicos);
    }

    @PostMapping
    public ResponseEntity<ClienteJuridicoDto> createClienteJuridico(@RequestBody ClienteJuridico clienteJuridico) {
        ClienteJuridicoDto clienteJuridicoCriado = clienteJuridicoService.createClienteJuridico(clienteJuridico);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteJuridicoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClienteJuridico(@PathVariable Long id, @RequestBody ClienteJuridico clienteJuridico) {
        clienteJuridicoService.updateClienteJuridico(id, clienteJuridico);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteJuridico(@PathVariable Long id) {
        clienteJuridicoService.deleteClienteJuridico(id);
        return ResponseEntity.noContent().build();
    }
}
