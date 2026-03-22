# Compilação

## Comando via CMD

javac App.java && java App < pub.in > minha_resposta.txt

diff pub.out .\minha_resposta.txt

diff -y pub.out minha_resposta.txt

## Comando via POWERSHELL

Get-Content pub.in | java App > saida.in

Compare-Object (Get-Content pub.out) (Get-Content minha_resposta.txt)

Compare-Object (Get-Content pub.out) (Get-Content minha_resposta.txt) -IncludeEqual