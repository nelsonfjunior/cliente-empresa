package com.nelsonjunior.clienteEmpresa.dto;

import com.nelsonjunior.clienteEmpresa.models.Empresa;

public record EmpresaDto(Long id, String nome, boolean ativo){
    
    public EmpresaDto(Empresa empresa){
        this(empresa.getId(), empresa.getNome(), empresa.isAtivo());
    }

}
