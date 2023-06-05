package minhavida;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

public class MeuDesafioMinhaVidaTeste {
    private MeuDesafioMinhaVida sistema;

    @BeforeEach
    public void setup() {
        sistema = new MeuDesafioMinhaVida();
    }

    @Test
    public void testeDesafioPessoal() {
        int academia = sistema.addDesafioPessoal("Ir pra academia");
        assertEquals(1, academia);
        assertEquals("Titulo: Ir pra academia (pessoal)\n0 execuções", sistema.exibirDesafio(academia));
        assertEquals(0, sistema.getSatisfacaoDesafio(academia));
    }

    @Test
    public void testeDesafioMaterial() {
        int yatch = sistema.addDesafioMaterial("Comprar um yatch", 3000);
        assertEquals(1, yatch);
        assertEquals("Titulo: Comprar um yatch (material)\n0 execuções", sistema.exibirDesafio(yatch));
        assertEquals(0, sistema.getSatisfacaoDesafio(yatch));
    }

    @Test
    public void testeDesafioSocial() {
        int lixo = sistema.addDesafioSocial("Limpar o lixo da cidade", 56);
        assertEquals(1, lixo);
        assertEquals("Titulo: Limpar o lixo da cidade (social)\n0 execuções", sistema.exibirDesafio(lixo));
        assertEquals(0, sistema.getSatisfacaoDesafio(lixo));
    }

    @Test
    public void testeDesafioMesmoNome() {
        int academia = sistema.addDesafioPessoal("Ir pra academia");
        assertEquals(1, academia);

        Exception err = assertThrows(IllegalArgumentException.class, () -> sistema.addDesafioPessoal("Ir pra academia"));
        assertEquals("Desafio com mesmo titulo já existe", err.getMessage());

        int academia2 = sistema.addDesafioPessoal("Ir pra academia amanhã");
        assertEquals(2, academia2);
    }

    @Test
    public void testeDesafioNaoExiste() {
        Exception err = assertThrows(IllegalArgumentException.class, () -> sistema.exibirDesafio(1));
        assertEquals("Desafio não encontrado", err.getMessage());

        int academia = sistema.addDesafioPessoal("Ir pra academia");
        assertEquals(1, academia);
        assertEquals("Titulo: Ir pra academia (pessoal)\n0 execuções", sistema.exibirDesafio(academia));

        err = assertThrows(IllegalArgumentException.class, () -> sistema.exibirDesafio(123));
        assertEquals("Desafio não encontrado", err.getMessage());
    }

    @Test
    public void testeProgredirAcao() {
        int academia = sistema.addDesafioPessoal("Ir pra academia");
        assertEquals(1, academia);
        int semAcucar = sistema.addDesafioPessoal("Não comer açúcar por 100 anos");
        assertEquals(2, semAcucar);

        sistema.addAcao(academia, "14/12/2022", "52");
        sistema.atualizaProgressoAcao("52");

        sistema.addAcao(semAcucar, "14/12/2022", "44");
        sistema.atualizaProgressoAcao("44");
        sistema.atualizaProgressoAcao("44", 40);

        assertEquals(
            "Acao 52 - 14/12/2022 - Ir pra academia - Progresso 10\n" +
            "Acao 44 - 14/12/2022 - Não comer açúcar por 100 anos - Progresso 50",
            sistema.listarAcoesPorProgresso()
        );
    }

    @Test
    public void testeConcluirDesafio() {
        int academia = sistema.addDesafioPessoal("Ir pra academia");
        assertEquals(1, academia);

        sistema.addAcao(academia, "14/12/2022", "52");
        sistema.atualizaProgressoAcao("52");

        assertEquals(0, sistema.getSatisfacaoDesafio(academia));

        sistema.atualizaProgressoAcao("52", 90);

        assertEquals(10, sistema.getSatisfacaoDesafio(academia));
        
        // não deve ter nenhum efeito
        sistema.atualizaProgressoAcao("52", 20);
        assertEquals(10, sistema.getSatisfacaoDesafio(academia));

        assertEquals("Titulo: Ir pra academia (pessoal)\n1 execuções", sistema.exibirDesafio(academia));

        sistema.addAcao(academia, "20/12/2022", "11");
        sistema.atualizaProgressoAcao("11", 100);

        assertEquals("Titulo: Ir pra academia (pessoal)\n2 execuções", sistema.exibirDesafio(academia));

    }
}
