package com.sistemalogin.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// Para cadastro/login preciso ter pelo menos esses atributos

@Data // Ajuda a reduzir código repetitivo. Equivale a usar @Getter, @Setter, @ToString, @EqualsAndHashCode e @RequiredArgsConstructor juntos.
@Entity
@NoArgsConstructor
@Table(name = "usuarios") // Especifica o nome da tabela no banco de dados
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true) // Garante que o nome seja único e não nulo
    private String nome;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String role;
}
