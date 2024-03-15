package com.nelsonjunior.clienteEmpresa.dto;

import com.nelsonjunior.clienteEmpresa.models.Contato;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoDto {
    
    private Long id;
    
    private String descricao;

    private Long numero;

    private boolean ativo;


    public ContatoDto(Long id, String descricao, Long numero, boolean ativo) {
        this.id = id;
        this.descricao = descricao;
        this.numero = numero;
        this.ativo = ativo;
    }


    public ContatoDto(Contato contato) {
        id = contato.getId();
        descricao = contato.getDescricao();
        numero = contato.getNumero();
        ativo = contato.isAtivo();
    }


}
