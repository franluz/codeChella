package br.com.alura.codechella.naousar.repository.repository;

import br.com.alura.codechella.naousar.model.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
