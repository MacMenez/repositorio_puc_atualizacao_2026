public class Lab_07 {

    public static void main(String[] args) {
        ArquivoTextoLeitura arquivo = new ArquivoTextoLeitura("jogos.txt");
        // ArquivoTextoLeitura arquivo = new ArquivoTextoLeitura("/tmp/jogos.txt");

        // Parte 1: Leitura de um arquivo-texto e preenchimento de um vetor de jogos.
        Jogo[] vetor_jogo = new Jogo[1500];
        int i = 0;

        String valor_lido = arquivo.ler();

        while (valor_lido != null) {
            Jogo jogo = new Jogo();
            jogo.ler(valor_lido);
            vetor_jogo[i] = jogo;
            i++;
            valor_lido = arquivo.ler();
        }

        arquivo.fecharArquivo();

        // Parte 2: Pesquisa de jogos armazenados no vetor com inclusão de jogos selecionados na árvore.
        ABB arvoreABB = new ABB();

        valor_lido = MyIO.readLine();

        while (!valor_lido.equals("FIM")) {
            String[] atributo = valor_lido.split(";");
            String nome_jogo = atributo[0];
            int ano = Integer.parseInt(atributo[1]);
            String editora = atributo[2];
            String plataforma = atributo[3];

            for (int j = 0; j < vetor_jogo.length; j++) {
                if (vetor_jogo[j] != null && vetor_jogo[j].getNome_jogo().equals(nome_jogo) &&
		            vetor_jogo[j].getAno() == ano &&
		            vetor_jogo[j].getEditora().equals(editora) &&
		            vetor_jogo[j].getPlataforma().equals(plataforma)) {
		            try {
		                arvoreABB.inserir(vetor_jogo[j]);
		            } catch (Exception e) {
		                System.out.println(e.getMessage());
		            }
		            break;
		        }
            }

            valor_lido = MyIO.readLine(); // Ler a próxima linha de entrada
        }

        // Parte 3: Pesquisa de informações na árvore
        valor_lido = MyIO.readLine(); // Leitura da 2° parte da entrada

        int jogos_encontrados = 0;
        int jogos_Nencontrados = 0;

        while (!valor_lido.equals("FIM")) {
            String[] atributo = valor_lido.split(";");
            String nome_jogo = atributo[0];
            int ano = Integer.parseInt(atributo[1]);
            String editora = atributo[2];
            String plataforma = atributo[3];

            arvoreABB.buscar(nome_jogo, jogos_encontrados, jogos_Nencontrados);

            valor_lido = MyIO.readLine(); // Ler a próxima linha de entrada
        }

        MyIO.println("Jogos Encontrados: " + jogos_encontrados + "\nJogos Não Encontrados: " + jogos_Nencontrados);
    }
}