package es.udc.sistemasinteligentes.ej2;
import es.udc.sistemasinteligentes.*;
import es.udc.sistemasinteligentes.ej2.ProblemaCuadradoMagico;

import java.util.ArrayList;

public class MainEj2a {
    public static void main(String[] args) throws Exception {
        int matriz[][] = {{4,9,2},{3,5,0},{0,1,0}};
        int matriz2[][] = {{2,0,0},{0,0,0},{0,0,0}};
        int matriz3[][] = {{2,0,0,0},{0,0,0,0},{0,0,0,0},{0,1,0,0}};

        ProblemaCuadradoMagico.EstadoCuadrado estadoInicial  = new ProblemaCuadradoMagico.EstadoCuadrado(matriz);
        ProblemaBusqueda cuadrado = new ProblemaCuadradoMagico(estadoInicial);
        ArrayList<Nodo> solucion;


        System.out.println("\nSolucion Aplicando BusquedaProfundiad:");
        EstrategiaBusqueda buscador = new EstrategiaProfundidad();
        solucion = buscador.soluciona(cuadrado);
        EstrategiaProfundidad busqueda2 = (EstrategiaProfundidad) buscador;
        System.out.println("Solucion : ");
//        System.out.println("Nodos Explorados: "+ busqueda2.getNodosExplorados());
//        System.out.println("Nodos Creados: "+ busqueda2.getNodosCreados() );
        for (Nodo n: solucion) {
            System.out.println(n);
        }


        ProblemaCuadradoMagico.EstadoCuadrado estadoInicial2  = new ProblemaCuadradoMagico.EstadoCuadrado(matriz2);
        ProblemaBusqueda cuadrado2 = new ProblemaCuadradoMagico(estadoInicial2);
//        System.out.println("\nSolucion cuadrado 2 Aplicando BusquedaAnchura: \n");
//        buscador = new BusquedaAnchura();
//        solucion = buscador.soluciona(cuadrado2);
//        System.out.println("Solucion : ");
//        busqueda = (BusquedaAnchura) buscador;
//        System.out.println("Nodos Explorados: "+ busqueda.getNodosExplorados());
//        System.out.println("Nodos Creados: "+ busqueda.getNodosCreados() );
//        for (Nodo n: solucion) {
//            System.out.println(n);
//        }

//        System.out.println("\nSolucion cuadrado 2 Aplicando BusquedaProfundiad:");
//        buscador = new EstrategiaProfundidad();
//        solucion = buscador.soluciona(cuadrado2);
//        busqueda2 = (BusquedaGrafoProfundidad) buscador;
//        System.out.println("Nodos Explorados: "+ busqueda2.getNodosExplorados());
//        System.out.println("Nodos Creados: "+ busqueda2.getNodosCreados() );
//        System.out.println("Solucion : ");
//        for (Nodo n: solucion) {
//            System.out.println(n);
//        }


    }
}