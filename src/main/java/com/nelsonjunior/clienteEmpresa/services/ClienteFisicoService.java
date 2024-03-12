package com.nelsonjunior.clienteEmpresa.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.models.ClienteFisico;
import com.nelsonjunior.clienteEmpresa.repositories.ClienteFisicoRepository;

@Service
public class ClienteFisicoService {

    @Autowired
    private ClienteFisicoRepository clienteFisicoRepository;


    public ClienteFisico getClienteFisicoById(Long id) {
        return clienteFisicoRepository.findById(id).orElse(null);
    }

    public ClienteFisico createClienteFisico(ClienteFisico clienteFisico) {
        return clienteFisicoRepository.save(clienteFisico);
    }

    public void deleteClienteFisico(Long id) {
        clienteFisicoRepository.deleteById(id);
    }

    public void updateClienteFisico(Long id, ClienteFisico clienteFisico) {
        clienteFisico.setId(id);
        clienteFisicoRepository.save(clienteFisico);
    }

}
