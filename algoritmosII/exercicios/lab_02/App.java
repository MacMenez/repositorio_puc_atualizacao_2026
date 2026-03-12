public class App {
    public static void main(String[] args) {
        /*1° linha ler o tamanho do vetor */
        String linha_lida = MyIO.readLine();
        
        /*
        // Teste de Entrada e Saída
        Jogo criar_jogo = new Jogo();
        criar_jogo.ler(linha_lida);
        criar_jogo.imprimir();

        EXPLICAÇÃO
        Jogo[] armazena_jogo = new Jogo[]; /*Criação do vetor de jogo onde cada indice é nulo e deve receber o endereço de 1 jogo
        jogo[i] = new Jogo(); //Armazenando um jogo no indice i (jogo que acabou de ser instanciado)

        int[] x = new int[10]; 
        int d = 10;
        */

        // Parte 1: Armazenamento de informações em vetor
        Jogo[] armazena_jogo = new Jogo[Integer.parseInt(linha_lida)];
        int indice = 0;
        while (!linha_lida.equals("FIM")) {
            armazena_jogo[indice] = new Jogo();
            armazena_jogo[indice].ler(linha_lida);
            linha_lida = MyIO.readLine();
        }
        // Parte 2: Pesquisa de informações armazenadas no vetor criado na parte 1
        String[] vetor_duplicados = new String[999]; /* Vetor para armazenar valores duplicados */

        linha_lida = MyIO.readLine();
        while(!linha_lida.equals("FIM")){
            
            /*  Verificar se o nome do jogo lido já foi exibido (compara com a posição do vetor)
                se não, armazena no vetor inserindo o toString, incrementa para próxima posição e retorna o vetor preenchido
                se nome já foi exibido, o nome está no vetor, vai ignorar a inserção, não faz nada
                por fim, pega o vetor de objetos e 
            */
            linha_lida = MyIO.readLine();
        }
    }
    public String[] excluirDuplicado(String linha_lida){

    }
}

