package tp3.grafos;

import java.util.*;

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
}
