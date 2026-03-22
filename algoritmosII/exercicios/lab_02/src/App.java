/*
    // Teste de Entrada e Saída
    String linha_lida = MyIO.readLine();
    Jogo criar_jogo = new Jogo();
    criar_jogo.ler(linha_lida);
    criar_jogo.imprimir();

    //EXPLICAÇÃO
    Jogo[] vetor_jogo = new Jogo[]; //Criação do vetor de jogo onde cadaindice é nulo e deve receber o endereço de 1 jogo
    jogo[i] = new Jogo(); //Armazenando um jogo no indice i (jogo queacabou de ser instanciado)

    int[] x = new int[10]; 
    int d = 10;

    // ler consulta
    // jogo = buscarJogo(...)

    // se jogo existe:
    //     se nao foi exibido:
    //         imprimir
    //         registrar exibicao
    
*/
public class App {
    public static void main(String[] args) throws Exception {
        /* ============================
           PARTE 1 - LEITURA DOS JOGOS
           ============================ 
        */
        
        // Lê a quantidade de jogos
        int total_jogos = Integer.parseInt(MyIO.readLine());

        // Parte 1: Armazenamento de informações em vetor
        Jogo[] vetor_jogo = new Jogo[total_jogos]; // Cria o vetor com tamanho fixo
        Jogo dados_jogo = new Jogo(); // Objeto auxiliar para ler e imprimir jogos
        int indice_vetor = 0; // Índice para preencher o vetor

        String linha_lida; // Variável para armazenar a linha lida

        while (!(linha_lida = MyIO.readLine()).equals("FIM")) {
            dados_jogo.ler(linha_lida); // Preenche os atributos do jogo com a linha lida
            
            // dados_jogo.imprimir(); // Imprime o jogo lido (usar para teste)

            vetor_jogo[indice_vetor] = dados_jogo.clone(); // Armazena o jogo no vetor
            // vetor_jogo[indice_vetor].imprimir(); // Imprime o jogo armazenado no vetor (usar para teste)
            
            indice_vetor++; // Incrementa o índice para o próximo jogo
        }
        
        // System.out.println("==============================");

        /* ======================================
           PARTE 2 - PESQUISA E CONTROLE DE SAÍDA
           ======================================
        */

        // Vetor para controlar jogos já exibidos
        String[] exibidos = new String[total_jogos];
        int indice_exibidos = 0; // Índice para controlar quantos jogos já foram exibidos

        // Lê consultas até "FIM"
        while (!(linha_lida = MyIO.readLine()).equals("FIM")) {
            String[] dados_informados = linha_lida.split(";");

            String nome_pesquisa = dados_informados[0];
            int ano_pesquisa = Integer.parseInt(dados_informados[1]);
            String editora_pesquisa = dados_informados[2];

            // Busca o jogo no vetor
            Jogo jogoEncontrado = buscarJogo(vetor_jogo, nome_pesquisa, ano_pesquisa, editora_pesquisa);

            // Se encontrou o jogo
            if (jogoEncontrado != null) {
                // Gera uma "chave única" do jogo

                String chave = nome_pesquisa + ";" + ano_pesquisa + ";" + editora_pesquisa;

                // Verifica se já foi exibido
                if (!jaFoiExibido(exibidos, chave)) {
                    // Imprime no formato pedido
                    jogoEncontrado.imprimir();

                    // Marca como exibido
                    exibidos[indice_exibidos] = chave;
                    indice_exibidos++;
                }
            }
        }
    }

    /*
        ======================================
        MÉTODO DE BUSCA
        ======================================
        3077;Wario: Master of Disguise;DS;2007;Platform;Nintendo;0.28;0.02;0.33;0.03;0.66

        12352;Pro Yaky? Spirits 2013;PSV;2013;Sports;Konami Digital Entertainment;0;0;0.06;0;0.06

        4913;Thrasher Presents: Skate and Destroy;PS;1998;Sports;Take-Two Interactive;0.22;0.15;0;0.03;0.39
    */
    private static Jogo buscarJogo(Jogo[] vetor_jogo, String nome, int ano, String editora) {
        Jogo jogoEncontrado = null;

        for (int i = 0; i < vetor_jogo.length; i++) {
            if (vetor_jogo[i] != null && 
                vetor_jogo[i].getNome_jogo().equals(nome) && 
                vetor_jogo[i].getAno() == ano && 
                vetor_jogo[i].getEditora().equals(editora)) {
                jogoEncontrado = vetor_jogo[i];
                i = vetor_jogo.length; // Encerra o loop após encontrar o jogo
            }
        }

        return jogoEncontrado;
    }

    /*
        ======================================
        MÉTODO DE CONTROLE DE EXIBIÇÃO
        ======================================
    */
    private static boolean jaFoiExibido(String[] exibidos, String chave) {
        boolean encontrado = false;
        for (int i = 0; i < exibidos.length; i++) {
            if (exibidos[i] != null && exibidos[i].equals(chave)) {
                encontrado = true;
                i = exibidos.length; // Encerra o loop
            }
        }
        return encontrado;
    }
}
