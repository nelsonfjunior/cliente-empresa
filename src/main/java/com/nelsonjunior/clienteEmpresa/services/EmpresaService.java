package com.nelsonjunior.clienteEmpresa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.models.Empresa;
import com.nelsonjunior.clienteEmpresa.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;


    //Encontrar por ID --> GET
    public Empresa getEmpresaById(Long id){  
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    //Cadastrar Empresa --> POST
    public Empresa createEmpresa(Empresa empresa){
        empresa.setId(null);
        empresa = this.empresaRepository.save(empresa);
        return empresa;
    }

    //Atualizar Empresa --> PUT
    public Empresa updateEmpresa(Empresa empresa){
        Empresa empresa2 = getEmpresaById(empresa.getId());
        empresa2.setAtivo(empresa.isAtivo());
        return this.empresaRepository.save(empresa2);
    }

    //Deletar Empresa --> DELETE
    public void deleteEmpresa(Long id){
        try {
            getEmpresaById(id);
            this.empresaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir!");
        }
        
    }
}
