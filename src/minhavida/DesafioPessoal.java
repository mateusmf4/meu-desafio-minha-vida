package minhavida;

public class DesafioPessoal extends Desafio {
    public DesafioPessoal(String titulo) {
        super(titulo, "pessoal");
    }

    @Override
    public void concluir() {
        super.concluir();
        satisfacao += 10;
    }
}
