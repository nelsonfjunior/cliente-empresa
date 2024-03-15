package com.nelsonjunior.clienteEmpresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.models.ClienteJuridico;
import com.nelsonjunior.clienteEmpresa.models.Contato;
import com.nelsonjunior.clienteEmpresa.repositories.ClienteJuridicoRepository;

@Service
public class ClienteJuridicoService {

    @Autowired
    private ClienteJuridicoRepository clienteJuridicoRepository;


    public ClienteJuridico getClienteJuridicoById(Long id) {
        return clienteJuridicoRepository.findById(id).orElse(null);
    }

    public ClienteJuridico createClienteJuridico(ClienteJuridico clienteJuridico) {
        clienteJuridico.setId(null);
        return this.clienteJuridicoRepository.save(clienteJuridico);
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

        clienteJuridicoRepository.save(clienteExistente);
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
