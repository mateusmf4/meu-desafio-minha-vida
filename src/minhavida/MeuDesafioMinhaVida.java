package minhavida;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeuDesafioMinhaVida {
    private List<Desafio> desafios = new ArrayList<>();
    private Map<String, Acao> acoes = new HashMap<>();

    private int addDesafio(Desafio d) {
        if (desafios.contains(d)) throw new IllegalArgumentException("Desafio com mesmo titulo já existe");
        desafios.add(d);
        return desafios.size();
    }

    private Desafio getDesafio(int id) {
        id--;
        if (id < 0 || id >= desafios.size()) throw new IllegalArgumentException("Desafio não encontrado");
        return desafios.get(id);
    }

    public int addDesafioPessoal(String titulo) {
        Desafio d = new DesafioPessoal(titulo);
        return addDesafio(d);
    }

    public int addDesafioMaterial(String titulo, double valor) {
        Desafio d = new DesafioMaterial(titulo, valor);
        return addDesafio(d);
    }

    public int addDesafioSocial(String titulo, int pessoas) {
        Desafio d = new DesafioSocial(titulo, pessoas);
        return addDesafio(d);
    }
    
    public String exibirDesafio(int id) {
        return getDesafio(id).toString();
    }

    public int getSatisfacaoDesafio(int id) {
        return getDesafio(id).getSatisfacao();
    }

    private Acao getAcao(String id) {
        if (!acoes.containsKey(id)) throw new IllegalArgumentException("Ação não encontrada");
        return acoes.get(id);
    }

    public void addAcao(int idDesafio, String data, String id) {
        if (acoes.containsKey(id)) throw new IllegalArgumentException("Ação com mesmo id já existe");
        Desafio d = getDesafio(idDesafio);
        acoes.put(id, new Acao(id, d, data));
    }

    public void atualizaProgressoAcao(String id, int quantidade) {
        getAcao(id).progredir(quantidade);
    }

    public void atualizaProgressoAcao(String id) {
        getAcao(id).progredir();
    }

    public String listarAcoesPorProgresso() {
        ArrayList<Acao> acoesOrd = new ArrayList<>(acoes.values());
        Collections.sort(acoesOrd, Comparator.comparing((acao) -> acao.getProgresso()));

        String result = "";
        for (Acao acao : acoesOrd) {
            result += acao.toString() + "\n";
        }
        return result.trim();
    }
}
