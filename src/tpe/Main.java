package tpe;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear el grafo
        Grafo<Integer> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);
        grafo.agregarVertice(8);
        grafo.agregarVertice(9);
        grafo.agregarVertice(10);
        grafo.agregarVertice(11);

        grafo.agregarArco(1, 2, 3);
        grafo.agregarArco(1, 3, 4);
        grafo.agregarArco(2, 4, 2);
        grafo.agregarArco(3, 5, 1);
        grafo.agregarArco(4, 5, 5);
        grafo.agregarArco(3, 6, 7);
        grafo.agregarArco(6, 7, 8);
        grafo.agregarArco(7, 8, 9);
        grafo.agregarArco(8, 5, 3);
        grafo.agregarArco(7, 3, 3);

        grafo.agregarArco(9, 10, 3);
        grafo.agregarArco(10, 11, 3);


        //BFS FOREST
        ServicioBFS servicioBFS = new ServicioBFS(grafo);
        List<Integer> ordenDescubrimiento = servicioBFS.bfsForest();
        System.out.println("Orden de descubrimiento BFS:" + ordenDescubrimiento );
        System.out.println(" ");

        //DFS FOREST
        ServicioDFS servicio = new ServicioDFS(grafo);
        List<Integer> resultado = servicio.dfsForest();
        System.out.println("Orden de descubrimiento DFS:" + resultado );
        System.out.println(" ");


        //SERVICIO CAMINOS
        int origen = 1;
        int destino = 5;
        int limite = 5;
        ServicioCaminos servicioCaminos = new ServicioCaminos(grafo, origen, destino, limite);

        List<List<Integer>> caminos = servicioCaminos.caminos();
        System.out.println("Caminos encontrados:");
        for (List<Integer> camino : caminos) {
            System.out.println(camino);
        }
    }
}
