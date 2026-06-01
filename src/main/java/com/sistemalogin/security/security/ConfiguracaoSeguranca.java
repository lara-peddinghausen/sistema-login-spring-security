package com.sistemalogin.security.security;


import java.util.Collections; // Collections no plural!!

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sistemalogin.security.model.Usuario;
import com.sistemalogin.security.model.UsuarioRepository;

// Classe de configuração. Nela vou informar quais são as regras de segurança da minha aplicação. Ex: quais páginas só podem ser acessadas por usuários autenticados.

// UserDetailsService usa como padrão: username, password e role

@Configuration // Marca como classe de configuração Spring. Diz ao Spring: "esta classe contém definições de beans". Processada durante a inicialização da aplicação. Substitui o antigo arquivo XML de configuração. Pode conter múltiplos métodos @Bean
public class ConfiguracaoSeguranca {
  
    // 1 - AUTENTICAÇÃO - Cadastro Novo, Login realizado(?)
    // Bean 1: como o Security carrega o usuário do banco. Marca o método como um bean gerenciado pelo Spring. O Spring chama o método uma vez e armazena o resultado. O objeto pode ser injetado em qualquer lugar com @Autowired. Substitui a instanciação manual com new.
    @Bean
    
    public UserDetailsService userDetailsService (UsuarioRepository usuarioRepository) {
        // Esta lambda implementa loadUserByUsername(String username). O Spring Security a chama automaticamente no momento do login. Verifica se o username existe.
        return username -> {
            // PASSO 1: busca o usuário no banco pelo nome digitado no form. Se não achar → lança a exceção → login falha automaticamente.
            Usuario usuario = usuarioRepository.findByNome(username)
            .orElseThrow(() -> new UsernameNotFoundException(
                "Usuário não encontrado" + username));

            // PASSO 2: constrói e retorna o objeto UserDetails. User(username, password, authorities)[Sempre nessa ordem] — classe do Spring Security 
            return new User(
                usuario.getNome(),
                usuario.getSenha(),
                Collections.singleton(
                    new SimpleGrantedAuthority("ROLE_USER") //GrantedAuthority representa uma permissão ou papel (role) concedida ao usuário. No Spring Security, roles são prefixadas com ROLE_
                )
            );
        }; 
    }

    // 2 - AUTORIZAÇÃO
}
