import java.util.ArrayList;

public class Lab_04 {

    public static void main(String[] args) {
        ArquivoTextoLeitura dados_jogos = new ArquivoTextoLeitura("C:\\Users\\1229176\\Downloads\\lab_04\\jogos.txt"); // Comentar para enviar
        // ArquivoTextoLeitura dados_jogos = new ArquivoTextoLeitura("/tmp/jogos.txt"); // Descomentar para enviar

        ArrayList<Jogo> lista_jogos = new ArrayList<>();
        String linha;

        while ((linha = dados_jogos.ler()) != null) {
            Jogo jogo = new Jogo();
            jogo.ler(linha);
            lista_jogos.add(jogo);
            jogo.imprimir(); // MUITO IMORTANTE: TESTAR DADO LIDO DO ARQUIVO
        }
        
        for (int i = 0; !(linha = MyIO.readLine()).equals("FIM"); i++) {
            pesquisar(linha, lista_jogos);
        }
        MyIO.println("Quantidade de jogos encontrados: " + lista_jogos.size());
    }
    public void pesquisar(String linha, ArrayList<Jogo> lista_jogos) {
        String dados_pesquisa[] = linha.split(";");
        String nome = dados_pesquisa[0];
        int ano = Integer.parseInt(dados_pesquisa[1]);
        String editora = dados_pesquisa[2];
        String plataforma = dados_pesquisa[3];
        
        for (int index = 0; index < lista_jogos.size(); index++) {
            if (lista_jogos[i].equals("nome")) {
                return lista_jogos[i].clone();
            }
        }
    }
}