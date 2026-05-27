package com.sistemalogin.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemalogin.security.model.Usuario;
import com.sistemalogin.security.model.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Get -> Página Index -> Essa página pode ser acessada por qualquer pessoa, logada ou não
    @GetMapping("/") // Substitui a página de "erro" para a página index.html. Toda vez que for feita uma requisição localhost:8080 -> Get
    public String index() { // Sempre que trabalhar com página html o retorno vai ser em string. 
        return "index"; // É o arquivo index.html
    }

    // Get -> Página de Cadastro - Precisa retornar o formulário de cadastro do usuário (cadastrar.html)
    @GetMapping("/cadastro") // localhost:8080/cadastro -> Get
    public String cadastroUsuario(Model model) { // Model -> import org.springframework.ui.Model; Model é um objeto usado para enviar dados do controller para a página HTML (view).
        model.addAttribute("usuario", new Usuario()); // addAtribute("nome do model", construtor do model)
        return "cadastro"; // É o arquivo cadastro.html
    }

    // Post -> Cadastro de Usuário. Cadastra um usuário com seus atributos. Irá ocorrer quando eu clicar no botão do formulário da página cadastro.html
    @PostMapping("/cadastro") // localhost:8080/cadastro -> Post -> Quando eu clicar no botão do formulário da página cadastro.html, o formulário irá enviar os dados para o servidor, e o servidor irá processar esses dados e salvar no banco de dados.
    public String cadastroRealizado(Model model) {
        // usuarioRepository.save(usuario);
        return "redirect:/logado"; // '/' significa que vai retornar para a página inicial (index.html)
    }

    // Get -> Página de Logada
    @GetMapping("/logado") // localhost:8080/logado -> Get
    public String areaLogada() { 
        return "logado"; // É o arquivo home.html
    }

}
