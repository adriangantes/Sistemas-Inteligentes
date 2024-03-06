package es.udc.sistemasinteligentes.ejemplo;

import es.udc.sistemasinteligentes.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.ProblemaBusqueda;
import es.udc.sistemasinteligentes.EstrategiaBusquedaGrafo;
import es.udc.sistemasinteligentes.Nodo;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {
        ProblemaAspiradora.EstadoAspiradora estadoInicial = new ProblemaAspiradora.EstadoAspiradora(ProblemaAspiradora.EstadoAspiradora.PosicionRobot.IZQ,
                                                                                                    ProblemaAspiradora.EstadoAspiradora.PosicionBasura.AMBAS);
        ProblemaBusqueda aspiradora = new ProblemaAspiradora(estadoInicial);
        ArrayList<Nodo> solucion;

        EstrategiaBusqueda buscador = new Estrategia4();
        solucion = buscador.soluciona(aspiradora);
        System.out.println("\nSolucion Aplicando Estrategia4: \n");
        for (Nodo n: solucion) {
            System.out.println(n);
        }

        System.out.println("\n");

        ProblemaBusqueda aspiradora2 = new ProblemaAspiradora(estadoInicial);

        EstrategiaBusqueda buscador2 = new EstrategiaBusquedaGrafo();
        solucion = buscador2.soluciona(aspiradora2);
        System.out.println("Solucion Aplicando BusquedaGrafo: \n");
        for (Nodo n: solucion) {
            System.out.println(n);
        }
    }

}
