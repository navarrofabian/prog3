package tp4.ej7;

import java.util.ArrayList;
/*
Ejercicio 7.
Tablero mágico. Dado un tablero de tamaño n x n, construir un algoritmo que ubique (si es posible)
n*n números naturales diferentes, entre 1 y un cierto k (con k>n*n), de manera tal que la suma de
las columnas y de las filas sea igual a S.
*/
public class TableroMagico {

    private int s; // 15
    private int n; // ej n = 3
    private int k; // n * n = k; k = 9

    private ArrayList<Integer> conjuntoK;

    private void backTablero(Estado e){

        if(e.tableroCompleto()){
            if(esSolucionValida(e.getTablero(), s)){
                imprimirTablero(e.getTablero());
            }
        }
        else{
            int siguiente =  conjuntoK.remove(0); // obtengo el primero del conjunto k y lo saco

            if(e.siguienteValido(siguiente)){// poda
                e.agregarATablero(siguiente);
                backTablero(e);
            }
            conjuntoK.add(e.getUltimoTablero());//deshago cambios
        }
    }

}
