package com.nelsonjunior.clienteEmpresa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contato")
@Getter
@Setter
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    private String descricao;

    @NotNull
    private Long numero;

    private boolean ativo;

    public Contato(@NotEmpty String descricao, @NotNull Long numero, boolean ativo) {
        this.descricao = descricao;
        this.numero = numero;
        this.ativo = ativo;
    }

    public Contato() {
    }

}
