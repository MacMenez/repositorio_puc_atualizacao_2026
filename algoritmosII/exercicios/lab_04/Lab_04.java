import java.lang.reflect.Array;
import java.util.ArrayList;

public class Lab_04 {

    public static void main(String[] args) {

        /* Parte 1 (Leitura de Arquivo): Armazenamento de informações contidos no arquivo jogos.txt em vetor */
        // ArquivoTextoLeitura dados_jogos = new ArquivoTextoLeitura("C:\\Users\\1229176\\Downloads\\lab_04\\jogos.txt"); // Comentar para enviar
        ArquivoTextoLeitura dados_jogos = new ArquivoTextoLeitura("jogos.txt"); // Comentar para enviar
        // ArquivoTextoLeitura dados_jogos = new ArquivoTextoLeitura("/tmp/jogos.txt"); // Descomentar para enviar

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