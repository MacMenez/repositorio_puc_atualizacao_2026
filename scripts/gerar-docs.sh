#!/bin/bash

OUT="docs/disciplinas.md"

echo "# Lista de Disciplinas" > $OUT
echo "" >> $OUT

git branch -r | grep disciplina | while read line
do

BRANCH=$(echo $line | sed 's/origin\///')

DISC=$(echo $BRANCH | cut -d'/' -f2)

echo "- $DISC" >> $OUT

done

echo "Documentação gerada em $OUT"