package es.udc.sistemasinteligentes;

import java.util.ArrayList;

public class Nodo {
    private final Estado estado;
    private final Nodo padre;
    private final Accion accion;

    public Nodo (Estado e, Nodo p, Accion a){
        this.estado = e;
        this.padre = p;
        this.accion = a;
    }

    public Nodo getPadre() {
        return padre;
    }

    public Accion getAccion() {
        return accion;
    }

    public Estado getEstado() {
        return estado;
    }

    @Override
    public int hashCode() {
        return estado.hashCode() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return hashCode() == o.hashCode();
    }

    @Override
    public String toString() {
        if(accion == null && padre == null){
            return "Nodo {" + "es=" + estado.toString() + ", ac= Ninguno"  + ", fha = Ninguno }'";
        }else{
            return "Nodo {" + "es=" + estado.toString() + ", ac=" + accion.toString() + ", fha=" + padre.hashCode() +'}';
        }
    }
}
