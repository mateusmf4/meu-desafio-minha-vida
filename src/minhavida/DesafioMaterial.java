package minhavida;

public class DesafioMaterial extends Desafio {
    private int incSatisfacao;

    public DesafioMaterial(String titulo, double valor) {
        super(titulo, "material");
        incSatisfacao = (int)(valor / 100.0) * 10;
    }

    @Override
    public void concluir() {
        super.concluir();
        satisfacao += incSatisfacao;
    }
}
