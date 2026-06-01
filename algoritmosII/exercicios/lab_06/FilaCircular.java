public class FilaCircular {
    private Jogo[] array;
    private int primeiro;
    private int ultimo;
    private int tamanho;
    private double somaVendasGlobal;

    public FilaCircular() {
        this(60);
    }

    public FilaCircular(int capacidade) {
        array = new Jogo[capacidade + 1];
        primeiro = ultimo = tamanho = 0;
        somaVendasGlobal = 0;
    }

    public void mostrar() {
        int pos = 1;
        for (int i = primeiro; i != ultimo; i++) {
            System.out.println("[" + pos + "] " + array[i].toString());
            i = (i + 1) % array.length;
            pos++;
        }
    }

    public void enfileirar(Jogo jogo) throws Exception {
        if (((ultimo + 1) % array.length) == primeiro) {
            desenfileirar();
        }
        array[ultimo] = jogo.clone();
        ultimo = (ultimo + 1) % array.length;
        somaVendasGlobal += jogo.getVendas_Global();
        tamanho++;
    }

    public Jogo desenfileirar() throws Exception {
        if (tamanho == 0) {
            throw new Exception("Erro: fila vazia");
        }
        Jogo jogo = array[primeiro];
        primeiro = (primeiro + 1) % array.length;
        somaVendasGlobal -= jogo.getVendas_Global();
        tamanho--;
        return jogo;
    }

    public double obterSomaVendasGlobal() {
        return (int) Math.round(somaVendasGlobal);
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == array.length;
    }

    public int size() {
        return (ultimo - primeiro + array.length) % array.length;
    }

    
}
