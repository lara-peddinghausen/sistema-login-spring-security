package com.sistemalogin.security.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//   - Usuario: a entidade gerenciada por este repositório
//   - Long: o tipo do @Id (chave primária) da entidade Usuario.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Query derivada: Spring cria automaticamente o SQL: SELECT * FROM usuario WHERE nome = ?
    // Optional: proteção contra NullPointerException. Se o usuário não existir no banco, retorna Optional.empty() em vez de null. Permite usar .orElseThrow() para lançar uma exceção personalizada.
    // findByNome: Customizado — query derivada do nome do método
    Optional<Usuario> findByNome(String nome);
}
