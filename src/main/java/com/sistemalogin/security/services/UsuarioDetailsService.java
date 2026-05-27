package com.sistemalogin.security.services;


import org.springframework.stereotype.Service;

import com.sistemalogin.security.model.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

// Classe para capturar do usuário qual é sua senha e seu e-mail. Ver se o e-mail está no banco de dados, se tiver, comparar a senha do usuário com a senha do banco de dados. Se for igual, o usuário é autenticado, se não for, o usuário não é autenticado.

@Service
public class UsuarioDetailsService implements UserDetailsService {
	
    // Injeção para acessar os dados do usuário que estão no BD para autenticação.
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método que será chamado SS para carregar os detalhes do usuário com base no nome do usuário(neste caso, o e-mail) fornecido na autenticação
    public UserDetails carregarDadosPorEmail(String email) { // 

    }

}
