package com.nelsonjunior.clienteEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelsonjunior.clienteEmpresa.models.ClienteFisico;

public interface ClienteFisicoRepository extends JpaRepository<ClienteFisico, Long>{
    
}
