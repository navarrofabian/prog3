package tp3Ej8;

import java.util.*;

public class ServicioVerticesRotulados{

    private Grafo<?> grafo;
    private Vertice v1;
    private Vertice v2;
    private int color;

    public ServicioVerticesRotulados(Grafo<?> grafo, Vertice v1, Vertice v2, int color){
        this.grafo = grafo;
        this.v1 = v1;
        this.v2 = v2;
        this.color = color;
    }

    public List<Integer> caminoSinVerticesColor() {
        List<Integer> resultado = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        dfs(v1.getId(), visitados, resultado);
        return resultado;

    }

    private void dfs(int verticeId, Set<Integer> visitados, List<Integer> resultado) {
        visitados.add(verticeId);
        resultado.add(verticeId);

        if (verticeId == v2.getId()) {
            return;
        }

        for (Iterator<Integer> it = grafo.obtenerAdyacentes(verticeId); it.hasNext(); ) {
            Integer adyacenteId = it.next();

            if (!visitados.contains(adyacenteId) && (int) grafo.obtenerVertice(adyacenteId).getValor() != color) {
                dfs(adyacenteId, visitados, resultado);
                if (resultado.get(resultado.size() - 1) == v2.getId()) {
                    return;
                }
            }
        }

        resultado.remove(resultado.size() - 1);
        visitados.remove(verticeId);
    }


}
