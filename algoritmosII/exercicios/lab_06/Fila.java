public class Fila {
    private Celula primeiro, ultimo;
    private double somaVendasGlobal;
    private int tamanho;

    public Fila() {
        primeiro = new Celula();
        ultimo = primeiro;
        somaVendasGlobal = 0;
        tamanho = 0;
    }

    public void mostrar() {
        Celula i = primeiro.prox;
        int pos = 1;
        while (i != null) {
            System.out.println("[" + pos + "] " + i.elemento.toString());
            i = i.prox;
            pos++;
        }
    }

    public void enfileirar(Jogo jogo) throws Exception {
        ultimo.prox = new Celula(jogo.clone());
        ultimo = ultimo.prox;
        somaVendasGlobal += jogo.getVendas_Global();
        tamanho++;
    }

    public Jogo desenfileirar() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro: fila vazia");
        }
        Celula tmp = primeiro.prox;
        primeiro.prox = primeiro.prox.prox;
        Jogo elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        if (primeiro.prox == null)
            ultimo = primeiro;
        somaVendasGlobal -= elemento.getVendas_Global();
        tamanho--;
        return elemento;
    }

    public double obterSomaVendasGlobal() {
        return (int) Math.round(somaVendasGlobal);
    }

    public int size() {
        return tamanho;
    }

}
