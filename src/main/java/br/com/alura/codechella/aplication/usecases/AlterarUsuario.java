package br.com.alura.codechella.aplication.usecases;

import br.com.alura.codechella.aplication.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class AlterarUsuario {
    private final RepositorioDeUsuario repositorio;

    public AlterarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario alteraDadosUsuario(String cpf, Usuario usuario) {
        return repositorio.alteraUsuario(cpf, usuario);
    }
}
