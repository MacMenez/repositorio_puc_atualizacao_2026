public class No {
    public No esquerda;
    public No direita;
    public Jogo jogo;

    public No(Jogo jogo) {
        this.jogo = jogo;
        this.esquerda = null;
        this.direita = null;
    }
}
