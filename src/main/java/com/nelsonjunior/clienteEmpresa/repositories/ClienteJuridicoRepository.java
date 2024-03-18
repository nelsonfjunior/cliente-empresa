package com.nelsonjunior.clienteEmpresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelsonjunior.clienteEmpresa.models.ClienteJuridico;

public interface ClienteJuridicoRepository extends JpaRepository<ClienteJuridico, Long> {
    List<ClienteJuridico> findAllByContatos_Ativo(boolean ativo);
}
