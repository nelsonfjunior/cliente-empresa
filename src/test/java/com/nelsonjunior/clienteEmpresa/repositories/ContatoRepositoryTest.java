package com.nelsonjunior.clienteEmpresa.repositories;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
import com.nelsonjunior.clienteEmpresa.models.Contato;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class ContatoRepositoryTest {

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Deve retornar todos os contatos que estão ativos")
    void testFindAllByAtivoCase1() {
        Contato contato = new Contato("descricao qualquer", 123456L, true);
        this.createContato(contato);

        List<Contato> results = this.contatoRepository.findAllByAtivo(true);

        assertThat(!results.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Não deve retornar todos os contatos que estão ativos")
    void testFindAllByAtivoCase2() {
        List<Contato> results = this.contatoRepository.findAllByAtivo(true);

        assertThat(results.isEmpty()).isTrue();
    }

    private Contato createContato(Contato contato) {
        entityManager.persist(contato);
        return contato;
    }


}
