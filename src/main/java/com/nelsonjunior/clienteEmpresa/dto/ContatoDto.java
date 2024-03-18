package com.nelsonjunior.clienteEmpresa.dto;

import com.nelsonjunior.clienteEmpresa.models.Contato;

public record ContatoDto(Long id, String descricao, Long numero, boolean ativo) {

    public ContatoDto(Contato contato) {
        this(contato.getId(), contato.getDescricao(), contato.getNumero(), contato.isAtivo());
    }

}
