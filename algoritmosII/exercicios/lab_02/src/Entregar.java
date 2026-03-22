import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class MyIO {

   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
   private static String charset = "ISO-8859-1";

   public static void setCharset(String charset_){
      charset = charset_;
      in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
   }

   public static void print(){
   }

   public static void print(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
   
   public static void print(float x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
   
   public static void print(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(){
   }

   public static void println(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(float x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
   
   public static void println(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void printf(String formato, double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.printf(formato, x);// "%.2f"
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static double readDouble(){
      double d = -1;
      try{
         d = Double.parseDouble(readString().trim().replace(",","."));
      }catch(Exception e){}
      return d;
   }

   public static double readDouble(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readDouble();
   }

   public static float readFloat(){
      return (float) readDouble();
   }

   public static float readFloat(String str){
      return (float) readDouble(str);
   }

   public static int readInt(){
      int i = -1;
      try{
         i = Integer.parseInt(readString().trim());
      }catch(Exception e){}
      return i;
   }

   public static int readInt(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readInt();
   }

   public static String readString(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != ' ' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n' && tmp != ' ');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readString(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readString();
   }

   public static String readLine(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readLine(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readLine();
   }

   public static char readChar(){
      char resp = ' ';
      try{
         resp  = (char)in.read();
      }catch(Exception e){}
      return resp;
   }

   public static char readChar(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readChar();
   }

   public static boolean readBoolean(){
      boolean resp = false;
      String str = "";

      try{
         str = readString();
      }catch(Exception e){}

      if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || 
            str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
         resp = true;
            }

      return resp;
   }

   public static boolean readBoolean(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readBoolean();
   }

   public static void pause(){
      try{
         in.read();
      }catch(Exception e){}
   }

   public static void pause(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      pause();
   }
}

class Jogo {
    private int rank;
    private String nome_jogo;
    private String plataforma;
    private int ano;
    private String genero;
    private String editora;
    private double NA_Vendas;
    private double EU_Vendas;
    private double JP_Vendas;
    private double Outras_Vendas;
    private double Vendas_Global;

    public Jogo() {
    }

    private Jogo(String nome_jogo, String plataforma, int ano) {
        this.nome_jogo = nome_jogo;
        this.plataforma = plataforma;
        this.ano = ano;
    }

    public int getRank() { return rank; }

    public void setRank(int rank) {this.rank = rank; }

    public String getNome_jogo() { return nome_jogo; }

    public void setNome_jogo(String nome_jogo) { this.nome_jogo = nome_jogo; }

    public String getPlataforma() { return plataforma; }

    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public int getAno() { return ano; }

    public void setAno(int ano) { this.ano = ano; }

    public String getGenero() { return genero; }

    public void setGenero(String genero) { this.genero = genero; }

    public String getEditora() { return editora; }

    public void setEditora(String editora) { this.editora = editora; }

    public double getNA_Vendas() { return NA_Vendas; }

    public void setNA_Vendas(double nA_Vendas) { NA_Vendas = nA_Vendas; }

    public double getEU_Vendas() { return EU_Vendas; }

    public void setEU_Vendas(double eU_Vendas) { EU_Vendas = eU_Vendas; }

    public double getJP_Vendas() { return JP_Vendas;
    }

    public void setJP_Vendas(double jP_Vendas) { JP_Vendas = jP_Vendas; }

    public double getOutras_Vendas() { return Outras_Vendas; }

    public void setOutras_Vendas(double outras_Vendas) { Outras_Vendas = outras_Vendas; }

    public double getVendas_Global() { return Vendas_Global; }

    public void setVendas_Global(double vendas_Global) { Vendas_Global = vendas_Global; }

    public Jogo clone() {
        Jogo clone_jogo = new Jogo();

        clone_jogo.rank = rank;
        clone_jogo.nome_jogo = nome_jogo;
        clone_jogo.plataforma = plataforma;
        clone_jogo.ano = ano;
        clone_jogo.genero = genero;
        clone_jogo.editora = editora;
        clone_jogo.NA_Vendas = NA_Vendas;
        clone_jogo.EU_Vendas = EU_Vendas;
        clone_jogo.JP_Vendas = JP_Vendas;
        clone_jogo.Outras_Vendas = Outras_Vendas;
        clone_jogo.Vendas_Global = Vendas_Global;

        return clone_jogo;
    }

    public void ler(String valor_lido){
        String[] atributo = valor_lido.split(";");
        
        this.rank = Integer.parseInt(atributo[0]);
        this.nome_jogo = atributo[1];
        this.plataforma = atributo[2];
        this.ano = Integer.parseInt(atributo[3]);
        this.genero = atributo[4];
        this.editora = atributo[5];
        this.NA_Vendas = Double.parseDouble(atributo[6]);
        this.EU_Vendas = Double.parseDouble(atributo[7]);
        this.JP_Vendas = Double.parseDouble(atributo[8]);
        this.Outras_Vendas = Double.parseDouble(atributo[9]);
        this.Vendas_Global = Double.parseDouble(atributo[10]);
    }

    public void imprimir(){ MyIO.println(toString()); }

    @Override
    public String toString() { return editora + ". " + nome_jogo + ". " + ano + ". Vendas global: " + Vendas_Global + ". "; }
}

public class Entregar {
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
