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

import com.nelsonjunior.clienteEmpresa.models.Empresa;
import com.nelsonjunior.clienteEmpresa.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Long id){
        Empresa empresa = this.empresaService.findById(id);
        return ResponseEntity.ok().body(empresa);
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa){
        Empresa empresaCriada = this.empresaService.create(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Empresa empresa, @PathVariable Long id){
        empresa.setId(id);
        this.empresaService.update(empresa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
