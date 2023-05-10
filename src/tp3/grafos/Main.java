package tp3.grafos;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();
        // Verificar si existe un arco
       // System.out.println(grafo.existeArco(1, 2)); // true

        // Eliminar un vértice
       // grafo.eliminarVertice(2);

        // Verificar si existe un arco después de eliminar un vértice
        //System.out.println(grafo.existeArco(1, 2)); // false

        // Agregar vértices
        /*
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        // Agregar arcos
        grafo.agregarArco(1, 2);
        grafo.agregarArco(2, 3);
        grafo.agregarArco(3, 1);
        grafo.agregarArco(2, 4);
        grafo.agregarArco(3, 5);
        grafo.agregarArco(4, 5);

        // Realizar DFS desde el vértice 1
        System.out.print("Recorrido DFS: ");
        grafo.dfs(1);
        System.out.println();

        // Realizar BFS desde el vértice 1
        System.out.print("Recorrido BFS: ");
        grafo.bfs(1);
        System.out.println();

        System.out.println();
        System.out.println("El grafo tiene ciclo: " + grafo.existeCicloDfs(1));
        */
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);
        grafo.agregarArco(0, 1);
        grafo.agregarArco(1, 2);
        grafo.agregarArco(1, 3);
        grafo.agregarArco(2, 3);
        grafo.agregarArco(2, 7);
        grafo.agregarArco(3, 4);
        grafo.agregarArco(4, 7);

        System.out.println(grafo.caminoMasLargo(0, 7));
    }
}
