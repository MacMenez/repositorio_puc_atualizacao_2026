# Consultas SPARQL — Ontologia Cultura Pop Japonesa v4

## Prefixos utilizados

```sparql
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX pop: <http://www.semanticweb.org/dcmen/ontologies/2026/2/untitled-ontology-2#>
```

---

1. Listar instâncias em ordem alfabética de uma determinada classe

Objetivo: Listar todas as instâncias da classe Anime em ordem alfabética.


PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX pop: <http://www.semanticweb.org/dcmen/ontologies/2026/2/untitled-ontology-2#>

SELECT DISTINCT ?anime
WHERE {
  ?anime rdf:type pop:Anime .
}
ORDER BY ?anime


---

2. Listar classes utilizando UNION

Objetivo: Listar instâncias pertencentes às classes Anime e Manga utilizando UNION.

PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX pop: <http://www.semanticweb.org/dcmen/ontologies/2026/2/untitled-ontology-2#>

SELECT ?obra
WHERE {
  {
    ?obra rdf:type pop:Anime .
  }
  UNION
  {
    ?obra rdf:type pop:Manga .
  }
}
ORDER BY ?obra

---

3. Listar instâncias utilizando FILTER

Objetivo: Listar jogos publicados após o ano 2000.


PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX pop: <http://www.semanticweb.org/dcmen/ontologies/2026/2/untitled-ontology-2#>

SELECT ?jogo ?ano
WHERE {
  ?jogo rdf:type pop:Jogo .
  ?jogo pop:anoPublicacao ?ano .

  FILTER(?ano > 2000)
}
ORDER BY ?ano

---

4. Listar classes utilizando propriedade de restrição

Objetivo: Listar animes que possuem a propriedade temGenero associada ao gênero Acao.


PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX pop: <http://www.semanticweb.org/dcmen/ontologies/2026/2/untitled-ontology-2#>

SELECT ?anime
WHERE {
  ?anime rdf:type pop:Anime .
  ?anime pop:temGenero pop:Acao .
}
ORDER BY ?anime

---

5. Listar instâncias utilizando FILTER e propriedade de restrição

Objetivo: Listar mangás publicados após 1990 e que pertençam ao gênero Romance.


PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX pop: <http://www.semanticweb.org/dcmen/ontologies/2026/2/untitled-ontology-2#>

SELECT ?manga ?ano
WHERE {
  ?manga rdf:type pop:Manga .
  ?manga pop:anoPublicacao ?ano .
  ?manga pop:temGenero pop:Romance .

  FILTER(?ano > 1990)
}
ORDER BY ?ano


---

# Como executar no Protégé

## Passo 1
Abrir sua ontologia:

```text
Domínio_Cultura_Pop_Japonesa_v4.rdf
```

---

## Passo 2
Abrir a aba SPARQL:

```text
Window → Tabs → SPARQL Query
```

---

## Passo 3
Executar o Reasoner:

```text
Reasoner → Start Reasoner
```

Recomendado usar Pellet.

---

## Passo 4
Copiar uma consulta.

---

## Passo 5
Colar na aba SPARQL Query.

---

## Passo 6
Clicar em:

```text
Execute
```

---

# Observações importantes

## 1. Sobre os nomes das propriedades

As consultas assumem que você criou:

- temGenero
- anoPublicacao
- Anime
- Manga
- Jogo

Caso algum nome esteja diferente na sua ontologia, substitua no código.

---

## 2. Sobre os indivíduos

As consultas só retornam resultados se existirem instâncias cadastradas.

Exemplos:

- BleachAnime
- AttackOnTitanAnime
- BerserkManga
- FinalFantasy

---

## 3. Sobre FILTER

FILTER é usado para aplicar restrições lógicas.

Exemplo:

```sparql
FILTER(?ano > 2000)
```

---

## 4. Sobre UNION

UNION une resultados de diferentes padrões.

Exemplo:

```sparql
Anime UNION Manga
```

---

## 5. Sobre ORDER BY

ORDER BY organiza os resultados em ordem alfabética ou numérica.

