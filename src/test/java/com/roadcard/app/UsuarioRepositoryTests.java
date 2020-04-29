package com.roadcard.app;

import com.roadcard.app.model.Usuario;
import com.roadcard.app.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void whenBuscaPorNomeOuCpf_thenRetornaUsuario(){

        Usuario usuario = new Usuario("Rodrigo","12345678909");
        entityManager.persist(usuario);
        entityManager.flush();

        Usuario encontrado = usuarioRepository.findByCpfOrNome(usuario.getCpf(), usuario.getNome());

        assertThat(encontrado.getNome()).isEqualTo(usuario.getNome());
    }

    @Test
    public void whenLista_thenRetornaTodosUsuarios(){

        Usuario usuario1 = new Usuario("Rodrigo","12345678909");
        Usuario usuario2 = new Usuario("Pedro","98765432109");
        entityManager.persist(usuario1);
        entityManager.persist(usuario2);
        entityManager.flush();

        List<Usuario> list = usuarioRepository.findAll();

        //Quando a aplicação é iniciada, o script 'data.sql' roda e adiciona 2 linhas na tabela 'Usuario'.
        //Para ser assertivo no teste, busco pelos índices 2 e 3 da lista para comparar com os novos usuários criados no teste.
        assertThat(list.get(2).getNome()).isEqualTo(usuario1.getNome());
        assertThat(list.get(2).getCpf()).isEqualTo(usuario1.getCpf());
        assertThat(list.get(3).getNome()).isEqualTo(usuario2.getNome());
        assertThat(list.get(3).getCpf()).isEqualTo(usuario2.getCpf());
    }

    @Test
    public void whenAtualiza_thenRetornaUsuarioAtualizado(){

        Usuario usuario = usuarioRepository.findById(1L).orElse(null);
        usuario.setNome("Novo Nome");
        usuario.setCpf("123");
        usuarioRepository.save(usuario);

        Usuario atualizado = usuarioRepository.findByCpfOrNome("123", "Novo Nome");
        assertThat(atualizado.getNome()).isEqualTo("Novo Nome");
        assertThat(atualizado.getCpf()).isEqualTo("123");
    }

    @Test
    public void whenRemove_thenNaoAcha(){

        usuarioRepository.deleteById(1L);
        Usuario usuario = usuarioRepository.findById(1L).orElse(null);

        assertThat(usuario == null);
    }

    @Test
    public void whenCadastra_thenRetornaUsuarioCadastrado(){

        Usuario usuario = new Usuario("Teste Cadastro","10203040501");
        usuarioRepository.save(usuario);

        Usuario cadastrado = usuarioRepository.findByCpfOrNome("10203040501","Teste Cadastro");
        assertThat(cadastrado.getNome()).isEqualTo(usuario.getNome());
        assertThat(cadastrado.getCpf()).isEqualTo(usuario.getCpf());
    }
}
