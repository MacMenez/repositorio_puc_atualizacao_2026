import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Entregar {

    public static void main(String[] args) {

        /* Parte 1 (Leitura de Arquivo): Armazenamento de informações contidos no arquivo jogos.txt em vetor */
        // ArquivoTextoLeitura dados_jogos = new ArquivoTextoLeitura("C:\\Users\\1229176\\Downloads\\lab_04\\jogos.txt"); // Comentar para enviar
        // ArquivoTextoLeitura dados_jogos = new ArquivoTextoLeitura("jogos.txt"); // Comentar para enviar
        ArquivoTextoLeitura dados_jogos = new ArquivoTextoLeitura("/tmp/jogos.txt"); // Descomentar para enviar

        ArrayList<Jogo> lista_jogos = new ArrayList<>();
        String linha;

        while ((linha = dados_jogos.ler()) != null) {
            Jogo jogo = new Jogo();
            jogo.ler(linha);
            lista_jogos.add(jogo);
            // jogo.imprimir(); // MUITO IMORTANTE: TESTAR DADO LIDO DO ARQUIVO
        }
        
        /* Parte 2: Pesquisa de informações armazenadas no vetor (ArrayList) criado na parte 1. */

        /* Processar a entrada contida no arquivo pub.in */
        ArrayList<Jogo> lista_encontrados = new ArrayList<>();
        int jogos_encontrados = 0;

        for (int i = 0; !(linha = MyIO.readLine()).equals("FIM"); i++) {
            /* CORRIGIR FUNÇÃO? */
            pesquisar(linha, lista_jogos,lista_encontrados, jogos_encontrados);
        }
        /* 
            Quantidade de jogos lidos na entrada padrão (arquivo pub.in), 
            que foram encontrados no arquivo jogos.txt 
        */
        MyIO.println("Quantidade de jogos encontrados: " + jogos_encontrados);

        /* Parte 3: Ordenação do vetor armazenado na Parte 2. */

        /* Criar 3 clones */
        ArrayList<Jogo> bubblesortJogo;
        ArrayList<Jogo> selectionsortJogo;
        ArrayList<Jogo> insertionsortJogo;

        Jogo jogo = new Jogo();
        bubblesortJogo = jogo.clone(lista_encontrados);
        selectionsortJogo= jogo.clone(lista_encontrados);
        insertionsortJogo = jogo.clone(lista_encontrados);

        Bolha bubble_sort = new Bolha(bubblesortJogo);
        bubble_sort.sort();
        
        for (int i = 0; i < bubble_sort.getLista_jogos().size(); i++) {
            bubble_sort.getLista_jogos().get(i).imprimir();
        }
        MyIO.println("## \tBUBBLE [COMPARACOES] [" + bubble_sort.getComparacao() + "] [MOVIMENTACOES] [" + bubble_sort.getMovimentacao() + "]");

        Insercao insertion_sort = new Insercao(insertionsortJogo);
        insertion_sort.sort();
        for (int i = 0; i < insertion_sort.getLista_jogos().size(); i++) {
            insertion_sort.getLista_jogos().get(i).imprimir();
        }
        MyIO.println("## INSERTION [COMPARACOES] [" + insertion_sort.getComparacao() + "] [MOVIMENTACOES] [" + insertion_sort.getComparacao() + "]");

        Selecao selection_sort = new Selecao(selectionsortJogo);
        selection_sort.sort();
        for (int i = 0; i < insertion_sort.getLista_jogos().size(); i++) {
            insertion_sort.getLista_jogos().get(i).imprimir();
        }
        // exibirOrdenacao(selection_sort);
    }

    public static ArrayList<Jogo> pesquisar(String linha, ArrayList<Jogo> lista_jogos, ArrayList<Jogo> lista_encontrados, int jogos_encontrados) {
        String dados_pesquisa[] = linha.split(";");

        String nome_jogo = dados_pesquisa[0];
        int ano = Integer.parseInt(dados_pesquisa[1]);
        String editora = dados_pesquisa[2];
        String plataforma = dados_pesquisa[3];

        for(int i = 0; i < lista_jogos.size(); i++) {
            if (
                lista_jogos.get(i).getNome_jogo().equals(nome_jogo) && 
                lista_jogos.get(i).getAno() == ano && 
                lista_jogos.get(i).getEditora().equals(editora) && 
                lista_jogos.get(i).getPlataforma().equals(plataforma)
            ) {
                lista_encontrados.add(lista_jogos.get(i).clone());
                jogos_encontrados++;
            }
        }
        
        // for (int index = 0; index < lista_jogos.size(); index++) {
        //     if (lista_jogos[i].equals("nome")) {
        //         return lista_jogos[i].clone();
        //     }
        // }
        return lista_encontrados;
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
      return "[" + nome_jogo + "] [" + plataforma + "] [" + Vendas_Global + "] " + rank + ". " + genero + ". " + editora + ". Mais vendido: " + Vendas_Global + ".";
   }
}

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
class ArquivoTextoLeitura {

	private BufferedReader entrada;
	
	ArquivoTextoLeitura(String nomeArquivo) {	
		
		try {
			entrada = new BufferedReader(new FileReader(nomeArquivo));
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo nao encontrado");
		}
	}
	
	public void fecharArquivo() {
		
		try {
			entrada.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	
		}
	}
	
	@SuppressWarnings("finally")
	public String ler() {
		
		String textoEntrada = null;
		
		try {
			textoEntrada = entrada.readLine();
		}
		catch (EOFException excecao) { //Excecao de final de arquivo.
			textoEntrada = null;
		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		}
		finally {
			return textoEntrada;
		}
	}
}