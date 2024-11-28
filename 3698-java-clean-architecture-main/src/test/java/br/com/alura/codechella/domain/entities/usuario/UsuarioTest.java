package br.com.alura.codechella.domain.entities.usuario;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    @Test
    public void naoDeveCadastrarUmUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99",
                        "Enzo",
                        LocalDate.parse("1990-12-12"),
                        "email@email.com"));
    }

    @Test
    public void deveCriarUsuarioComAFabrica() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento
                ("Enzo",
                "123.456.789-22",
                LocalDate.parse("1993-10-10"));

        Assertions.assertEquals("Enzo", usuario.getNome());

        usuario = fabrica.incluiEndereco("12345-999", 40, "apto 201");

        Assertions.assertEquals("apto 201", usuario.getEndereco().getComplemento());
    }
}
