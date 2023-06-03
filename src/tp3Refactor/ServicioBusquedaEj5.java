package tp3Refactor;

import java.util.*;
/*
ejercicio 5
Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
con todos los vértices a partir de los cuales exista un camino en G que termine en v.

 */
public class ServicioBusquedaEj5 {

    private Grafo<?> grafo;
    private int destino;

    public ServicioBusquedaEj5(Grafo<?> grafo, int destino) {
        this.grafo = grafo;
        this.destino = destino;
    }



    public List<Integer> verticesQueTerminanEnV() {
        List<Integer> resultado = new ArrayList<>();
        for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext();) {
            Integer v = it.next();
            if (existeCaminoHaciaDestino(v)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    private boolean existeCaminoHaciaDestino(Integer origen) {
        Set<Integer> visitados = new HashSet<>();
        return dfsVisit(origen, visitados);
    }

    private boolean dfsVisit(Integer actual, Set<Integer> visitados) {
        visitados.add(actual);

        if (actual == destino) {
            return true; // Se encontro un camino hasta el destino
        }

        for (Iterator<Integer> it = grafo.obtenerAdyacentes(actual); it.hasNext();) {
            Integer ad = it.next();
            if (!visitados.contains(ad) && dfsVisit(ad, visitados)) {
                return true; // Se encontro un camino hasta el destino
            }
        }

        return false; // No se encontro un camino hasta el destino
    }
}

