public class Lab_06_1 {
    public static void main(String[] args) {
        ArquivoTextoLeitura arquivo_jogos = new ArquivoTextoLeitura("jogos.txt");
        // ArquivoTextoLeitura arquivo_jogos = new ArquivoTextoLeitura("tmp/jogos.txt");
        String linha;

        // Parte 1: Armazenamento de informações contidos no arquivo jogos.txt em vetor
        Jogo[] vetor_jogo = new Jogo[1500];
        int contador = 0;
        try {
            while ((linha = arquivo_jogos.ler()) != null) {
                Jogo jogo = new Jogo();
                jogo.ler(linha);
                vetor_jogo[contador] = jogo;
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
        
        // Parte 2: Pesquisa de informações armazenadas no vetor criado na Parte 1.
        FilaCircular fila_jogos = new FilaCircular();
        int jogos_encontrados = 0;
        
        while(!(linha = MyIO.readLine()).equals("FIM")) {
            Jogo jogo_encontrado = pesquisa(linha, vetor_jogo);
            try {
                if (!fila_jogos.isFull()) {
                    try {
                        if (jogo_encontrado != null) {
                            fila_jogos.enfileirar(jogo_encontrado);
                            jogos_encontrados++;
                        } else {
                            System.out.println("Jogo não encontrado para a linha: " + linha);
                        }
                    } catch (Exception e) {
                        System.out.println("Inserção na Fila com Problema! Erro: " + e.getMessage());
                    }
                } else {
                    System.out.println("Fila cheia. Não é possível enfileirar mais jogos.");
                    
                    // Desenfileirar o 1° elemento da fila para abrir espaço para o próximo jogo encontrado
                    Jogo jogo_desenfileirado = fila_jogos.desenfileirar();
                    System.out.println("(D) " + jogo_desenfileirado.toString());

                    // Enfileirar o próximo jogo encontrado
                    fila_jogos.enfileirar(jogo_encontrado);
                    jogos_encontrados++;
                }
            } catch (Exception e) {
                System.out.println("Inserção na Fila com Problema! Erro: " + e.getMessage());
            }
        }
        System.out.println("Quantidade de jogos encontrados: " + jogos_encontrados);
        System.out.println("Tamanho da fila: " + fila_jogos.size());

        // Parte 3: Enfileiramentos e desenfileiramentos na fila criada na Parte 2.
        int quantidade_operacoes = MyIO.readInt(); // quantidade de jogos que serão enfileirados ou desenfileirados
        
        /*
            Cada uma dessas linhas tem uma palavra de comando, conforme descrito a seguir:
            • E: enfileirar;
            • D: desenfileirar
        */
        for (int i = 0; i < quantidade_operacoes; i++) {
            String comando = MyIO.readLine();
            if (comando.equals("E")) {
                try {
                    if (!fila_jogos.isFull()) {
                        Jogo jogo_desenfileirado = fila_jogos.desenfileirar();
                        System.out.println("(D) " + jogo_desenfileirado.toString());
                    } else {
                        System.out.println("Fila cheia. Não é possível enfileirar mais jogos.");
                    }
                } catch (Exception e) {
                    System.out.println("Enfileiramento com Problema! Erro: " + e.getMessage());
                }
            } else if (comando.equals("D")) {
                try {
                    if (!fila_jogos.isEmpty()) {
                        Jogo jogo_desenfileirado = fila_jogos.desenfileirar();
                        System.out.println("(D) " + jogo_desenfileirado.toString());
                    } else {
                        System.out.println("Fila vazia. Não é possível desenfileirar.");
                    }
                } catch (Exception e) {
                    System.out.println("Desenfileiramento com Problema! Erro: " + e.getMessage());
                }
            } else {
                System.out.println("Comando inválido: " + comando);
            }
        }
    }

    private static Jogo pesquisa(String linha, Jogo[] vetor_jogo) {
        Jogo jogo_encontrado = null;
        
        String dados_pesquisa[] = linha.split(";");
        String nome_pesquisa = dados_pesquisa[0];
        int ano_pesquisa = Integer.parseInt(dados_pesquisa[1]);
        String esditora_pesquisa = dados_pesquisa[2];
        String plataforma_pesquisa = dados_pesquisa[3];

        for (int i = 0; (!(jogo_encontrado == null)) && (i < vetor_jogo.length); i++) {
            if (vetor_jogo[i] != null) {
                if (vetor_jogo[i].getNome_jogo().equals(nome_pesquisa) &&
                    vetor_jogo[i].getAno() == ano_pesquisa &&
                    vetor_jogo[i].getEditora().equals(esditora_pesquisa) &&
                    vetor_jogo[i].getPlataforma().equals(plataforma_pesquisa)) {
                    jogo_encontrado = vetor_jogo[i];
                }
            }
        }
        return jogo_encontrado;
    }
}