package es.udc.sistemasinteligentes.ejemplo;

import es.udc.sistemasinteligentes.*;

import java.util.ArrayList;
import java.util.Collections;

public class Estrategia4 implements EstrategiaBusqueda {

    public Estrategia4() {
    }

    @Override
    public ArrayList<Nodo> soluciona(ProblemaBusqueda p) throws Exception{
        ArrayList<Nodo> explorados = new ArrayList<>();
        System.out.println(p.getEstadoInicial());
        Nodo nodoActual = new Nodo(p.getEstadoInicial(), null, null);
        explorados.add(nodoActual);

        int i = 1;

        System.out.println((i++) + " - Empezando búsqueda en " + nodoActual.getEstado());

        while (!p.esMeta(nodoActual.getEstado())){
            System.out.println((i++) + " - " + nodoActual.getEstado() + " no es meta");
            Accion[] accionesDisponibles = p.acciones(nodoActual.getEstado());
            boolean modificado = false;
            for (Accion acc: accionesDisponibles) {
                Nodo sc = new Nodo (p.result(nodoActual.getEstado(), acc), nodoActual, acc);
                System.out.println((i++) + " - RESULT(" + nodoActual.getEstado() + ","+ acc + ")=" + sc.getEstado());

                if (!explorados.contains(sc)) {
                    nodoActual = sc;
                    System.out.println((i++) + " - " + sc.getEstado() + " NO explorado");
                    explorados.add(nodoActual);
                    modificado = true;
                    System.out.println((i++) + " - Estado actual cambiado a " + nodoActual.getEstado());
                    break;
                }
                else
                    System.out.println((i++) + " - " + sc.getEstado() + " ya explorado");
            }
            if (!modificado) throw new Exception("No se ha podido encontrar una solución");
        }
        System.out.println((i) + " - FIN - " + nodoActual.getEstado());

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
