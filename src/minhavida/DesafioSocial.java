package minhavida;

public class DesafioSocial extends Desafio {
    private int incSatisfacao = 0;

    public DesafioSocial(String titulo, int pessoas) {
        super(titulo, "social");
        if (pessoas >= 10 && pessoas <= 50) {
            incSatisfacao = 20;
        } else if (pessoas >= 51 && pessoas <= 100) {
            incSatisfacao = 50;
        } else if (pessoas > 100) {
            incSatisfacao = pessoas;
        }
    }

    @Override
    public void concluir() {
        super.concluir();
        satisfacao += incSatisfacao;
    }
}
