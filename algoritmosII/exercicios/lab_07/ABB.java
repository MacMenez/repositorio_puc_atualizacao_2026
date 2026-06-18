public class ABB {
    private No raiz;

    public ABB() {
        this.raiz = null;
    }

    public void inserir(Jogo jogo) {
        raiz = inserirRecursivo(raiz, jogo);
    }

    private No inserirRecursivo(No no, Jogo jogo) {
        if (no == null) {
            return new No(jogo);
        } else if (jogo.getNome_jogo().compareToIgnoreCase(no.jogo.getNome_jogo()) < 0) {
            no.esquerda = inserirRecursivo(no.esquerda, jogo);
        } else if (jogo.getNome_jogo().compareToIgnoreCase(no.jogo.getNome_jogo()) > 0) {
            no.direita = inserirRecursivo(no.direita, jogo);
        }

        return no;
    }

    public void buscar(String nome_jogo, int jogos_encontrados, int jogos_Nencontrados) {
        buscarRecursivo(raiz, nome_jogo, jogos_encontrados, jogos_Nencontrados);
    }

    private void buscarRecursivo(No no, String nome_jogo, int jogos_encontrados, int jogos_Nencontrados) {
        if (no == null) {
            jogos_Nencontrados++;
            MyIO.println("- NAO");
        }
        else if (nome_jogo.equals(no.jogo.getNome_jogo())) {
            jogos_encontrados++;
            no.jogo.imprimir();
            MyIO.println(" - SIM");
        } else if (nome_jogo.compareToIgnoreCase(no.jogo.getNome_jogo()) < 0) {
            buscarRecursivo(no.esquerda, nome_jogo, jogos_encontrados, jogos_Nencontrados);
            // MyIO.println(" - " + no.esquerda.jogo.toString());
        } else {
            buscarRecursivo(no.direita, nome_jogo, jogos_encontrados, jogos_Nencontrados);
            // MyIO.println(" - " + no.direita.jogo.toString());
        }
    }
}