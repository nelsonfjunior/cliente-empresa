package com.nelsonjunior.clienteEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelsonjunior.clienteEmpresa.models.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
