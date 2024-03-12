package com.nelsonjunior.clienteEmpresa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clienteFisico")
@Getter
@Setter
public class ClienteFisico extends Cliente{
    

    @NotEmpty
    private String cpf;

    @NotEmpty
    private String uf;

    @NotEmpty
    private String cidade;

    @NotEmpty
    private String bairro;

    private long numero;


}
