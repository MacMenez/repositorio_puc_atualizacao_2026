public class Pilha {
    Celula topo;

    /* Exercício 5 - MOSTAR RECURSIVO */
    public void mostraRecursivo(){
        mostrarRecursivo(topo);
    }

    public void mostrarRecursivo(Celula i){
        if(i != null){
            System.out.println(i.elemento);
            mostrarRecursivo(i.prox);
        }
    }

    public void mostrarIterativo1(){
        mostrarIterativo1(topo);
    }

    public void mostrarIterativo1(Celula i){
        Pilha aux = new Pilha();
        for(Celula i = topo; j != null; i = i.prox){
            aux.empilhar(i.elemento);
        }
        for(Celula i = aux.topo; i != null; i = i.prox){
            System.out.println(i.elemento);
        }
    }
    
    public void mostrarIterativo2(){
        mostrarIterativo2(topo);
    }

    public void mostrarIterativo2(Celula i) {
        Celula ultimo;

        for(Celula i = topo; i != null; i = i.prox){
            if (i.prox == null) {
                ultimo = i;
            }
        }

        for(Celula i = topo; ultimo != null && i != ultimo.prox; i = i.prox){
            if(i == ultimo.prox){
                System.out.println(i.elemento);
                ultimo = i;
                i = topo;
            } else if(ultimo == topo){
                System.out.println(i.elemento);
                ultimo = null;
            }
        }
    }
}