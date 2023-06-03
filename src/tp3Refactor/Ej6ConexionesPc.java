package tp3Refactor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ej6ConexionesPc {

    private Grafo<?> grafo;
    private int pcA;
    private int pcB;
    private int pcI;

    public Ej6ConexionesPc(Grafo<?> grafo, int pcA, int pcB, int pcI) {
        this.grafo = grafo;
        this.pcA = pcA;
        this.pcB = pcB;
        this.pcI = pcI;
    }


    public boolean existeConexion() {
        Set<Integer> visitados = new HashSet<>();
        return dfs(pcA, visitados);
    }

    private boolean dfs(int actual, Set<Integer> visitados) {
        visitados.add(actual);

        if (actual == pcB) {
            return true; // Se encontró una conexión entre pcA y pcB
        }

        for (Iterator<Integer> it = grafo.obtenerAdyacentes(actual); it.hasNext(); ) {
            Integer ad = it.next();
            if (ad != pcI && !visitados.contains(ad)) {
                if (dfs(ad, visitados)) {
                    return true; // Se encontró una conexión a través de este vértice
                }
            }
        }

        return false; // No se encontró una conexión entre pcA y pcB
    }


}
