package com.nelsonjunior.clienteEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelsonjunior.clienteEmpresa.models.ClienteJuridico;

public interface ClienteJuridicoRepository extends JpaRepository<ClienteJuridico, Long> {
}
