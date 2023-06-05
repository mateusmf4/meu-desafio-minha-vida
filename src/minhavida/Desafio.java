package minhavida;

public abstract class Desafio {
    private String titulo;
    private int execucoes = 0;
    private String tipo;
    protected int satisfacao = 0;
    
    protected Desafio(String titulo, String tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getExecucoes() {
        return execucoes;
    }

    public int getSatisfacao() {
        return satisfacao;
    }

    public void concluir() {
        execucoes++;
    }

    @Override
    public String toString() {
        return String.format("Titulo: %s (%s)\n%d execuções", titulo, tipo, execucoes);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Desafio other = (Desafio) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }
}
