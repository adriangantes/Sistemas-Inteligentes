package es.udc.sistemasinteligentes.ej2;

import es.udc.sistemasinteligentes.Accion;
import es.udc.sistemasinteligentes.Estado;
import es.udc.sistemasinteligentes.ProblemaBusqueda;

import java.util.ArrayList;

public class ProblemaCuadradoMagico extends ProblemaBusqueda  {

    public static class EstadoCuadrado extends Estado {
        private final int [][] matriz;
        private final int tam;

        public EstadoCuadrado(int[][] matriz){
            this.tam = matriz.length;
            this.matriz = matriz;
        }

        public int getTam() {
            return tam;
        }

        public boolean numNoExistente (int accion){ //comprueba si el num está en la matriz
            for (int i = 0; i < tam; i++) {
                for (int j = 0; j < tam; j++) {
                    if(matriz[i][j] == accion)
                        return false;
                }
            }
            return  true;
        }

        private int[][] cloneMatrix(int[][] matrix, int tam ){
            int [][] aux  = new int[tam][tam];
            for (int i = 0; i < tam ; i++) {
                for (int j = 0; j < tam ; j++) {
                    aux[i][j] = matrix[i][j];
                }
            }
            return aux;
        }

        public EstadoCuadrado addAccion(int accion)  {
            int[][] aux = cloneMatrix(matriz,tam);
            for (int i = 0; i < this.tam; i++) {
                for (int j = 0; j < this.tam; j++) {
                    if(aux[i][j] == 0){
                        aux[i][j] = accion;
                        return new EstadoCuadrado(aux);
                    }
                }
            }
            return new EstadoCuadrado(aux);
        }

        public int getColSum(int col){
            int suma = 0;
            for (int i = 0; i <tam ; i++) {
                suma += matriz[i][col];
            }
            return suma;
        }

        public int getRowSum(int row){
            int suma = 0;
            for (int i = 0; i <tam ; i++) {
                suma += matriz[row][i];
            }
            return suma;
        }
        // Devuelve la suma de la diagonal
        public int getDiagSum(){
            int suma = 0;
            for (int i = 0; i <tam ; i++) {
                suma += matriz[i][i];
            }
            return suma;
        }

        public int getInvDiagSum(){
            int suma = 0;
            int j = 0;
            for (int i = tam-1; i >= 0 ; i--) {
                suma += matriz[i][j];
                j++;
            }
            return suma;
        }

        public int[][] getMAtrix(){
            return matriz;
        }

        @Override
        public String toString() {
            StringBuilder aux = new StringBuilder();
            for (int[] ints : matriz) {
                aux.append("[ ");
                for (int anInt : ints) {
                    aux.append(anInt + " ");
                }
                aux.append("],");
            }
            return aux.toString();
        }

        @Override
        public boolean equals(Object obj) {
            boolean equals = true;
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;

            EstadoCuadrado objetoActual = (EstadoCuadrado) obj;

            if(matriz.length != objetoActual.matriz.length) return false;
            if(matriz[0].length != objetoActual.matriz[0].length) return false;

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if(matriz[i][j] != objetoActual.matriz[i][j]) equals = false;
                }
            }
            return equals;
        }

        @Override
        public int hashCode() {
            return 31 * matriz.hashCode();
        }

    }

    public static class AccionCuadrado extends Accion {

        private int accion;

        public AccionCuadrado(int accion) {
            this.accion = accion;
        }

        @Override
        public String toString() {
                return "Add " + accion;
        }

        public boolean esAplicable(Estado es) {
            EstadoCuadrado esMag = (EstadoCuadrado) es;
            int tamMatriz = esMag.getTam();
            if(accion <= 0)
                return false;
            if(accion > tamMatriz * tamMatriz)
                return false;
            return esMag.numNoExistente(accion);
        }

        public Estado aplicaA(Estado es) throws Exception {
            EstadoCuadrado esMag = (EstadoCuadrado) es;
            if(esAplicable(es))
                return esMag.addAccion(accion);
            else
                return esMag;
        }

    }

    public ProblemaCuadradoMagico(EstadoCuadrado estadoInicial) {
        super(estadoInicial);
    }

    @Override
    public boolean esMeta(Estado es) {
        EstadoCuadrado esMag = (EstadoCuadrado) es;
        int tamMatriz = esMag.getTam();
        int magicNumber = (tamMatriz * (tamMatriz*tamMatriz + 1))/2;

        for (int i = 0; i < tamMatriz; i++) {
            if(esMag.getColSum(i) != magicNumber || esMag.getRowSum(i) != magicNumber )
                return false;
        }

        return esMag.getDiagSum() == magicNumber && esMag.getInvDiagSum() == magicNumber;
    }

    @Override
    public Accion[] acciones(Estado es) {
        ArrayList<Accion> listAcciones = new ArrayList<>();
        EstadoCuadrado esMag = (EstadoCuadrado) es;
        int tamMatriz = esMag.getTam();
        AccionCuadrado action;
        for (int i = 1; i <= tamMatriz* tamMatriz; i++) { //aquí elige qué número introducir en el cuadrado
            if(esMag.numNoExistente(i)) {
                action = new AccionCuadrado(i);
                listAcciones.add(action);
            }
        }
        return listAcciones.toArray(new Accion[0]);
    }

}

