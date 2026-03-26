
public class Lab_03 {
  public static void main(String[] args) {
    // Lê a quantidade de jogos
    int total_jogos = Integer.parseInt(MyIO.readLine());

    // Parte 1: Armazenamento de informações em vetor
    Jogo[] vetor_nao_ordem = new Jogo[total_jogos]; // Cria o vetor com tamanho fixo
    Jogo[] vetor_ordem = new Jogo[total_jogos]; // Cria o vetor com tamanho fixo

    Jogo dados_jogo = new Jogo(); // Objeto auxiliar para ler e imprimir jogos
    int indice_vetor = 0; // Índice para preencher o vetor

    String linha_lida;

    // Ler o vetor desordenado
    while (!(linha_lida = MyIO.readLine()).equals("FIM")) {
      dados_jogo.ler(linha_lida);
      vetor_nao_ordem[indice_vetor] = dados_jogo.clone();
      vetor_nao_ordem[indice_vetor].imprimir(); // Teste
    }

    // Ler o vetor ordenado
    while (!(linha_lida = MyIO.readLine(linha_lida)).equals("FIM")) {
      dados_jogo.ler(linha_lida);
      vetor_ordem[indice_vetor] = dados_jogo.clone();
      vetor_ordem[indice_vetor].imprimir(); // Teste
    }

    // parte 2: Pesquisa de informações armazenadas no vetor criado na parte 1
    linha_lida = MyIO.readLine();

    vetor_nao_ordem[indice_vetor].imprimir() + "Sequencial: " + pesquisaSequencial(vetor_nao_ordem, linha_lida)  + ", binaria: " + pesquisaBinaria(vetor_ordem, linha_lida) + "\n";
    
    MyIO.readLine(); // MUITO IMPORTANTE
  }

    private static int pesquisaSequencial(Jogo[] vetor_nao_ordem, String linha_lida) {
      int sequencial = 0;
      return sequencial;
    }

    private static int pesquisaBinaria(Jogo[] vetor_ordem, String linha_lida) {
      int binaria = 0;
      return binaria;
    }
  
}
