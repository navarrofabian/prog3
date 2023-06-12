package tp4.ej6;

import tp4.ej9.Movimiento;

public class CaballoAtila {

    void backCaballoAtila(Estado e, int nroPisada){

        if(!e.hayMovimientos()){
            if((nroPisada = e.cantPisadas() && (e.vecinaOrigen()))){
                imprimirSolucion(e);
            }
        }

        else{
            Movimiento movSiguiente;
            int nroHijo = 1;
            int nrohijo=1;
            while ( hijos(nrohijo, e, movSgte))
            { if ( e.esFactible(movSgte) )
                BackAtila( e.aplicarMov(movSgte), nroPisada+1);
                nrohijo++;}
        }
    }
}
