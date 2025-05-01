package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("051693229-55",
                        "Fran",
                        LocalDate.parse("1985-08-15"),
                        "francielle.ele@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("",
                        "Fran",
                        LocalDate.parse("1985-08-15"),
                        "francielle.ele@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(null,
                        "Fran",
                        LocalDate.parse("1985-08-15"),
                        "francielle.ele@gmail.com"));
    }

    @Test
    public void deveCriarUsuarioComFabrica() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento(
                "Francielle", "051.693.228-23", LocalDate.parse("2000-11-11"));
        Assertions.assertEquals("Francielle", usuario.getNome());
        usuario = fabrica.incluiEndereco("Santa Bernadeth", 813, "rua");
        Assertions.assertEquals("rua", usuario.getEndereco().getComplemento());
    }
}
