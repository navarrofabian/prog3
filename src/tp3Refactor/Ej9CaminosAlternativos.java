package tp3Refactor;

import java.util.*;

public class Ej9CaminosAlternativos {

    private Grafo<?> grafo;
    private int ciudad1;
    private int ciudad2;
    private Arco<?> tramoCortado;


    public Ej9CaminosAlternativos(Grafo<?> grafo, int ciudad1, int ciudad2, Arco<?> tramoCortado){
        this.grafo = grafo;
        this.ciudad1 = ciudad1;
        this.ciudad2 = ciudad2;
        this.tramoCortado = tramoCortado;
    }


    public List<List<Integer>> caminosDisponibles(){
        List<List<Integer>> resultado = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        List<Integer> camino = new ArrayList<>();
        dfs(ciudad1, resultado, visitados, camino);
        return resultado;
    }

    private void dfs(int actual, List<List<Integer>> resultado, Set<Integer> visitados, List<Integer> camino){
        visitados.add(actual);
        camino.add(actual);

        if (actual == ciudad2) {
            resultado.add(new ArrayList<>(camino));
        } else {
            for (Iterator<Integer> it = grafo.obtenerAdyacentes(actual); it.hasNext(); ) {
                int vecino = it.next();
                Arco<?> arco = grafo.obtenerArco(actual, vecino);
                if (!visitados.contains(vecino) && !arco.equals(tramoCortado)) {
                    dfs(vecino, resultado, visitados, camino);
                }
            }
        }

        camino.remove(camino.size() - 1);
        visitados.remove(actual);
    }
}
