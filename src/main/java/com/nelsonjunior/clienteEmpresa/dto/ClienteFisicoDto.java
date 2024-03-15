package com.nelsonjunior.clienteEmpresa.dto;

import com.nelsonjunior.clienteEmpresa.models.ClienteFisico;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteFisicoDto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String dataNasc;
    
    private boolean ativo;


    public ClienteFisicoDto(Long id, @NotEmpty String nome, @NotEmpty String dataNasc, boolean ativo) {
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
