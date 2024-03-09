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


        System.out.println("\nSolucion Aplicando BusquedaProfundiad:\n");
        EstrategiaBusqueda buscador = new EstrategiaProfundidad();
        solucion = buscador.soluciona(cuadrado);
        System.out.println("\nSolucion: ");
        for (Nodo n: solucion) {
            System.out.println(n);
        }


        ProblemaCuadradoMagico.EstadoCuadrado estadoInicial2  = new ProblemaCuadradoMagico.EstadoCuadrado(matriz2);
        ProblemaBusqueda cuadrado2 = new ProblemaCuadradoMagico(estadoInicial2);
        System.out.println("\nSolucion cuadrado 2 Aplicando BusquedaAEstrella: \n");
        EstrategiaBusquedaInformada buscador2 = new EstrategiaAEstrella();
        Estado solucion2 = buscador2.soluciona(cuadrado2, new HeuristicaCuadradoMagico());
        System.out.println("\nSolucion: " + solucion2);

        ProblemaCuadradoMagico.EstadoCuadrado estadoInicial3  = new ProblemaCuadradoMagico.EstadoCuadrado(matriz3);
        ProblemaBusqueda cuadrado3 = new ProblemaCuadradoMagico(estadoInicial3);
        System.out.println("\nSolucion cuadrado 3 Aplicando BusquedaAEstrella: \n");
        EstrategiaBusquedaInformada buscador3 = new EstrategiaAEstrella();
        Estado solucion3 = buscador3.soluciona(cuadrado3, new HeuristicaCuadradoMagico());
        System.out.println("\nSolucion: " + solucion3);

    }
}