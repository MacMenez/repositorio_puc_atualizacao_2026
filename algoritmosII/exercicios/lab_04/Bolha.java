import java.util.ArrayList;

/**
 * Metodo de ordenacao da bolha
 */
class Bolha {

   /**
    * Algoritmo de ordenacao Bolha.
    */
   public void sort(ArrayList<Jogo> lista_jogos) {
      int comparacao = 0;
      int movimentacao = 0;

      for (int i = lista_jogos.size() - 1; i > 0; i--) {
         for (int j = 0; j < i; j++) {

            comparacao++;
            if (maior(lista_jogos.get(j), lista_jogos.get(j + 1))) {
               swap(lista_jogos, j, j + 1);
               movimentacao += 3;
            }
         }
      }

      MyIO.println("## \tBUBBLE [COMPARACOES] [" + comparacao + "] [MOVIMENTACOES] [" + movimentacao + "]");
   }

   /**
    * Troca o conteudo de duas posicoes do ArrayList
    */
   public void swap(ArrayList<Jogo> lista, int i, int j) {
      Jogo temp = lista.get(i);
      lista.set(i, lista.get(j));
      lista.set(j, temp);
   }

   /*
    * Nomedojogo(crescente);
    * Plataforma (crescente)- só é usado se os nomes forem idênticos;
    * Vendasglobal (decrescente)- só é usado se nome e plataforma forem idênticos.
    */
   public boolean maior(Jogo jogo1, Jogo jogo2) {
      boolean eMaior = false;
      
      if (jogo1.getNome_jogo().compareToIgnoreCase(jogo2.getNome_jogo()) > 0) {
         if (jogo1.getPlataforma().compareToIgnoreCase(jogo2.getPlataforma()) > 0) {
            if ((jogo1.getVendas_Global() == jogo2.getVendas_Global()) < 0) {
               eMaior = true;
            }
         }
      }
      return eMaior;
   }
}