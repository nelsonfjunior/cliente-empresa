package com.nelsonjunior.clienteEmpresa.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.dto.ContatoDto;
import com.nelsonjunior.clienteEmpresa.models.Contato;
import com.nelsonjunior.clienteEmpresa.repositories.ContatoRepository;

@Service
public class ContatoService {
    
    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    ClienteJuridicoService clienteJuridicoService; 

    //Encontrar por ID --> GET
    public ContatoDto getContatoById(Long id){  
        Contato contato = contatoRepository.findById(id).orElse(null);
        ContatoDto dto = new ContatoDto(contato);
        return dto;
    }

    //Cadastrar Contato --> POST
    public ContatoDto createContato(Contato contato){
        contato.setId(null);
        Contato contatoCriado = this.contatoRepository.save(contato);
        ContatoDto dto = new ContatoDto(contatoCriado);
        return dto;
    }

    //Atualizar contato --> PUT
    public void updateContato(Contato contato){
        Contato contatoNovo = contatoRepository.findById(contato.getId()).orElse(null);
        this.contatoRepository.save(contatoNovo);
    }

    // Deletar contato --> DELETE
    public void deleteContato(Long id){ 
        Contato contato = contatoRepository.findById(id).orElse(null);
        clienteJuridicoService.removeContatoFromClientes(contato);
        this.contatoRepository.deleteById(id);
    }

}
