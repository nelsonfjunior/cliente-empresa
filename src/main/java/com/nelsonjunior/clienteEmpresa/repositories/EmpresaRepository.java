package com.nelsonjunior.clienteEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelsonjunior.clienteEmpresa.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
}
