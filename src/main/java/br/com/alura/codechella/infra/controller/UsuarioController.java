package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.aplication.usecases.AlterarUsuario;
import br.com.alura.codechella.aplication.usecases.CriarUsuario;
import br.com.alura.codechella.aplication.usecases.ExcluirUsuario;
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
    private final AlterarUsuario alterarUsuario;
    private final ExcluirUsuario excluirUsuario;

    public UsuarioController(CriarUsuario criarUsuario,
                             ListarUsuarios listarUsuarios,
                             AlterarUsuario alterarUsuario,
                             ExcluirUsuario excluirUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.alterarUsuario = alterarUsuario;
        this.excluirUsuario = excluirUsuario;
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

    @PutMapping("/{cpf}")
    public UsuarioDto atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDto dto) {
        Usuario atualizado = alterarUsuario.alteraDadosUsuario(cpf,
                new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDto(atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(), atualizado.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void excluirUsuario(@PathVariable String cpf) {
        excluirUsuario.excluirUsuario(cpf);
    }
}
