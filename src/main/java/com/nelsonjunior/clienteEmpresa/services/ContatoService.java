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
    public Contato findById(Long id){  
        Optional<Contato> contato = contatoRepository.findById(id);
        return contato.orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    //Cadastrar Contato --> POST
    public Contato create(Contato contato){
        contato.setId(null);
        return this.contatoRepository.save(contato);
    }

    //Atualizar contato --> PUT
    public Contato update(Contato contato){
        Contato contatoNovo = findById(contato.getId());
        return this.contatoRepository.save(contatoNovo);
    }

    // Deletar contato --> DELETE
    public void delete(Long id){ 
        findById(id);
        try {
            this.contatoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir");
        }
    }

}
