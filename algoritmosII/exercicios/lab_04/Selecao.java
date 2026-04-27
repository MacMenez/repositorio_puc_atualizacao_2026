import java.util.ArrayList;

class Selecao {

   /**
    * Algoritmo de ordenacao por selecao.
    */
   public void sort(ArrayList<Jogo> lista_jogos) {
      int comparacao = 0;
      int movimentacao = 0;

      for (int i = 0; i < lista_jogos.size() - 1; i++) {
         int menor = i;

         for (int j = (i + 1); j < lista_jogos.size(); j++) {
            comparacao++;
            if ((lista_jogos.get(menor).getNome_jogo()).compareTo(lista_jogos.get(j).getNome_jogo()) > 0) {
               menor = j;
            }
         }

         if (menor != i) {
            swap(lista_jogos, menor, i);
            movimentacao += 3;
         }
      }
      
      // IMPRESSÃO DA LISTA ORDENADA
      for (int i = 0; i < lista_jogos.size(); i++) {
         Jogo jogo = new Jogo();
         lista_jogos.get(i).imprimir();
      }
      MyIO.println("## SELECTION [COMPARACOES] [" + comparacao + "] [MOVIMENTACOES] [" + movimentacao + "]");
   }

   /**
    * Troca o conteudo de duas posicoes do ArrayList
    */
   public void swap(ArrayList<Jogo> lista, int i, int j) {
      Jogo temp = lista.get(i);
      lista.set(i, lista.get(j));
      lista.set(j, temp);
   }
}