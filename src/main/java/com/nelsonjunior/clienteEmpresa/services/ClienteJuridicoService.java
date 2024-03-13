package com.nelsonjunior.clienteEmpresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.models.ClienteJuridico;
import com.nelsonjunior.clienteEmpresa.repositories.ClienteJuridicoRepository;

@Service
public class ClienteJuridicoService {

    @Autowired
    private ClienteJuridicoRepository clienteJuridicoRepository;


    public ClienteJuridico getClienteJuridicoById(Long id) {
        return clienteJuridicoRepository.findById(id).orElse(null);
    }

    public ClienteJuridico createClienteJuridico(ClienteJuridico clienteJuridico) {
        return clienteJuridicoRepository.save(clienteJuridico);
    }

    public void deleteClienteJuridico(Long id) {
        clienteJuridicoRepository.deleteById(id);
    }

    public void updateClienteJuridico(Long id, ClienteJuridico clienteJuridico) {
        clienteJuridico.setId(id);
        clienteJuridicoRepository.save(clienteJuridico);
    }

    
}
