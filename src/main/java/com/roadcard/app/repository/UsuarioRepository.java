package com.roadcard.app.repository;

import com.roadcard.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCpfOrNome(String cpf, String nome);
}
