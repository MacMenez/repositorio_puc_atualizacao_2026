Professor, novamente meu Protegé deu erro para realizar a tarefa. Descreverei aqui as etapas que fiz e que deram certo e as que não deram certo.


DEU CERTO:

Classe
Anime
|_______AnimeLongo

Jogo
|_______JogoRPG


Data Properties
totalEpisodios -> 

Domain:
Anime

Range:
xsd:integer

Jogo
nomeGenero

DEU ERRADO:

Professor, pelo que entendi, o que desenvolvi a seguir esta correto, ms ao inserir no Protegé, apresentou o erro de Invalid SWRL. Não consegui identificar muito bem o motivo, mas creio estar tudo certo, segue abaixo os objetivos que desenvolvi baseado no enunciado e o que consegui criar como resposta ao que foi solicitado.

Regra SWRL nº 1
Objetivo: Anime com mais de 100 episódios torna-se AnimeLongo.
Caminho que usei: Window → Tabs → SWRLTab

Criei:
Anime(?a) ^
totalEpisodios(?a, ?e) ^
swrlb:greaterThan(?e, 100)
-> AnimeLongo(?a)


Se:
é Anime e possui totalEpisodios maior que 100 então: pertence à classe AnimeLongo

Exemplo com minha ontologia:
BleachAnime possui:
totalEpisodios = 366
Após o Reasoner -> | BleachAnime rdf:type AnimeLongo | será inferido.

SWRL nº 2
Objetivo: Todo jogo com gênero RPG torna-se JogoRPG.

Supondo:
FinalFantasyVII
temGenero RPG

Criei:
Jogo(?j) ^
temGenero(?j, RPG)
-> JogoRPG(?j)

Após o Reasoner: FinalFantasyVII rdf:type JogoRPG

Usei a aba do SWRLTab para criar os 2 códigos e, por algum motivo, deu erro e não consegui corrigir. Igual na semana passada. Pelo que entendi, caso o programa permitisse eu criar as regras sem erro, depois de eu executar: Reasoner → Pellet → Start Reasoner
Eu teria como resultado: 
AnimeLongo
   BleachAnime

JogoRPG
   FinalFantasyVII

Após eu verificar: Inferred Class Hierarchy

Por dar estes erros, também não foi possível realizar no Protege a parte das consultas. Portanto, deixarei abaixo meu pensamento e minha forma de executar.

Consulta SPARQL 1: Listar todos os animes longos inferidos.

PREFIX pop: <http://www.semanticweb.org/dcmen/ontologies/2026/2/untitled-ontology-2#>

SELECT ?anime
WHERE {
    ?anime rdf:type pop:AnimeLongo .
}

Consulta SPARQL 2: Listar todos os jogos RPG inferidos.
PREFIX pop: <http://www.semanticweb.org/dcmen/ontologies/2026/2/untitled-ontology-2#>

SELECT ?jogo
WHERE {
    ?jogo rdf:type pop:JogoRPG .
}



Pensei também na possibilidade de usar triplas usando SPARQL CONSTRUCT:

Consulta 1:

PREFIX pop: <http://www.semanticweb.org/dcmen/ontologies/2026/2/untitled-ontology-2#>

CONSTRUCT {
   ?anime rdf:type pop:AnimeLongo .
}
WHERE {
   ?anime rdf:type pop:Anime .
   ?anime pop:totalEpisodios ?ep .
   FILTER(?ep > 100)
}


Consulta 2:

PREFIX pop: <http://www.semanticweb.org/dcmen/ontologies/2026/2/untitled-ontology-2#>

CONSTRUCT {
   ?jogo rdf:type pop:JogoRPG .
}
WHERE {
   ?jogo rdf:type pop:Jogo .
   ?jogo pop:temGenero pop:RPG .
}