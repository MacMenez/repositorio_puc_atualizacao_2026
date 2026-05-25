public class FilaCircular {
    private int[] array;
    private int primeiro;
    private int ultimo;

    FilaCircular(int tam) {
        this.array = new int[tam + 1];
        this.primeiro = 0;
        this.ultimo = 0;
    }

    public boolean cheia() {
        return (ultimo + 1) % array.length == primeiro;
    }

    public boolean vazia() {
        return primeiro == ultimo;
    }

    /*
     * Questão 2 - Item 2.1: Implementar o método inserirInicio(int x).
     * O método deve inserir o valor x no início da estrutura circular.
     */
    public void inserirInicio(int x) {
        // IMPLEMENTAR AQUI
        for (int i = 0; i < array.length; i++) {
            if (!cheia()) {
                
            }
        }
    }

    /*
     * Questão 2 - Item 2.2: Implementar o método removerFim().
     * O método deve remover e retornar o elemento do fim da estrutura circular.
     */
    public int removerFim() {
        // IMPLEMENTAR AQUI
        int removidoFim = -1; // ultima posição
        
        if(!vazia()){
            removidoFim = array[ultimo]; // ultima posição
            ultimo = (ultimo - 1) % array.length; // calculo para pegar a penultima posição
        }else{ System.out.println("Fila Vazia!");}

        return removidoFim;
    }

    public void mostrar() {
        int i = primeiro;
        boolean primeiroElemento = true;

        while (i != ultimo) {
            if (!primeiroElemento) {
                System.out.print(" ");
            }

            System.out.print(array[i]);
            primeiroElemento = false;
            i = (i + 1) % array.length;
        }

        System.out.println();
    }
}
