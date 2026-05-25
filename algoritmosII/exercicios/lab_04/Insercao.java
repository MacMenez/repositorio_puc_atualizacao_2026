import java.util.ArrayList;

class Insercao {

   /**
    * Algoritmo de ordenacao por insercao.
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

   public Insercao(ArrayList<Jogo> lista_jogos) {
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

      for (int i = 1; i < lista_jogos.size(); i++) {
         Jogo tmp = lista_jogos.get(i);
         movimentacao++;

         int j = i - 1;

         while (j >= 0 && maior(tmp, lista_jogos.get(j))) {
            lista_jogos.set(j + 1, lista_jogos.get(j));
            movimentacao++;
            j--;
         }

         lista_jogos.set(j + 1, tmp);
         movimentacao++;
      }
   }

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