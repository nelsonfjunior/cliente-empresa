package com.nelsonjunior.clienteEmpresa.dto;

import java.util.List;

import com.nelsonjunior.clienteEmpresa.models.ClienteJuridico;
import com.nelsonjunior.clienteEmpresa.models.Contato;
import com.nelsonjunior.clienteEmpresa.models.Empresa;

public record ClienteJuridicoDto (String nome, String cnpj, Long id, String ie, List<Contato> contatos, boolean ativo, Empresa empresa){

    public ClienteJuridicoDto(ClienteJuridico clienteJuridico) {
        this(clienteJuridico.getNome(), clienteJuridico.getCnpj(), clienteJuridico.getId(), clienteJuridico.getIe(), clienteJuridico.getContatos(),clienteJuridico.isAtivo(), clienteJuridico.getEmpresa());
    }

}
