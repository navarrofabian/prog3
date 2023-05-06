package tp3.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GrafoNoDirigido implements Grafo {

    private HashMap<Integer, Vertice> vertices;

    public GrafoNoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            Vertice vertice = new Vertice(verticeId, new LinkedList<Arco>());
            vertices.put(verticeId, vertice);
        }
    }

    @Override
    public void eliminarVertice(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            return;
        }

        // Eliminar arcos que inciden en el vértice
        Vertice vertice = vertices.get(verticeId);
        for (Arco arco : vertice.getArcos()) {
            int destino = arco.getDestino();
            Vertice verticeDestino = vertices.get(destino);
            verticeDestino.getArcos().removeIf(a -> a.getDestino() == verticeId);
        }

        // Eliminar el vértice
        vertices.remove(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            return false;
        }

        Vertice vertice1 = vertices.get(verticeId1);
        Vertice vertice2 = vertices.get(verticeId2);

        for (Arco arco : vertice1.getArcos()) {
            if (arco.getDestino() == verticeId2) {
                return true;
            }
        }

        for (Arco arco : vertice2.getArcos()) {
            if (arco.getDestino() == verticeId1) {
                return true;
            }
        }

        return false;

    }
}
