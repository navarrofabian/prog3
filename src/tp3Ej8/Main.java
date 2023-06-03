package tp3Ej8;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear el grafo y agregar vértices y arcos
        Grafo<Integer> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1, 1);
        grafo.agregarVertice(2, 2);
        grafo.agregarVertice(3, 5);
        grafo.agregarVertice(4, 3);
        grafo.agregarArco(1, 2, null);
        grafo.agregarArco(1, 3, null);
        grafo.agregarArco(2, 4, null);
        grafo.agregarArco(3, 4, null);


        Vertice<Integer> v1 = grafo.obtenerVertice(1);
        Vertice<Integer> v2 = grafo.obtenerVertice(4);

        ServicioVerticesRotulados servicio = new ServicioVerticesRotulados(grafo, v1, v2, 2);

        List<Integer> camino = servicio.caminoSinVerticesColor();
        // Imprimir el resultado
        if (camino.isEmpty()) {
            System.out.println("No se encontró un camino válido");
        } else {
            System.out.println("Camino encontrado:" + camino);
        }
    }

}
