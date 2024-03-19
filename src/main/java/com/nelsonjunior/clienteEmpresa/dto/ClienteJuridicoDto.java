package com.nelsonjunior.clienteEmpresa.dto;

import java.util.List;

import com.nelsonjunior.clienteEmpresa.models.ClienteJuridico;
import com.nelsonjunior.clienteEmpresa.models.Contato;

public record ClienteJuridicoDto(String nome, String cnpj, List<ContatoDto> contatos){

    public ClienteJuridicoDto(ClienteJuridico clienteJuridico) {
        this(clienteJuridico.getNome(), clienteJuridico.getCnpj(), convertContatosToContatoDto(clienteJuridico.getContatos()));
    }

    private static List<ContatoDto> convertContatosToContatoDto(List<Contato> contatos) {
        return contatos.stream().map(contato -> new ContatoDto(contato.getNumero(), contato.getDescricao())).toList();
    }
    
}
