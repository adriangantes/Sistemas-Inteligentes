package es.udc.sistemasinteligentes.ej2;

import es.udc.sistemasinteligentes.Accion;
import es.udc.sistemasinteligentes.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.Nodo;
import es.udc.sistemasinteligentes.ProblemaBusqueda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class EstrategiaProfundidad implements EstrategiaBusqueda { //cola lifo
    public ArrayList<Nodo> soluciona(ProblemaBusqueda p) throws Exception{
        int cont_creados = 0, cont_expandidos = 0;
        ArrayList<Nodo> explorados = new ArrayList<>();
        Nodo nodoActual = new Nodo(p.getEstadoInicial(), null, null);
        cont_creados++;
        System.out.println("Nodo " + cont_creados + ": " + nodoActual.getEstado());
        explorados.add(nodoActual);
        Stack<Nodo> frontera = new Stack<>();
        frontera.push(nodoActual);

        while (!p.esMeta(nodoActual.getEstado())){
            if(frontera.isEmpty()) throw new Exception("Frontera vacía.");
            nodoActual=frontera.pop();
            cont_expandidos++;
            explorados.add(nodoActual);
            Accion[] accionesDisponibles = p.acciones(nodoActual.getEstado());
            for (Accion acc: accionesDisponibles) {
                Nodo sc = new Nodo (p.result(nodoActual.getEstado(), acc), nodoActual, acc);
                cont_creados++;
                if (!explorados.contains(sc) && !frontera.contains(sc)) {
                    System.out.println("Nodo " + cont_creados + ": " + sc.getEstado());
                    frontera.add(sc);  //añado a la frontera nodos no explorados
                }
            }
        }

        System.out.println("Creados: " + cont_creados + "\nExplorados: " + cont_expandidos);
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
