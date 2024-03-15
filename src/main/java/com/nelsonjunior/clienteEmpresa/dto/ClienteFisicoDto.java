package com.nelsonjunior.clienteEmpresa.dto;

import com.nelsonjunior.clienteEmpresa.models.ClienteFisico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteFisicoDto {
    
    private Long id;

    private String nome;

    private String dataNasc;
    
    private boolean ativo;


    public ClienteFisicoDto(Long id, String nome, String dataNasc, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.ativo = ativo;
    }

    public ClienteFisicoDto(ClienteFisico clienteFisico) {
        id = clienteFisico.getId();
        nome = clienteFisico.getNome();
        dataNasc = clienteFisico.getDataNasc();
        ativo = clienteFisico.isAtivo();
    }


}
