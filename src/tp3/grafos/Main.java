package tp3.grafos;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();

        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        // Agregar arcos
        grafo.agregarArco(1, 2);
        grafo.agregarArco(1, 3);
        grafo.agregarArco(2, 3);

        // Verificar si existe un arco
        System.out.println(grafo.existeArco(1, 2)); // true

        // Eliminar un vértice
        grafo.eliminarVertice(2);

        // Verificar si existe un arco después de eliminar un vértice
        System.out.println(grafo.existeArco(1, 2)); // false
    }
}
