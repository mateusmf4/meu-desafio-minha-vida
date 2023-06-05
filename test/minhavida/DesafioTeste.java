package minhavida;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DesafioTeste {
    @Test
    public void testeDesafioPessoal() {
        Desafio d = new DesafioPessoal("ir na academia");

        assertEquals("Titulo: ir na academia (pessoal)\n0 execuções", d.toString());
        assertEquals(0, d.getSatisfacao());

        d.concluir();

        assertEquals("Titulo: ir na academia (pessoal)\n1 execuções", d.toString());
        assertEquals(10, d.getSatisfacao());

        d.concluir();

        assertEquals("Titulo: ir na academia (pessoal)\n2 execuções", d.toString());
        assertEquals(20, d.getSatisfacao());
    }

    @Test
    public void testeDesafioMaterial() {
        Desafio d = new DesafioMaterial("viajar pra fora", 5000);

        assertEquals("Titulo: viajar pra fora (material)\n0 execuções", d.toString());
        assertEquals(0, d.getSatisfacao());

        d.concluir();

        assertEquals("Titulo: viajar pra fora (material)\n1 execuções", d.toString());
        assertEquals(500, d.getSatisfacao());

        Desafio d2 = new DesafioMaterial("viajar pelo brasil", 300);

        assertEquals("Titulo: viajar pelo brasil (material)\n0 execuções", d2.toString());
        assertEquals(0, d2.getSatisfacao());

        d2.concluir();

        assertEquals("Titulo: viajar pelo brasil (material)\n1 execuções", d2.toString());
        assertEquals(30, d2.getSatisfacao());
    }

    @Test
    public void testeDesafioSocial() {
        Desafio d = new DesafioSocial("coletar lixo", 10);

        assertEquals("Titulo: coletar lixo (social)\n0 execuções", d.toString());
        
        assertEquals(0, d.getSatisfacao());
        d.concluir();
        assertEquals(20, d.getSatisfacao());
        
        d = new DesafioSocial("coletar lixo", 50);
        d.concluir();
        assertEquals(20, d.getSatisfacao());

        d = new DesafioSocial("coletar lixo", 51);
        d.concluir();
        assertEquals(50, d.getSatisfacao());

        d = new DesafioSocial("coletar lixo", 100);
        d.concluir();
        assertEquals(50, d.getSatisfacao());

        d = new DesafioSocial("coletar lixo", 101);
        d.concluir();
        assertEquals(101, d.getSatisfacao());

        d = new DesafioSocial("coletar lixo", 123);
        d.concluir();
        assertEquals(123, d.getSatisfacao());
    }
}
