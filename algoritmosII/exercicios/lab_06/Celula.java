public class Celula {
   public Jogo elemento;
   public Celula prox;

   public Celula() {
      this.elemento = null;
      this.prox = null;
   }

   public Celula(Jogo elemento) {
      this.elemento = elemento;
      this.prox = null;
   }
}
