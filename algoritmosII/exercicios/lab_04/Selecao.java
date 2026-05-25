import java.util.ArrayList;

class Selecao {

   /**
    * Algoritmo de ordenacao por selecao.
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

   public Selecao(ArrayList<Jogo> lista_jogos) {
      this.comparacao = 0;
      this.movimentacao = 0;
      this.lista_jogos = lista_jogos;
   }

   public void sort() {
      comparacao = 0;
      movimentacao = 0;

      for (int i = 0; i < lista_jogos.size() - 1; i++) {
         int menor = i;

         for (int j = i + 1; j < lista_jogos.size(); j++) {
            comparacao++;
            if (maior(lista_jogos.get(menor), lista_jogos.get(j))) {
               menor = j;
            }
         }

         if (menor != i) {
            swap(lista_jogos, menor, i);
            movimentacao += 3;
         }
      }

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