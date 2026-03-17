Parte 1: Armazenamento de informações em vetor
O aluno(a) deve preencher um vetor de objetos da classe Jogo com os dados dos diversos jogos informados
na entrada padrão (teclado - pub.in).
A primeira linha contém a quantidade de jogos que devem ser armazenados em um vetor.
Cada uma das linhas seguintes apresenta os dados de um jogo, separados pelo símbolo “;”. Os dados
possuem, em ordem, as seguintes informações:
• rank (int);
• nome do jogo (String);
• plataforma (String);
• ano (int);
• gênero (String);
• editora (String);
• NA_Vendas (double);
• EU_Vendas (double);
• JP_Vendas (double);
• Outras_Vendas (double);
• Vendas_Global (double);

Até aqui consegui fazer tranquilamente, porém a 2° parte eu estou com dúvidas em como prosseguir.

Parte 2: Pesquisa de informações armazenadas no vetor criado na parte 1.
Após o processamento da primeira parte da entrada de dados, o programa deve processar a segunda
parte da entrada padrão. Cada linha da segunda parte contém, em ordem, as seguintes informações:
• nome do jogo;
• ano;
• editora.
As entradas devem ser pesquisadas no vetor de jogos.
Para cada jogo encontrado, escreva na saída padrão uma linha contendo as informações do jogo, com os
dados do registro correspondente. Caso um jogo apareça no arquivo pub.in mais de uma vez, somente
a primeira ocorrência de um jogo deve ser apresentada na saída.
A saída padrão deve obedecer o seguinte formato (não incluir as chaves): {nome do jogo}. {editora}. {ano}.
Vendas global: {Vendas_Global}.
Exemplo:
Sega. Puyo Puyo Tetris. 2014. Vendas global: 0.05.

Aqui estou em dúvidas se:
 crio 2 vetores 1 para armazenar valores não repetidos e 1 para armazenar valores repetidos, percorrendo todo o vetor ou se crio 1 unico vetor e a cada inserção insiro e percorro todo o vetor a cada vez e comparo o atributo nome de cada objeto com os atributos nomes do vetor de objetos. Tem algum pensamento mais prático e profissional com clean code, SOLID, etc. que possa auxiliar a lódica disso? Desenvolvi o código abaixo, me apresente raciocinio lógico e não código pronto.

// Parte 1: Armazenamento de informações em vetor
        Jogo[] vetor_jogo = new Jogo[Integer.parseInt(linha_lida)];
        int indice = 0;
        while (!linha_lida.equals("FIM")) {
            vetor_jogo[indice] = new Jogo();
            vetor_jogo[indice].ler(linha_lida);
        }
        
---

Seu problema na **parte 2** não é exatamente de estrutura de dados, mas de **estratégia de busca + controle de duplicidade**. Pensando em lógica limpa (e até próximo de princípios como **responsabilidade única e simplicidade**), a solução mais profissional geralmente é **não duplicar estruturas desnecessariamente**.

Vamos organizar o raciocínio.

---

# 1️⃣ Primeiro: entenda o que realmente precisa ser feito

Na **parte 2** você recebe consultas contendo:

* nome do jogo
* ano
* editora

Você precisa:

1. **buscar no vetor `Jogo[]` criado na parte 1**
2. **encontrar o jogo correspondente**
3. **imprimir apenas a primeira ocorrência**
4. ignorar ocorrências repetidas do mesmo jogo

Ou seja, existem **dois problemas separados**:

* 🔎 **Buscar um jogo**
* 🚫 **Garantir que ele não foi mostrado antes**

Separar esses dois conceitos ajuda muito na clareza do código.

---

# 2️⃣ Não faz sentido criar dois vetores

Você sugeriu:

> criar um vetor para repetidos e outro para não repetidos

Isso **não é necessário**, porque:

* o vetor original **já contém todos os dados**
* repetição não é um problema de armazenamento
* repetição é um problema **de controle de saída**

Logo, criar outro vetor **só aumenta complexidade**.

---

# 3️⃣ Estratégia mais simples (e usada em algoritmos)

Use:

* vetor original de jogos
* estrutura para **controlar o que já foi exibido**

Exemplo conceitual:

```
vetorJogos -> dados originais

exibidos -> controle de duplicidade
```

Esse `exibidos` poderia ser:

* lista
* vetor
* ou mentalmente um "registro" de nomes já mostrados

A lógica seria:

```
para cada consulta:
    procurar no vetor de jogos
    se encontrar:
        verificar se já foi exibido
        se NÃO foi exibido:
            imprimir
            registrar como exibido
```

---

# 4️⃣ Como pensar na busca

A busca provavelmente será **linear**, porque:

* você tem apenas um vetor
* não existe índice por nome

Então mentalmente:

```
para cada jogo do vetor
    se nome == consulta.nome
       e ano == consulta.ano
       e editora == consulta.editora
           encontramos
           parar
```

Importante: **parar na primeira ocorrência**, porque o enunciado pede isso.

---

# 5️⃣ Separação lógica (pensamento de clean code)

Mesmo que você não implemente assim agora, pense em **responsabilidades**:

### função mental 1

```
buscarJogo(vetor, nome, ano, editora)
```

Responsabilidade:

* encontrar a **primeira ocorrência**

---

### função mental 2

```
jaFoiExibido(nome)
```

Responsabilidade:

* controlar duplicidade

---

### fluxo principal

```
ler consulta

jogo = buscarJogo(...)

se jogo existe:
    se nao foi exibido:
        imprimir
        registrar exibicao
```

Isso evita:

* loops desnecessários
* estruturas duplicadas
* código difícil de manter

---

# 6️⃣ Complexidade do algoritmo

Se tiver:

```
N jogos
Q consultas
```

A busca linear custa:

```
O(N * Q)
```

Para exercícios acadêmicos isso é **perfeitamente aceitável**.

Estruturas mais avançadas (HashMap etc.) só fariam sentido se o exercício pedisse **otimização**.

---

# 7️⃣ Um detalhe importante no seu código atual

Seu `while` provavelmente vai dar problema:

```java
while (!linha_lida.equals("FIM"))
```

Porque você precisa:

* ler **N linhas**, não até "FIM".

Então o fluxo normalmente seria:

```
ler N

para i de 0 até N
    ler linha
    criar jogo
    armazenar no vetor
```

Depois começa a **segunda parte da entrada**.

---

# 8️⃣ Resumindo a melhor abordagem

Estrutura:

```
Jogo[] jogos
estrutura controleExibidos
```

Fluxo:

```
ler consulta
buscar jogo no vetor
se encontrou:
    se ainda nao exibido:
        imprimir
        marcar como exibido
```

✔ simples
✔ sem duplicação de estruturas
✔ fácil de entender
✔ alinhado com clean code

---

✅ **Dica de professor de estrutura de dados:**
Sempre que aparecer duplicidade em saída, pense primeiro em **controle lógico**, não em **duplicar armazenamento**.

---

💡 Se quiser, posso também te mostrar:

* **o erro lógico que pode ocorrer nesse tipo de exercício** (90% dos alunos cometem)
* **como organizar a leitura da entrada pub.in corretamente**
* **como estruturar a classe `Jogo` para facilitar a busca**
