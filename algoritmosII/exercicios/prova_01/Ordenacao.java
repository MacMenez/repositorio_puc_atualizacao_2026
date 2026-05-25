public class Ordenacao {
    private int[] array;

    Ordenacao(int[] array) {
        this.array = array;
    }

    /*
     * Questão 3 - Item 3.1: Implementar o método selection().
     * O método deve ordenar o vetor em ordem crescente usando Selection Sort.
     */
    public void selection() {
        // IMPLEMENTAR AQUI

        for (int i = 0; i < array.length; i++) {
            if (array[i + 1] < array[i]) {
                int menor = array[i];
                array[i] = array[i + 1];
                array[i + 1] = menor;
            }
        }

    }

    public void mostrar() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}
