package com.EloysaRoodson.apidecadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EloysaRoodson.apidecadastro.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    boolean existsByTelefone(String telefone);
}
