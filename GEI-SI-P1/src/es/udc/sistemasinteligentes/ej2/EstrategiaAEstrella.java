package es.udc.sistemasinteligentes.ej2;

import es.udc.sistemasinteligentes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class EstrategiaAEstrella implements EstrategiaBusquedaInformada {

    public EstrategiaAEstrella (){
    }

    public Estado soluciona(ProblemaBusqueda p, Heuristica h) throws Exception{
        int cont_creados = 0, cont_expandidos = 0;
        ArrayList<Nodo2> explorados = new ArrayList<>();
        Nodo2 nodoActual = new Nodo2(p.getEstadoInicial(), null, null, h);
        cont_creados++;
        System.out.println("Nodo " + cont_creados + ": " + nodoActual.getEstado());
        explorados.add(nodoActual);
        PriorityQueue<Nodo2> frontera = new PriorityQueue<>();
        frontera.add(nodoActual);

        while (!p.esMeta(nodoActual.getEstado())){

            if(frontera.isEmpty()) throw new Exception("Frontera vacía.");
            nodoActual=frontera.poll();
            cont_expandidos++;
            explorados.add(nodoActual);
            Accion[] accionesDisponibles = p.acciones(nodoActual.getEstado());

            for (Accion acc: accionesDisponibles) {
                Nodo2 sc = new Nodo2 (p.result(nodoActual.getEstado(), acc), nodoActual, acc, h);
                cont_creados++;
                if (!explorados.contains(sc) && !frontera.contains(sc)) {
                    System.out.println("Nodo " + cont_creados + ": " + sc.getEstado());
                    frontera.add(sc);  //añado a la frontera nodos no explorados
                }
            }
        }

        System.out.println("\nCreados: " + cont_creados + "\nExplorados: " + cont_expandidos);
        return nodoActual.getEstado();
    }
/*
    public ArrayList<Nodo> reconstruye_sol (Estado nodo){
        ArrayList<Nodo> sol = new ArrayList<> ();
        Nodo nodoActual = nodo;

        while (nodoActual != null){
            sol.add(nodoActual);
            nodoActual = nodoActual.getPadre();
        }

        Collections.reverse(sol);
        return sol;
    }*/
}
