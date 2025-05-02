package br.com.alura.codechella.aplication.usecases;

import br.com.alura.codechella.aplication.gateways.RepositorioDeUsuario;

public class ExcluirUsuario {
    private final RepositorioDeUsuario repositorio;

    public ExcluirUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public void excluirUsuario(String cpf) {
        repositorio.excluiUsuario(cpf);
    }
}
