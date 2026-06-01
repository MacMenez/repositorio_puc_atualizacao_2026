import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EntregarDinamica {
   public static void main(String[] args) {
        ArquivoTextoLeitura arquivo_jogos = new ArquivoTextoLeitura("tmp/jogos.txt");

        // Parte 1: Armazenamento de informações contidos no arquivo jogos.txt em vetor
        Jogo[] vetor_jogo = new Jogo[1500];
        int contador = 0;

        String linha;
        try {
            while ((linha = arquivo_jogos.ler()) != null && !linha.isEmpty()) {
                Jogo jogo = new Jogo();
                jogo.ler(linha);
                vetor_jogo[contador] = jogo;
                //System.out.println("Jogo " + contador + ": " + jogo.toString());
                contador++;
                // Processar a linha e criar um objeto Jogo
                // vetor_jogo[contador] = jogo;
                // contador++;
            }
        } catch (Exception e) {
            System.out.println("Leitura de Arquivo com Problema! Erro: " + e.getMessage());
        } finally {
            arquivo_jogos.fecharArquivo();
        }

      Fila filaJogos = new Fila();
      int qtdEncontrados = 0;

      String entradaUsuario = MyIO.readLine();
      while (!entradaUsuario.equals("FIM")) {
         String[] campos = entradaUsuario.split(";");
         String nomeJogo = campos[0];
         int anoJogo = Integer.parseInt(campos[1]);
         String editoraJogo = campos[2];
         String plataforma = campos[3];

         for (int i = 0; i < contador; i++) {
            if (vetor_jogo[i].getNome_jogo().equals(nomeJogo) &&
                  vetor_jogo[i].getAno() == anoJogo &&
                  vetor_jogo[i].getEditora().equals(editoraJogo) &&
                  vetor_jogo[i].getPlataforma().equals(plataforma)) {
               qtdEncontrados++;
               try {
                  filaJogos.enfileirar(vetor_jogo[i]);
               } catch (Exception e) {
                  System.out.println(e.getMessage());
               }
               System.out.println(filaJogos.obterSomaVendasGlobal());
               break;
            }
         }
      }

      System.out.println("Quantidade de jogos encontrados: " + qtdEncontrados);
      System.out.println("Tamanho da fila: " + filaJogos.size());

      int qtdOperacoes = Integer.parseInt(MyIO.readLine().trim());

      for (int i = 0; i < qtdOperacoes; i++) {
         String comando = MyIO.readLine().trim();

         if (comando.startsWith("E")) {
            String infoComando = comando.substring(2);
            String[] campos = infoComando.split(";");
            String nomeJogo = campos[0];
            int anoJogo = Integer.parseInt(campos[1]);
            String editoraJogo = campos[2];
            String plataforma = campos[3];

            for (int j = 0; j < contador; j++) {
               if (vetor_jogo[j].getNome_jogo().equals(nomeJogo) &&
                     vetor_jogo[j].getAno() == anoJogo &&
                     vetor_jogo[j].getEditora().equals(editoraJogo) &&
                     vetor_jogo[j].getPlataforma().equals(plataforma)) {
                  try {
                     filaJogos.enfileirar(vetor_jogo[j]);
                  } catch (Exception e) {
                     System.out.println(e.getMessage());
                  }
                  System.out.println(filaJogos.obterSomaVendasGlobal());
                  break;
               }
            }
         } else {
            try {
               Jogo jogoRemovido = filaJogos.desenfileirar();
               System.out.println("(D) " + jogoRemovido.toString());
            } catch (Exception e) {
               System.out.println(e.getMessage());
            }
         }
      }

      filaJogos.mostrar();
   }

   class Celula {
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

   class Fila {
      private Celula primeiro, ultimo;
      private double somaVendasGlobal;
      private int tamanho;

      public Fila() {
         primeiro = new Celula();
         ultimo = primeiro;
         somaVendasGlobal = 0;
         tamanho = 0;
      }

      public void mostrar() {
         Celula i = primeiro.prox;
         int pos = 1;
         while (i != null) {
            System.out.println("[" + pos + "] " + i.elemento.toString());
            i = i.prox;
            pos++;
         }
      }

      public void enfileirar(Jogo jogo) throws Exception {
         ultimo.prox = new Celula(jogo.clone());
         ultimo = ultimo.prox;
         somaVendasGlobal += jogo.getVendas_Global();
         tamanho++;
      }

      public Jogo desenfileirar() throws Exception {
         if (primeiro == ultimo) {
            throw new Exception("Erro: fila vazia");
         }
         Celula tmp = primeiro.prox;
         primeiro.prox = primeiro.prox.prox;
         Jogo elemento = tmp.elemento;
         tmp.prox = null;
         tmp = null;
         if (primeiro.prox == null)
            ultimo = primeiro;
         somaVendasGlobal -= elemento.getVendas_Global();
         tamanho--;
         return elemento;
      }

      public double obterSomaVendasGlobal() {
         return (int) Math.round(somaVendasGlobal);
      }

      public int size() {
         return tamanho;
      }

   }

   class Jogo {
      private int rank;
      private String nome_jogo;
      private String plataforma;
      private int ano;
      private String genero;
      private String editora;
      private double NA_Vendas;
      private double EU_Vendas;
      private double JP_Vendas;
      private double Outras_Vendas;
      private double Vendas_Global;

      public Jogo() {
      }

      private Jogo(String nome_jogo, String plataforma, int ano) {
         this.nome_jogo = nome_jogo;
         this.plataforma = plataforma;
         this.ano = ano;
      }

      public int getRank() {
         return rank;
      }

      public void setRank(int rank) {
         this.rank = rank;
      }

      public String getNome_jogo() {
         return nome_jogo;
      }

      public void setNome_jogo(String nome_jogo) {
         this.nome_jogo = nome_jogo;
      }

      public String getPlataforma() {
         return plataforma;
      }

      public void setPlataforma(String plataforma) {
         this.plataforma = plataforma;
      }

      public int getAno() {
         return ano;
      }

      public void setAno(int ano) {
         this.ano = ano;
      }

      public String getGenero() {
         return genero;
      }

      public void setGenero(String genero) {
         this.genero = genero;
      }

      public String getEditora() {
         return editora;
      }

      public void setEditora(String editora) {
         this.editora = editora;
      }

      public double getNA_Vendas() {
         return NA_Vendas;
      }

      public void setNA_Vendas(double nA_Vendas) {
         NA_Vendas = nA_Vendas;
      }

      public double getEU_Vendas() {
         return EU_Vendas;
      }

      public void setEU_Vendas(double eU_Vendas) {
         EU_Vendas = eU_Vendas;
      }

      public double getJP_Vendas() {
         return JP_Vendas;
      }

      public void setJP_Vendas(double jP_Vendas) {
         JP_Vendas = jP_Vendas;
      }

      public double getOutras_Vendas() {
         return Outras_Vendas;
      }

      public void setOutras_Vendas(double outras_Vendas) {
         Outras_Vendas = outras_Vendas;
      }

      public double getVendas_Global() {
         return Vendas_Global;
      }

      public void setVendas_Global(double vendas_Global) {
         Vendas_Global = vendas_Global;
      }

      public Jogo clone() {
         Jogo clone_jogo = new Jogo();

         clone_jogo.rank = rank;
         clone_jogo.nome_jogo = nome_jogo;
         clone_jogo.plataforma = plataforma;
         clone_jogo.ano = ano;
         clone_jogo.genero = genero;
         clone_jogo.editora = editora;
         clone_jogo.NA_Vendas = NA_Vendas;
         clone_jogo.EU_Vendas = EU_Vendas;
         clone_jogo.JP_Vendas = JP_Vendas;
         clone_jogo.Outras_Vendas = Outras_Vendas;
         clone_jogo.Vendas_Global = Vendas_Global;

         return clone_jogo;
      }

      public ArrayList<Jogo> clone(ArrayList<Jogo> lista_encontrados) {
         ArrayList<Jogo> lista_clone = new ArrayList<>();

         for (int i = 0; i < lista_encontrados.size(); i++) {
            Jogo clone_jogo = new Jogo();
            clone_jogo.rank = lista_encontrados.get(i).rank;
            clone_jogo.nome_jogo = lista_encontrados.get(i).nome_jogo;
            clone_jogo.plataforma = lista_encontrados.get(i).plataforma;
            clone_jogo.ano = lista_encontrados.get(i).ano;
            clone_jogo.genero = lista_encontrados.get(i).genero;
            clone_jogo.editora = lista_encontrados.get(i).editora;
            clone_jogo.NA_Vendas = lista_encontrados.get(i).NA_Vendas;
            clone_jogo.EU_Vendas = lista_encontrados.get(i).EU_Vendas;
            clone_jogo.JP_Vendas = lista_encontrados.get(i).JP_Vendas;
            clone_jogo.Outras_Vendas = lista_encontrados.get(i).Outras_Vendas;
            clone_jogo.Vendas_Global = lista_encontrados.get(i).Vendas_Global;

            lista_clone.add(clone_jogo);
         }
         return lista_clone;
      }

      public void ler(String valor_lido) {
         String[] atributo = valor_lido.split("\\|");

         this.rank = Integer.parseInt(atributo[0]);
         this.nome_jogo = atributo[1];
         this.plataforma = atributo[2];
         this.ano = Integer.parseInt(atributo[3]);
         this.genero = atributo[4];
         this.editora = atributo[5];
         this.NA_Vendas = Double.parseDouble(atributo[6]);
         this.EU_Vendas = Double.parseDouble(atributo[7]);
         this.JP_Vendas = Double.parseDouble(atributo[8]);
         this.Outras_Vendas = Double.parseDouble(atributo[9]);
         this.Vendas_Global = Double.parseDouble(atributo[10]);
      }

      public void listar(ArrayList<Jogo> vetor_jogo) {
         for (int i = 0; i < vetor_jogo.size(); i++) {
            vetor_jogo.get(i).imprimir();
         }
      }

      public void imprimir() {
         MyIO.println(toString());
      }

      @Override
      public String toString() {
         return "[" + nome_jogo + "] [" + plataforma + "] [" + Vendas_Global + "] " + rank + ". " + genero + ". "
               + editora
               + ". Mais vendido: " + Vendas_Global + ".";
      }
   }

class ArquivoTextoLeitura {

   private BufferedReader entrada;

   ArquivoTextoLeitura(String nomeArquivo) {

      try {
         entrada = new BufferedReader(new FileReader(nomeArquivo));
      } catch (FileNotFoundException excecao) {
         System.out.println("Arquivo nao encontrado");
      }
   }

   public void fecharArquivo() {

      try {
         entrada.close();
      } catch (IOException excecao) {
         System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
      }
   }

   @SuppressWarnings("finally")
   public String ler() {

      String textoEntrada = null;

      try {
         textoEntrada = entrada.readLine();
      } catch (EOFException excecao) { // Excecao de final de arquivo.
         textoEntrada = null;
      } catch (IOException excecao) {
         System.out.println("Erro de leitura: " + excecao);
         textoEntrada = null;
      } finally {
         return textoEntrada;
      }
   }
}
