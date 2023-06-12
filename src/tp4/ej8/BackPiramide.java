package tp4.ej8;

import java.util.ArrayList;

public class BackPiramide {

    private int b; // b = 3
    private int k; // k = 15
    private ArrayList<Integer> conjuntoK; // ej conjuntoK= { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}

    public void back(Estado e){
        if(e.piramideCompleta()){ // estado final
            if(e.solucionValida()){ //numeros igual a su base

            }
        }
        else{
            int siguiente = conjuntoK.remove(0);
            if(e.lugarValido(siguiente)){ // si no se sale de la piramide y no es mayor
                e.agregarAPiramide(siguiente);
                back(e);
            }
            conjuntoK.add(e.getUltimoPiramide());
        }
    }
}
