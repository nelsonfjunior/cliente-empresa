package com.nelsonjunior.clienteEmpresa.dto;

import com.nelsonjunior.clienteEmpresa.models.Contato;

public record ContatoDto(Long numero, String descricao) {

    public ContatoDto(Contato contato) {
        this(contato.getNumero(), contato.getDescricao());
    }

}
