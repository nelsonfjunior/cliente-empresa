package com.nelsonjunior.clienteEmpresa.dto;

import com.nelsonjunior.clienteEmpresa.models.ClienteFisico;
import com.nelsonjunior.clienteEmpresa.models.Empresa;

public record ClienteFisicoDto(Long id, String nome, String dataNasc, boolean ativo, Empresa empresa) {

    public ClienteFisicoDto(ClienteFisico clienteFisico) {
        this(clienteFisico.getId(), clienteFisico.getNome(), clienteFisico.getDataNasc(), clienteFisico.isAtivo(), clienteFisico.getEmpresa());
    }

}
