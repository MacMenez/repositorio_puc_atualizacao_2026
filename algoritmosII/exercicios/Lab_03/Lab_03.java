public class Lab_03 {
  public static void main(String[] args) {
    // Lê a quantidade de jogos
    int total_jogos = Integer.parseInt(MyIO.readLine());

    // Parte 1: Armazenamento de informações em vetor
    Jogo[] vetor_nao_ordem = new Jogo[total_jogos]; // Cria o vetor com tamanho fixo
    Jogo[] vetor_ordem = new Jogo[total_jogos]; // Cria o vetor com tamanho fixo

    int indice_vetor = 0; // Índice para preencher o vetor

    String linha_lida = MyIO.readLine();

    // Ler o vetor desordenado
    while (!linha_lida.equals("FIM")) {
      vetor_nao_ordem[indice_vetor] = new Jogo();
      vetor_nao_ordem[indice_vetor].ler(linha_lida);
      indice_vetor++;
      linha_lida = MyIO.readLine();
      // vetor_nao_ordem[indice_vetor].imprimir(); // Teste
    }
    linha_lida = MyIO.readLine(); // Exclui o fim

    // MyIO.println(linha_lida);
    // // Ler o vetor ordenado
    indice_vetor = 0;
    while (!linha_lida.equals("FIM")) {
      vetor_ordem[indice_vetor] = new Jogo();
      vetor_ordem[indice_vetor].ler(linha_lida);
      indice_vetor++;
      linha_lida = MyIO.readLine();
      // vetor_ordem[indice_vetor].imprimir(); // Teste
    }

    // // parte 2: Pesquisa de informações armazenadas no vetor criado na parte 1
    
    indice_vetor = 0;
    linha_lida = MyIO.readLine();
    while(!linha_lida.equals("FIM")){
      pesquisaSequencial(vetor_nao_ordem, linha_lida);
      pesquisaBinaria(vetor_ordem, linha_lida);
      indice_vetor++;
      linha_lida = MyIO.readLine();
    //  MyIO.println(linha_lida);
     // MyIO.println("TESTE");
    }
    
    
  }

    private static void pesquisaSequencial(Jogo[] vetor_nao_ordem, String chave) {
      int sequencial = 0;
      for (int i = 0; i < vetor_nao_ordem.length; i++) {
        sequencial++;
        if (vetor_nao_ordem[i].getNome_jogo().equals(chave)) {
            //Imprimir
            vetor_nao_ordem[i].imprimir();
            MyIO.print("Sequencial: " + sequencial);
            i = vetor_nao_ordem.length;
        }
      }
    }

    private static void pesquisaBinaria(Jogo[] vetor_ordem, String chave) {
      int binaria = 0, esquerda = 0, direita = vetor_ordem.length - 1, meio;
      while (esquerda <= direita) {
        meio = (esquerda + direita)/2;
        String nome = vetor_ordem[meio].getNome_jogo();

        binaria++;
        if (nome.equals(chave)) {
          MyIO.print(", binaria: " + binaria + "\n");
          esquerda = vetor_ordem.length;
        }else if (chave.compareToIgnoreCase(nome) < 0) {/* chave é menor */
            direita = meio -1;
        } else {/* Palavra é maior */
            esquerda = meio + 1;
        }
      }
    }
}