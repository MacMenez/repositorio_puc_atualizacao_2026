#!/bin/bash

git fetch --all

for branch in $(git branch | sed 's/*//')
do

git checkout $branch

git pull

done

git checkout main

echo "Sincronização completa"