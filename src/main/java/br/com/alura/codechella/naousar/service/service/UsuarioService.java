package br.com.alura.codechella.naousar.service.service;

import br.com.alura.codechella.naousar.model.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
