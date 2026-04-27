import java.util.ArrayList;

class Insercao {

   /**
    * Algoritmo de ordenacao por insercao.
    */
   public void sort(ArrayList<Jogo> lista_jogos) {
      int comparacao = 0;
      int movimentacao = 0;

      for (int i = 1; i < lista_jogos.size(); i++) {
         Jogo tmp = lista_jogos.get(i);
         int j = i - 1;

         while (j >= 0 && lista_jogos.get(j).compareTo(tmp) > 0) {
            comparacao++;
            lista_jogos.set(j + 1, lista_jogos.get(j));
            movimentacao++;
            j--;
         }

         lista_jogos.set(j + 1, tmp);
         movimentacao++;
      }

      MyIO.println("## INSERTION [COMPARACOES] [" + comparacao + "] [MOVIMENTACOES] [" + movimentacao + "]");
   }
}