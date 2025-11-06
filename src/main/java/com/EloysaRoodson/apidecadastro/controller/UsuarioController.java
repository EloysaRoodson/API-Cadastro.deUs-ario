package com.EloysaRoodson.apidecadastro.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.EloysaRoodson.apidecadastro.entity.Usuario;
import com.EloysaRoodson.apidecadastro.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        if (usuario == null ||
            usuario.getNome() == null || usuario.getEmail() == null ||
            usuario.getSenha() == null || usuario.getTelefone() == null ||
            usuario.getNome().trim().isEmpty() || usuario.getEmail().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Campos obrigatórios não podem estar vazios.");
        }

        // Check if user already exists with this email or phone number
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest().body("Um usuário com este email já está cadastrado.");
        }
        
        if (usuarioRepository.existsByTelefone(usuario.getTelefone())) {
            return ResponseEntity.badRequest().body("Um usuário com este telefone já está cadastrado.");
        }
        
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

  
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

  @GetMapping("/{id}")
public ResponseEntity<?> buscarUsuarioPorId(@PathVariable long id) {
    return usuarioRepository.findById(id)
            .map(usuario -> ResponseEntity.ok().body(usuario))
            .orElse(ResponseEntity.notFound().build());
}



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.badRequest().body(" Usuário não encontrado para exclusão.");
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok(" Usuário deletado com sucesso!");
    }
}
