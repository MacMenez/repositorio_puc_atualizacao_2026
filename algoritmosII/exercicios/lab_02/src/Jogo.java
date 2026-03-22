public class Jogo {
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

    public Jogo() {}

    private Jogo(String nome_jogo, String plataforma, int ano) {
        this.nome_jogo = nome_jogo;
        this.plataforma = plataforma;
        this.ano = ano;
    }

    public int getRank() { return rank; }

    public void setRank(int rank) { this.rank = rank; }

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
