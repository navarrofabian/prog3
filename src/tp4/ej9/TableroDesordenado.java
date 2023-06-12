package tp4.ej9;


import java.util.ArrayList;

public class TableroDesordenado {

    private int posInicial;
    private int sizeTablero;
    private ArrayList<Estado> estados;
    private int k;


    public void backTablero(Estado e, Posicion posActual){

        if(e.tableroOrdenado()){
            if(e.ultimaCasillaLibre()){
                imprimirSolucion(e);
            }
        }

        else{
            Movimiento movSiguiente = e.siguiente();
            int nroHijo = 1;

            while(intercambiosHijos(nroHijo, e, movSiguiente)){

                if(e.esFactible(movSiguiente) && !estados.contains(e)){
                    e.vaciarCasilla(movSiguiente.getPos());
                    movSiguiente.setPos(posActual);
                    estados.add(e);
                    backTablero(e, movSiguiente.getPos());
                }
                nroHijo++;
            }
        }
    }
}
