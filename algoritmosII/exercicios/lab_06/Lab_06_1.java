public class Lab_06_1 {
    public static void main(String[] args) {
        ArquivoTextoLeitura arquivo_jogos = new ArquivoTextoLeitura("jogos.txt");
        // ArquivoTextoLeitura arquivo_jogos = new ArquivoTextoLeitura("tmp/jogos.txt");

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

        /* Exercício Parte 1: Fila Estática */
        // Parte 2: Pesquisa de informações armazenadas no vetor criado na Parte 1.
        FilaCircular fila_jogos = new FilaCircular();
        int jogos_encontrados = 0;

        while (!(linha = MyIO.readLine()).equals("FIM")) {

            String[] dados = linha.split(";");
		    String nome = dados[0];
		    int ano = Integer.parseInt(dados[1]);
		    String editora = dados[2];
		    String plataforma = dados[3];

		    for (int i = 0; i < contador; i++) {
		        if (vetor_jogo[i].getNome_jogo().equals(nome) &&
		            vetor_jogo[i].getAno() == ano &&
		            vetor_jogo[i].getEditora().equals(editora) &&
		            vetor_jogo[i].getPlataforma().equals(plataforma)) {
		            jogos_encontrados++;
		            try {
		                fila_jogos.enfileirar(vetor_jogo[i]);
		            } catch (Exception e) {
		                System.out.println(e.getMessage());
		            }
		            System.out.println(fila_jogos.obterSomaVendasGlobal());
		            break;
		        }
		    }
        }
        System.out.println("Quantidade de jogos encontrados: " + jogos_encontrados);
        System.out.println("Tamanho da fila: " + fila_jogos.size());

        // Parte 3: Enfileiramentos e desenfileiramentos na fila criada na Parte 2.
        int quantidade_operacoes = MyIO.readInt(); // quantidade de jogos que serão enfileirados ou desenfileirados

        /*
         * Cada uma dessas linhas tem uma palavra de comando, conforme descrito a
         * seguir:
         * • E: enfileirar;
         * • D: desenfileirar
         */
        for (int i = 0; i < quantidade_operacoes; i++) {
            String comando = MyIO.readLine();
            if (comando.equals("E")) {
                String[] dados = linha.split(";");
                String nome = dados[0];
                int ano = Integer.parseInt(dados[1]);
                String editora = dados[2];
                String plataforma = dados[3];

                for (int j = 0; j < contador; j++) {
                    if (vetor_jogo[j].getNome_jogo().equals(nome) &&
                        vetor_jogo[j].getAno() == ano &&
                        vetor_jogo[j].getEditora().equals(editora) &&
                        vetor_jogo[j].getPlataforma().equals(plataforma)) {
                        jogos_encontrados++;
                        try {
                            fila_jogos.enfileirar(vetor_jogo[j]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println((int) Math.round(fila_jogos.obterSomaVendasGlobal()));
                        break;
		            }
		        }
            } else{
                try {
		            Jogo jogo = fila_jogos.desenfileirar();
		            System.out.println("(D) " + jogo.toString());
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        } 
            }
        }
        fila_jogos.mostrar();
    }
}