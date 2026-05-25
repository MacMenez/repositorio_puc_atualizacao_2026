import java.util.ArrayList;

/**
 * Metodo de ordenacao da bolha
 */
class Bolha {

   /**
    * Algoritmo de ordenacao Bolha.
    */

   private int comparacao;
   private int movimentacao;
   private ArrayList<Jogo> lista_jogos;
      

   public ArrayList<Jogo> getLista_jogos() {
      return lista_jogos;
   }

   public void setLista_jogos(ArrayList<Jogo> lista_jogos) {
      this.lista_jogos = lista_jogos;
   }

   public Bolha(ArrayList<Jogo> lista_jogos) {
      this.comparacao = 0;
      this.movimentacao = 0;
      this.lista_jogos = lista_jogos;
   }

   public int getComparacao() { return comparacao; }

   public void setComparacao(int comparacao) { this.comparacao = comparacao; }

   public int getMovimentacao() { return movimentacao; }

   public void setMovimentacao(int movimentacao) { this.movimentacao = movimentacao; }

   public void sort() {
      comparacao = 0;
      movimentacao = 0;

      for (int i = lista_jogos.size() - 1; i > 0; i--) {
         for (int j = 0; j < i; j++) {

            comparacao++;
            if (maior(lista_jogos.get(j), lista_jogos.get(j + 1))) {
               swap(lista_jogos, j, j + 1);
               movimentacao += 3;
            }
         }
      }
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
         comparacao++;
         eMaior =true;
      }
      else if (jogo1.getNome_jogo().compareToIgnoreCase(jogo2.getNome_jogo()) == 0) {
         if ((jogo1.getPlataforma().compareToIgnoreCase(jogo2.getPlataforma())) > 0) {
            comparacao += 3;
            eMaior = true;
         }
         else if ((jogo1.getPlataforma().compareToIgnoreCase(jogo2.getPlataforma())) == 0) {
            if ((jogo1.getVendas_Global() < jogo2.getVendas_Global())) {
               comparacao += 5;
               eMaior = true;
            } else { comparacao += 5; }
         } else { comparacao += 4; }
      } else { comparacao++; }

      return eMaior;
   }
}