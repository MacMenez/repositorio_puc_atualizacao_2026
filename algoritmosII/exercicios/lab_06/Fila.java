public class Fila {
    private Jogo[] array;
    private int primeiro;
    private int ultimo;
    private int tamanho;

    public Fila() {
        this(60);
    }

    public Fila(int capacidade) {
        array = new Jogo[capacidade];
        primeiro = 0;
        ultimo = 0;
        tamanho = 0;
    }

    public void enfileirar(Jogo jogo) throws Exception {
        if (tamanho == array.length) {
            throw new Exception("Erro: fila cheia");
        }
        array[ultimo] = jogo;
        ultimo = (ultimo + 1) % array.length;
        tamanho++;
    }

    public Jogo desenfileirar() throws Exception {
        if (tamanho == 0) {
            throw new Exception("Erro: fila vazia");
        }
        Jogo jogo = array[primeiro];
        primeiro = (primeiro + 1) % array.length;
        tamanho--;
        return jogo;
    }

    public Jogo primeiro() throws Exception {
        if (tamanho == 0) {
            throw new Exception("Erro: fila vazia");
        }
        return array[primeiro];
    }

    public void mostrar() {
        for (int i = 0; i < tamanho; i++) {
            int index = (primeiro + i) % array.length;
            System.out.println(array[index].getNome_jogo());
        }
    }

    public int obterSomaVendasGlobal() {
        int soma = 0;
        for (int i = 0; i < tamanho; i++) {
            int index = (primeiro + i) % array.length;
            soma += array[index].getVendas_Global();
        }
        return soma;
    }
    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }
}
