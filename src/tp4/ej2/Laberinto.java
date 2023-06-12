package tp4.ej2;

import java.util.ArrayList;

public class Laberinto {
    private Casillero  cInicial;
    private Casillero cFinal;
    private ArrayList<Casillero> mejorCamino; //solucion
    private int distanciaMasCorta;
    private final int[][] direcciones = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private Casillero[][] matrizLaberinto;

    public ArrayList<Casillero> getMejorCamino(){
        ArrayList<Casillero> caminoActual = new ArrayList<>();
        back(cInicial, caminoActual, cInicial.getValor());
        return mejorCamino;
    }

    public void back(Casillero cActual,  ArrayList<Casillero> caminoActual, int distanciaAcumulada){

        if(cInicial == cFinal){
            if(esSolucion()){
                if(distanciaAcumulada < distanciaMasCorta){
                    this.mejorCamino.addAll(caminoActual);
                }
            }
        }
        else{


            for (int[] direccion : direcciones) {
                int nuevaPosX = cActual.getPosX() + direccion[0];
                int nuevaPosY = cActual.getPosY() + direccion[1];

                if (esMovimientoValido(nuevaPosX, nuevaPosY)) {
                    Casillero siguiente = matrizLaberinto[nuevaPosX][nuevaPosY];

                    if (!caminoActual.contains(siguiente)) {
                        caminoActual.add(siguiente);
                        distanciaAcumulada += siguiente.getValor();

                        if(!poda(distanciaAcumulada)){                               // si no poda llamo al back
                            back(siguiente, caminoActual, distanciaAcumulada);       // llamo al back con siguiente
                        }
                        distanciaAcumulada -= siguiente.getValor();
                        caminoActual.remove(siguiente);
                    }
                }
            }

        }

    }
    private boolean esMovimientoValido(int posX, int posY) {
        // Verificar que las coordenadas posX y posY se encuentren dentro de los límites del laberinto
        return posX >= 0 && posX < matrizLaberinto.length && posY >= 0 && posY < matrizLaberinto[0].length;
    }


    private boolean poda(int distanciaAcumulada){
        return distanciaAcumulada > this.distanciaMasCorta;
    }

    private boolean esSolucion(){
        return true; //TO DO
    }

}
