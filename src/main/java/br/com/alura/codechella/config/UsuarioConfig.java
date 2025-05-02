package br.com.alura.codechella.config;

import br.com.alura.codechella.aplication.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.aplication.usecases.AlterarUsuario;
import br.com.alura.codechella.aplication.usecases.CriarUsuario;
import br.com.alura.codechella.aplication.usecases.ExcluirUsuario;
import br.com.alura.codechella.aplication.usecases.ListarUsuarios;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    RepositorioDeUsuarioJpa criarRepositorio(UsuarioRepository repository,
                                             UsuarioEntityMapper mapper) {
        return new RepositorioDeUsuarioJpa(repository, mapper);
    }

    @Bean
    UsuarioEntityMapper criarEntityMapper() {
        return new UsuarioEntityMapper();
    }

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    ListarUsuarios listarUsuarios(RepositorioDeUsuario repositorioDeUsuario) {
        return new ListarUsuarios(repositorioDeUsuario);
    }

    @Bean
    ExcluirUsuario excluirUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new ExcluirUsuario(repositorioDeUsuario);
    }

    @Bean
    AlterarUsuario alterarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new AlterarUsuario(repositorioDeUsuario);
    }
}
