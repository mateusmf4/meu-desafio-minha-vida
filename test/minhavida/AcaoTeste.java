package minhavida;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AcaoTeste {
    @Test
    public void testeProgredir() {
        Desafio d = new DesafioPessoal("ir pra academia");
        Acao a = new Acao("44", d, "03/06/23");

        assertEquals("Acao 44 - 03/06/23 - ir pra academia - Progresso 0", a.toString());

        a.progredir();
        assertEquals("Acao 44 - 03/06/23 - ir pra academia - Progresso 10", a.toString());

        a.progredir(50);
        assertEquals("Acao 44 - 03/06/23 - ir pra academia - Progresso 60", a.toString());

        assertEquals(0, d.getExecucoes());

        a.progredir(40);
        assertEquals("Acao 44 - 03/06/23 - ir pra academia - Progresso 100", a.toString());
        assertEquals(1, d.getExecucoes());

        a.progredir(40);
        assertEquals("Acao 44 - 03/06/23 - ir pra academia - Progresso 100", a.toString());
        assertEquals(1, d.getExecucoes());
    }
}
