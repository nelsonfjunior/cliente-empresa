package com.nelsonjunior.clienteEmpresa.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clienteJuridico")
@Getter
@Setter
public class ClienteJuridico extends Cliente {

    @NotEmpty
    private String cnpj;

    @NotEmpty
    private String ie;

    @OneToMany
    private List<Contato> contatos =  new ArrayList<Contato>();

}
