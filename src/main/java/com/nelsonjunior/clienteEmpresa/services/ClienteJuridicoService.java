package com.nelsonjunior.clienteEmpresa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.dto.ClienteJuridicoDto;
import com.nelsonjunior.clienteEmpresa.dto.ContatoDto;
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

    public List<ClienteJuridicoDto> getAllClienteJuridico() {
        List<ClienteJuridico> clientesJuridicos = clienteJuridicoRepository.findAllByContatos_Ativo(true);
        List<ClienteJuridicoDto> clientesJuridicosDto = new ArrayList<>();

        for (ClienteJuridico clienteJuridico : clientesJuridicos) {
            List<ContatoDto> contatosDto = new ArrayList<>();
            for (Contato contato : clienteJuridico.getContatos()) {
                if (contato.isAtivo()) {
                    ContatoDto contatoDto = new ContatoDto(contato.getNumero(), contato.getDescricao());
                    contatosDto.add(contatoDto);
                }
            }
            ClienteJuridicoDto clienteJuridicoDto = new ClienteJuridicoDto(clienteJuridico.getNome(),clienteJuridico.getCnpj(),contatosDto);
            clientesJuridicosDto.add(clienteJuridicoDto);
        }

        return clientesJuridicosDto;
    }


    public ClienteJuridicoDto createClienteJuridico(ClienteJuridico clienteJuridico) {
        clienteJuridico.setId(null);
        for(Contato contato : clienteJuridico.getContatos()){
            contato.setAtivo(true);
        }

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
        ClienteJuridico clienteExistente = clienteJuridicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente Jurídico não encontrado"));

        if (clienteJuridico.isAtivo() != clienteExistente.isAtivo()) {
            for (Contato contato : clienteExistente.getContatos()) {
                contato.setAtivo(clienteJuridico.isAtivo());
            }
        }
        clienteExistente.setId(id);
        clienteExistente.setNome(clienteJuridico.getNome());
        clienteExistente.setDataNasc(clienteJuridico.getDataNasc());
        clienteExistente.setAtivo(clienteJuridico.isAtivo());
        clienteExistente.setContatos(clienteJuridico.getContatos());
        clienteExistente.setCnpj(clienteJuridico.getCnpj());
        clienteExistente.setEmpresa(clienteJuridico.getEmpresa());
        clienteExistente.setIe(clienteJuridico.getIe());
        
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
