package com.nelsonjunior.clienteEmpresa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelsonjunior.clienteEmpresa.models.Cliente;
import com.nelsonjunior.clienteEmpresa.models.Empresa;
import com.nelsonjunior.clienteEmpresa.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpresaService empresaService;


    //Encontrar por ID --> GET
    public Cliente findById(Long id){  
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    //Cadastrar cliente --> POST
    public Cliente create(Cliente cliente){
        Empresa empresa = this.empresaService.findById(cliente.getEmpresa().getId());
        cliente.setId(null);
        cliente.setEmpresa(empresa);
        cliente = this.clienteRepository.save(cliente);
        return cliente;
    }

    //Atualizar cliente --> PUT
    public Cliente update(Cliente cliente){
        Cliente clienteNovo = findById(cliente.getId());
        clienteNovo.setAtivo(cliente.isAtivo());
        return this.clienteRepository.save(clienteNovo);
    }

    // Deletar cliente --> DELETE
    public void delete(Long id){ 
        findById(id);
        try {
            this.clienteRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir");
        }
    }



}
