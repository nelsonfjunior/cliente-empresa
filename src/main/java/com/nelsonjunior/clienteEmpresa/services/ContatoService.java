package com.nelsonjunior.clienteEmpresa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.models.Contato;
import com.nelsonjunior.clienteEmpresa.repositories.ContatoRepository;

@Service
public class ContatoService {
    
    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    ClienteJuridicoService clienteJuridicoService; 

    //Encontrar por ID --> GET
    public Contato getContatoById(Long id){  
        Optional<Contato> contato = contatoRepository.findById(id);
        return contato.orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    //Cadastrar Contato --> POST
    public Contato createContato(Contato contato){
        contato.setId(null);
        return this.contatoRepository.save(contato);
    }

    //Atualizar contato --> PUT
    public Contato updateContato(Contato contato){
        Contato contatoNovo = getContatoById(contato.getId());
        return this.contatoRepository.save(contatoNovo);
    }

    // Deletar contato --> DELETE
    public void deleteContato(Long id){ 
        Contato contato = getContatoById(id);
        clienteJuridicoService.removeContatoFromClientes(contato);
        this.contatoRepository.deleteById(id);
    }

}
