package com.nelsonjunior.clienteEmpresa.dto;

import java.util.ArrayList;
import java.util.List;

import com.nelsonjunior.clienteEmpresa.models.ClienteJuridico;
import com.nelsonjunior.clienteEmpresa.models.Contato;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteJuridicoDto {

    private String cnpj;

    private String ie;
    
    private List<Contato> contatos =  new ArrayList<Contato>();

    public ClienteJuridicoDto(String cnpj, String ie, List<Contato> contatos) {
        this.cnpj = cnpj;
        this.ie = ie;
        this.contatos = contatos;
    }

    public ClienteJuridicoDto(ClienteJuridico clienteJuridico) {
        cnpj = clienteJuridico.getCnpj();
        ie = clienteJuridico.getIe();
        contatos = clienteJuridico.getContatos();
    }

}
