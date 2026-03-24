#!/bin/bash

ARQ_JSON="docs/disciplinas.json"
ARQ_MD="docs/disciplinas.md"

if [ ! -f "$ARQ_JSON" ]; then
  echo "Arquivo $ARQ_JSON não encontrado!"
  exit 1
fi

TOTAL=$(jq length "$ARQ_JSON" 2>/dev/null)
CONCLUIDAS=$(jq '[.[] | select(.status=="concluida")] | length' "$ARQ_JSON" 2>/dev/null)
ANDAMENTO=$(jq '[.[] | select(.status=="andamento")] | length' "$ARQ_JSON" 2>/dev/null)
NAO_INICIADAS=$(jq '[.[] | select(.status=="nao_iniciada")] | length' "$ARQ_JSON" 2>/dev/null)

if [ "$TOTAL" -eq 0 ]; then
  PORCENTAGEM=0
else
  PORCENTAGEM=$((CONCLUIDAS * 100 / TOTAL))
fi

cat <<EOF > "$ARQ_MD"
# 📊 Dashboard da Graduação

- 🎯 Total de disciplinas: $TOTAL
- ✅ Concluídas: $CONCLUIDAS
- 🚧 Em andamento: $ANDAMENTO
- ⏳ Não iniciadas: $NAO_INICIADAS

## 📈 Progresso geral:
**$PORCENTAGEM% concluído**
EOF

echo "Dashboard atualizado com sucesso!"