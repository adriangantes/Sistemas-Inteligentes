package es.udc.sistemasinteligentes.ej2;

import es.udc.sistemasinteligentes.Accion;
import es.udc.sistemasinteligentes.Estado;
import es.udc.sistemasinteligentes.Heuristica;
import es.udc.sistemasinteligentes.Nodo;

public class Nodo2 extends Nodo implements Comparable<Nodo2>{

    private final int coste;
    private final int funcion;

    public Nodo2(Estado e, Nodo2 p, Accion a, Heuristica h) {
        super(e, p, a);
        if (p != null){
            this.coste = p.getCoste() + 1;
            this.funcion = coste + (int)h.evalua(e);
        }else{
            this.coste = 0;
            this.funcion = 0;
        }
    }

    @Override
    public int compareTo(Nodo2 o) {
        return Integer.compare(this.getFuncion(), o.getFuncion());
        
        /*
        if (o.getFuncion() < this.getFuncion()){
            return 1;
        }
        if (this.getFuncion() < o.getFuncion()){
            return -1;
        }
        return 0;
        */
    }

    public int getCoste() {
        return coste;
    }

    public int getFuncion() {
        return funcion;
    }
}
