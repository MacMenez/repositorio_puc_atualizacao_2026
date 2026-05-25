import java.util.Scanner;

public class P1G2_0126 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		/* Item 0.1 IMPLEMENTAR AQUI:
         * Armazenar a capacidade da lista na variável capacidade
         * e instanciar uma lista.
         */
     
	 

		/* Item 0.2 IMPLEMENTAR AQUI:
         * Leitura dos códigos de acordo com o enunciado
         * e inserção de códigos válidos no fim da lista.
         */

      
	  

		/* Item 0.3 IMPLEMENTAR AQUI:
         * Leitura do divisor usado para remover os códigos múltiplos.
         */
		 
		 

        lista.removerMultiplosDe(divisor);
        lista.mostrar();

        FilaCircular fila = new FilaCircular(capacidade);

		/* Item 0.4 IMPLEMENTAR AQUI:
         * Inserção, na estrutura circular, dos valores da lista
         * terminados em 0 ou 5.
         */
		 
        
		

        fila.mostrar();

        Pilha pilha = new Pilha(capacidade);

        while (!fila.vazia()) {
            int removido = fila.removerFim();
            pilha.empilhar(removido);
        }

        pilha.mostrar();

        int[] vetor = lista.copiar();

        Ordenacao ord = new Ordenacao(vetor);
        ord.selection();
        ord.mostrar();

        sc.close();
    }
}

class Lista {
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
       
	   
    }

    /*
     * Questão 1 - Item 1.2: Implementar o método removerMultiplosDe(int divisor).
     * O método deve remover da lista todos os valores múltiplos de divisor,
     * preservando a ordem relativa dos valores restantes.
     */
    public void removerMultiplosDe(int divisor) {
		// IMPLEMENTAR AQUI
       
	   
    }

    /*
     * Questão 1 - Item 1.3: Implementar o método copiar().
     * O método deve retornar um vetor contendo apenas os elementos válidos da lista.
     */
    public int[] copiar() {
		// IMPLEMENTAR AQUI
       
	   
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

class FilaCircular {
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

        
		
    }

    /*
     * Questão 2 - Item 2.2: Implementar o método removerFim().
     * O método deve remover e retornar o elemento do fim da estrutura circular.
     */
    public int removerFim() {
		// IMPLEMENTAR AQUI


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

class Pilha {
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

class Ordenacao {
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
