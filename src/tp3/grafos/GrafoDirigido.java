package tp3.grafos;

import java.util.*;
import java.util.Queue;

public class GrafoDirigido implements Grafo{

    private HashMap<Integer, Vertice> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }


    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1)) {
            return false;
        }

        Vertice vertice1 = vertices.get(verticeId1);
        for (Arco arco : vertice1.getArcos()) {
            if (arco.getDestino() == verticeId2) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void agregarVertice(int verticeId) {
        vertices.put(verticeId, new Vertice(verticeId, new LinkedList<>()));
    }

    public void agregarArco(int verticeOrigen, int verticeDestino) {
        if (!vertices.containsKey(verticeOrigen) || !vertices.containsKey(verticeDestino)) {
            System.out.println("Uno o ambos vértices no existen en el grafo.");
        }
        else {
            Vertice vertice1 = vertices.get(verticeOrigen);
            Arco arco = new Arco(verticeDestino);
            vertice1.getArcos().add(arco);
        }
    }


    @Override
    public void eliminarVertice(int verticeId) {
        if(!vertices.containsKey(verticeId)){
            System.out.println("El vertice :" + verticeId + " no existe");
        }
        else{
            for (Vertice vertice : vertices.values()) {
                Iterator<Arco> iteradorArcos = vertice.getArcos().iterator();
                while (iteradorArcos.hasNext()) {
                    Arco arco = iteradorArcos.next();
                    if (arco.getDestino() == verticeId) {
                        iteradorArcos.remove();
                    }
                }
            }
            // Eliminar el vértice del mapa
            vertices.remove(verticeId);
        }
    }

    public void dfs(int verticeId) {
        Set<Integer> visitados = new HashSet<Integer>();
        dfsAux(verticeId, visitados);
    }

    private void dfsAux(int verticeId, Set<Integer> visitados) {
        visitados.add(verticeId);
        System.out.print(verticeId + " ");

        Vertice vertice = vertices.get(verticeId);
        for (Arco arco : vertice.getArcos()) {
            int adyacente = arco.getDestino();
            if (!visitados.contains(adyacente)) {
                dfsAux(adyacente, visitados);
            }
        }
    }

    // Algoritmo BFS (Breadth-First Search)
    public void bfs(int verticeId) {
        // Cola para almacenar los vértices por visitar
        Queue<Integer> cola = new LinkedList<>();
        // Conjunto para almacenar los vértices visitados
        Set<Integer> visitados = new HashSet<>();

        // Se marca el vértice inicial como visitado y se añade a la cola
        visitados.add(verticeId);
        cola.add(verticeId);

        while (!cola.isEmpty()) {
            // Se obtiene el siguiente vértice a visitar de la cola
            int actual = cola.poll();
            System.out.print(actual + " ");

            // Se recorren los vértices adyacentes al actual
            Vertice vertice = vertices.get(actual);
            for (Arco arco : vertice.getArcos()) {
                int adyacente = arco.getDestino();
                if (!visitados.contains(adyacente)) {
                    // Si el vértice adyacente no ha sido visitado, se marca como visitado y se añade a la cola
                    visitados.add(adyacente);
                    cola.add(adyacente);
                }
            }
        }
    }

    public boolean existeCicloDfs(int verticeId) {
        Set<Integer> visitados = new HashSet<Integer>();
        Set<Integer> recorrido = new HashSet<Integer>();
        boolean tieneCiclo = false;
        tieneCiclo = existeCicloAux(verticeId, visitados, recorrido, tieneCiclo);
        return tieneCiclo;
    }

    private boolean existeCicloAux(int verticeId, Set<Integer> visitados, Set<Integer> recorrido, boolean tieneCiclo) {
        visitados.add(verticeId);
        recorrido.add(verticeId);

        Vertice vertice = vertices.get(verticeId);
        for (Arco arco : vertice.getArcos()) {
            int adyacente = arco.getDestino();
            if (!visitados.contains(adyacente)) {
                tieneCiclo = existeCicloAux(adyacente, visitados, recorrido, tieneCiclo);
            } else if (recorrido.contains(adyacente)) {
                tieneCiclo = true;
            }
        }

        recorrido.remove(verticeId);
        return tieneCiclo;
    }

    public List<Integer> caminoMasLargo(int i, int j) {
        List<Integer> caminoActual = new ArrayList<>();
        List<Integer> caminoMax = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        dfsCaminoMasLargo(i, j, visitados, caminoActual, caminoMax);
        return caminoMax;
    }

    private void dfsCaminoMasLargo(int actual, int objetivo, Set<Integer> visitados, List<Integer> caminoActual, List<Integer> caminoMax) {
        visitados.add(actual);
        caminoActual.add(actual);

        if (actual == objetivo && caminoActual.size() > caminoMax.size()) {
            caminoMax.clear();
            caminoMax.addAll(caminoActual);
        } else {
            Vertice vertice = vertices.get(actual);
            for (Arco arco : vertice.getArcos()) {
                int adyacente = arco.getDestino();
                if (!visitados.contains(adyacente)) {
                    dfsCaminoMasLargo(adyacente, objetivo, visitados, caminoActual, caminoMax);
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
        visitados.remove(actual);
    }

}
