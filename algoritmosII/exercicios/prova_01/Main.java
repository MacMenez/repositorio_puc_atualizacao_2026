import java.util.Scanner;

import arquivo_prova_01.FilaCircular;
import arquivo_prova_01.Lista;
import arquivo_prova_01.Ordenacao;
import arquivo_prova_01.Pilha;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		/* Item 0.1 IMPLEMENTAR AQUI:
         * Armazenar a capacidade da lista na variável capacidade
         * e instanciar uma lista.
         */
        int capacidade = Integer.parseInt(MyIO.readLine()); // Armazenar a capacidade da lista na variável capacidade
        Lista lista = new Lista(capacidade); // Instanciar uma lista
	 

		/* Item 0.2 IMPLEMENTAR AQUI:
         * Leitura dos códigos de acordo com o enunciado
         * e inserção de códigos válidos no fim da lista.
         */
        int lerNumero;
        while (( lerNumero = MyIO.readInt()) != -1) {
            if (!lista.cheia()) {
                lista.inserirFim(lerNumero);
            }else{ lerNumero = -1; } // Forçar parada para fila cheia
        }
      
	  

		/* Item 0.3 IMPLEMENTAR AQUI:
         * Leitura do divisor usado para remover os códigos múltiplos.
         */
		int divisor = MyIO.readInt();
		
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