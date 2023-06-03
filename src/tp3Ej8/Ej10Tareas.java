package tp3Ej8;

import java.util.*;

public class Ej10Tareas {

    private Grafo<?> grafo;

    public Ej10Tareas(Grafo<?> grafo){
        this.grafo = grafo;
    }

    public List<Integer> secuenciaTareasMayorTiempo() {
        List<Integer> resultado = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        List<Integer> camino = new ArrayList<>();

        for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext(); ) {
            Integer tarea = it.next();
            if (!visitados.contains(tarea)) {
                dfs(tarea, visitados, camino, resultado);
            }
        }

        return resultado;
    }

    private void dfs(int tarea, Set<Integer> visitados, List<Integer> camino, List<Integer> resultado) {
        visitados.add(tarea);
        camino.add(tarea);

        if (grafo.obtenerAdyacentes(tarea).hasNext()) {
            for (Iterator<Integer> it = grafo.obtenerAdyacentes(tarea); it.hasNext(); ) {
                int tareaSiguiente = it.next();
                dfs(tareaSiguiente, visitados, camino, resultado);
            }
        } else {
            if (camino.size() > resultado.size()) {
                resultado.clear();
                resultado.addAll(camino);
            }
        }

        camino.remove(camino.size() - 1);
        visitados.remove(tarea);
    }
}
