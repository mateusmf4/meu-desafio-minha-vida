package minhavida;

public class Acao {
    private Desafio desafio;
    private int progresso = 0;
    private String id;
    private String data;

    public Acao(String id, Desafio desafio, String data) {
        this.desafio = desafio;
        this.id = id;
        this.data = data;
    }

    public void progredir(int quant) {
        if (progresso < 100) {
            progresso += quant;
            if (progresso >= 100) {
                progresso = 100;
                desafio.concluir();
            }
        }
    }

    public void progredir() {
        progredir(10);
    }

    public int getProgresso() {
        return progresso;
    }

    @Override
    public String toString() {
        return String.format("Acao %s - %s - %s - Progresso %d", id, data, desafio.getTitulo(), progresso);
    }
}
