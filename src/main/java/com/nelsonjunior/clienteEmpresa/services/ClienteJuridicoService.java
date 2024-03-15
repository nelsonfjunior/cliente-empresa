package com.nelsonjunior.clienteEmpresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.dto.ClienteJuridicoDto;
import com.nelsonjunior.clienteEmpresa.models.ClienteJuridico;
import com.nelsonjunior.clienteEmpresa.models.Contato;
import com.nelsonjunior.clienteEmpresa.repositories.ClienteJuridicoRepository;

@Service
public class ClienteJuridicoService {

    @Autowired
    private ClienteJuridicoRepository clienteJuridicoRepository;


    public ClienteJuridicoDto getClienteJuridicoById(Long id) {
        ClienteJuridico clienteJuridico = clienteJuridicoRepository.findById(id).orElse(null);
        ClienteJuridicoDto dto = new ClienteJuridicoDto(clienteJuridico);
        return dto;
    }

    public ClienteJuridicoDto createClienteJuridico(ClienteJuridico clienteJuridico) {
        clienteJuridico.setId(null);
        ClienteJuridico cJuridico = this.clienteJuridicoRepository.save(clienteJuridico);
        ClienteJuridicoDto dto = new ClienteJuridicoDto(cJuridico);
        return dto;
    } 

    public void deleteClienteJuridico(Long id) {
        ClienteJuridico cliente = clienteJuridicoRepository.findById(id).orElse(null);
        if (cliente != null && cliente.getContatos().isEmpty()) {
            clienteJuridicoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Não é possível excluir o cliente jurídico pois possui contatos associados.");
        }
    }

    public void updateClienteJuridico(Long id, ClienteJuridico clienteJuridico) {
        ClienteJuridico clienteExistente = clienteJuridicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (clienteJuridico.isAtivo() != clienteExistente.isAtivo()) {
            clienteExistente.setAtivo(clienteJuridico.isAtivo());

            for (Contato contato : clienteExistente.getContatos()) {
                contato.setAtivo(clienteJuridico.isAtivo());
            }
        }

        this.clienteJuridicoRepository.save(clienteExistente);
    }

    public void removeContatoFromClientes(Contato contato) {
        for (ClienteJuridico cliente : clienteJuridicoRepository.findAll()) {
            if (cliente.getContatos().contains(contato)) {
                cliente.getContatos().remove(contato);
                clienteJuridicoRepository.save(cliente);
                break;
            }
        }
    }
    
}
