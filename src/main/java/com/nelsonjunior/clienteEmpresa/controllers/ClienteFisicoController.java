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

import com.nelsonjunior.clienteEmpresa.dto.ClienteFisicoDto;
import com.nelsonjunior.clienteEmpresa.models.ClienteFisico;
import com.nelsonjunior.clienteEmpresa.services.ClienteFisicoService;

@RestController
@RequestMapping("/clientes-fisicos")
public class ClienteFisicoController {

    @Autowired
    private ClienteFisicoService clienteFisicoService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteFisicoDto> getClienteFisicoById(@PathVariable Long id) {
        ClienteFisicoDto clienteFisico = clienteFisicoService.getClienteFisicoById(id);
        return ResponseEntity.ok().body(clienteFisico);
    }

    @PostMapping
    public ResponseEntity<ClienteFisicoDto> createClienteFisico(@RequestBody ClienteFisico clienteFisico) {
        ClienteFisicoDto clienteFisicoCriado = clienteFisicoService.createClienteFisico(clienteFisico);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteFisicoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClienteFisico(@PathVariable Long id, @RequestBody ClienteFisico clienteFisico) {
        clienteFisicoService.updateClienteFisico(id, clienteFisico);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteFisico(@PathVariable Long id) {
        clienteFisicoService.deleteClienteFisico(id);
        return ResponseEntity.noContent().build();
    }
}

