package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.aplication.usecases.CriarUsuario;
import br.com.alura.codechella.aplication.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;

    public UsuarioController(CriarUsuario criarUsuario,
                             ListarUsuarios listarUsuarios) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
    }

    @GetMapping
    public List<UsuarioDto> listarUsuario() {
        return listarUsuarios.obterTodosUsuarios().stream()
                .map(usuario -> new UsuarioDto(usuario.getCpf(),
                        usuario.getNome(),
                        usuario.getNascimento(),
                        usuario.getEmail())).collect(Collectors.toList());

    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario usuarioSalvo = criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(),
                dto.nome(),
                dto.nascimento(),
                dto.email()));
        return new UsuarioDto(usuarioSalvo.getCpf(),
                usuarioSalvo.getNome(),
                usuarioSalvo.getNascimento(),
                usuarioSalvo.getEmail());
    }
}
