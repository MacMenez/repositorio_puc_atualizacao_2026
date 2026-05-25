public class Pilha {
    private int[] array;
    private int n;

    Pilha(int tam) {
        this.array = new int[tam];
        this.n = 0;
    }

    public boolean cheia() {
        return n == array.length;
    }

    public boolean vazia() {
        return n == 0;
    }

    /*
     * Questão 2 - Item 2.3: Implementar o método empilhar(int x).
     * Nesta prova, o topo da pilha deve ficar na posição 0.
     */
    public void empilhar(int x) {
		// IMPLEMENTAR AQUI
        if (!cheia()) {
            array[n] = x;
            n++;
        }else{System.out.println("Pilha Cheia!");}
		
    }

    public int desempilhar() {
        int removido = -1;

        if (!vazia()) {
            removido = array[0];

            for (int i = 0; i < n - 1; i++) {
                array[i] = array[i + 1];
            }

            n--;
        }

        return removido;
    }

    public void mostrar() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]);

            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}
