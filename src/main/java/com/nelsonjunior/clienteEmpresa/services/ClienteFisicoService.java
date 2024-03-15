package com.nelsonjunior.clienteEmpresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.dto.ClienteFisicoDto;
import com.nelsonjunior.clienteEmpresa.models.ClienteFisico;
import com.nelsonjunior.clienteEmpresa.repositories.ClienteFisicoRepository;

@Service
public class ClienteFisicoService {

    @Autowired
    private ClienteFisicoRepository clienteFisicoRepository;

    public ClienteFisicoDto getClienteFisicoById(Long id) {
        ClienteFisico clienteFisico = clienteFisicoRepository.findById(id).orElse(null);
        ClienteFisicoDto dto = new ClienteFisicoDto(clienteFisico);
        return dto;
    }

    public ClienteFisicoDto createClienteFisico(ClienteFisico clienteFisico) {
        clienteFisico.setId(null);
        ClienteFisico cFisico = this.clienteFisicoRepository.save(clienteFisico);
        ClienteFisicoDto dto = new ClienteFisicoDto(cFisico); 
        return dto;
    }

    public void deleteClienteFisico(Long id) {
        clienteFisicoRepository.deleteById(id);
    }

    public void updateClienteFisico(Long id, ClienteFisico clienteFisico) {
        clienteFisico.setId(id);
        clienteFisicoRepository.save(clienteFisico);
    }

}
