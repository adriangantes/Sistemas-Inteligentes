package es.udc.sistemasinteligentes;

import es.udc.sistemasinteligentes.ejemplo.ProblemaAspiradora;

import java.util.*;

public class EstrategiaBusquedaGrafo implements EstrategiaBusqueda {

    public EstrategiaBusquedaGrafo() {
    }

    @Override
    public ArrayList<Nodo> soluciona(ProblemaBusqueda p) throws Exception{
        ArrayList<Nodo> explorados = new ArrayList<>();
        Nodo nodoActual = new Nodo(p.getEstadoInicial(), null, null);
        explorados.add(nodoActual);
        Queue<Nodo> frontera = new LinkedList<>();
        frontera.add(nodoActual);

        while (!p.esMeta(nodoActual.getEstado())){
            if(frontera.isEmpty()) throw new Exception("Frontera vacía.");
            nodoActual=frontera.poll();
            explorados.add(nodoActual);
            Accion[] accionesDisponibles = p.acciones(nodoActual.getEstado());
            for (Accion acc: accionesDisponibles) {
                Nodo sc = new Nodo (p.result(nodoActual.getEstado(), acc), nodoActual, acc);

                if (!explorados.contains(sc) && !frontera.contains(sc)) {
                    frontera.add(sc);  //añado a la frontera nodos no explorados
                }
            }
        }

        return reconstruye_sol(nodoActual);
    }

    private ArrayList<Nodo> reconstruye_sol (Nodo nodo){
        ArrayList<Nodo> sol = new ArrayList<> ();
        Nodo nodoActual = nodo;

        while (nodoActual != null){
            sol.add(nodoActual);
            nodoActual = nodoActual.getPadre();
        }

        Collections.reverse(sol);
        return sol;
    }
}
