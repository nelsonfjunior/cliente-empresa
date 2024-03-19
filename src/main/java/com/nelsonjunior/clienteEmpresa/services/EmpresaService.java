package com.nelsonjunior.clienteEmpresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.dto.EmpresaDto;
import com.nelsonjunior.clienteEmpresa.models.Empresa;
import com.nelsonjunior.clienteEmpresa.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    //Encontrar por ID --> GET
    public EmpresaDto getEmpresaById(Long id){  
        Empresa empresa = empresaRepository.findById(id).orElse(null);
        EmpresaDto dto =  new EmpresaDto(empresa);
        return dto;
    }

    //Cadastrar Empresa --> POST
    public EmpresaDto createEmpresa(Empresa empresa){
        empresa.setId(null);
        Empresa empresaCriada = this.empresaRepository.save(empresa);
        EmpresaDto dto = new EmpresaDto(empresaCriada);
        return dto;
    }

    //Atualizar Empresa --> PUT
    public void updateEmpresa(Long id, Empresa empresa){
        Empresa empresaNovo = empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        empresaNovo.setId(id);
        empresaNovo.setAtivo(empresa.isAtivo());
        empresaNovo.setNome(empresa.getNome());

        this.empresaRepository.save(empresa);
    }

    //Deletar Empresa --> DELETE
    public void deleteEmpresa(Long id){
        this.empresaRepository.deleteById(id); 
    }
}
