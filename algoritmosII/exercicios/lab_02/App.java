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
        Jogo[] vetor_jogo = new Jogo[]; /*Criação do vetor de jogo onde cada indice é nulo e deve receber o endereço de 1 jogo
        jogo[i] = new Jogo(); //Armazenando um jogo no indice i (jogo que acabou de ser instanciado)

        int[] x = new int[10]; 
        int d = 10;
        */

        // Parte 1: Armazenamento de informações em vetor
        Jogo[] vetor_jogo = new Jogo[Integer.parseInt(linha_lida)];
        int indice = 0;
        while (!linha_lida.equals("FIM")) {
            vetor_jogo[indice] = new Jogo();
            vetor_jogo[indice].ler(linha_lida);
            indice++;
        }

        // Parte 2: Pesquisa de informações armazenadas no vetor criado na parte 1
        Jogo[] exibidos = new Jogo[indice];
        String[] dados_busca = new String[2];

        buscarJogo(vetor_jogo, dados_busca[0], dados_busca[1], dados_busca[2]);
        
        jaFoiExibido(nome);

        /*
            ler consulta
            jogo = buscarJogo(...)

            se jogo existe:
                se nao foi exibido:
                    imprimir
                    registrar exibicao
         */
    }

    private static void buscarJogo(Jogo[] vetor_jogo, String nome_procurado, String ano_procurado, String editora_procurada) {
        // TODO Auto-generated method stub
        for(int i = 0; int = vetor_jogo.length; i++;){
            if(
                (vetor_jogo[i].getNome_jogo().equals(nome_procurado)) &
                (vetor_jogo[i].getAno() == Integer.parseInt(ano_procurado)) &
                (vetor_jogo[i].getEditora().equals(editora_procurada))
            ){
                vetor_jogo.toString();
                i = vetor_jogo.length;
            }
        }
    }
}
