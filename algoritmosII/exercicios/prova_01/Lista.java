public class Lista {
    private int[] array;
    private int n;

    Lista(int tam) {
        this.array = new int[tam];
        this.n = 0;
    }

    public boolean cheia() {
        return n == array.length;
    }

    public boolean vazia() {
        return n == 0;
    }

    public int get(int pos) {
        return array[pos];
    }

    public int getTamanho() {
        return n;
    }

    /*
     * Questão 1 - Item 1.1: Implementar o método inserirFim(int x).
     * O método deve inserir o valor x no fim da lista.
     */
    public void inserirFim(int x) {
        // IMPLEMENTAR AQUI
        if (!cheia()) {
            array[n] = x;
            n++;
        }

    }

    /*
     * Questão 1 - Item 1.2: Implementar o método removerMultiplosDe(int divisor).
     * O método deve remover da lista todos os valores múltiplos de divisor,
     * preservando a ordem relativa dos valores restantes.
     */
    public void removerMultiplosDe(int divisor) {
        // IMPLEMENTAR AQUI
        int elemetoRetirado;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % divisor == 0) {
                elemetoRetirado = array[i];
                for (int j = i; j < array.length; j++) {
                    array[j] = array[j + 1];
                }
            }
        }
    }

    /*
     * Questão 1 - Item 1.3: Implementar o método copiar().
     * O método deve retornar um vetor contendo apenas os elementos válidos da
     * lista.
     */
    public int[] copiar() {
        // IMPLEMENTAR AQUI
        return array;
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
