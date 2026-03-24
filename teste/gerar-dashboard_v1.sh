#!/bin/bash

JSON="docs/disciplinas.json"
OUT="docs/disciplinas.md"

TOTAL=$(jq '.disciplinas | length' $JSON)
CONCLUIDAS=$(jq '[.disciplinas[] | select(.status=="concluida")] | length' $JSON)

PERCENT=$((CONCLUIDAS * 100 / TOTAL))

echo "# Dashboard do Curso" > $OUT
echo "" >> $OUT

echo "Progresso do curso:" >> $OUT
echo "" >> $OUT

echo "**$PERCENT% concluído**" >> $OUT
echo "" >> $OUT

echo "| Disciplina | Status |" >> $OUT
echo "|-----------|--------|" >> $OUT

jq -r '.disciplinas[] | "| \(.nome) | \(.status) |"' $JSON >> $OUT