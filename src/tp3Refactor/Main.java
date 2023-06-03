package tp3Refactor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //GrafoDirigido<String> grafo = new GrafoDirigido<>();
        Grafo<Integer> grafo = new GrafoDirigido<>();
        // Crear el grafo

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
        grafo.agregarVertice(12);
        grafo.agregarVertice(13);
        grafo.agregarVertice(1111);
          /*
        grafo.agregarArco(1, 2, 3);
        grafo.agregarArco(1, 3, 4);
        grafo.agregarArco(2, 4, 2);
        grafo.agregarArco(2, 7, 3);
        grafo.agregarArco(2, 6, 3);
        grafo.agregarArco(3, 5, 1);
        grafo.agregarArco(3, 6, 7);
        grafo.agregarArco(4, 9, 3);
        grafo.agregarArco(4, 5, 5);
        grafo.agregarArco(5, 9, 3);
        grafo.agregarArco(5, 3, 3);
        grafo.agregarArco(5, 11, 3);
        grafo.agregarArco(6, 10, 3);
        grafo.agregarArco(6, 7, 8);
        grafo.agregarArco(7, 3, 3);
        grafo.agregarArco(7, 8, 9);
        grafo.agregarArco(7, 4, 3);

        grafo.agregarArco(12, 13, 3);



        // Ej5
        int destino = 5;
        ServicioBusquedaEj5 servicio = new ServicioBusquedaEj5(grafo, destino);

        // Obtener los vértices que terminan en el vértice destino
        List<Integer> verticesTerminanEnV = servicio.verticesQueTerminanEnV();

        // Imprimir los resultados
        System.out.println(verticesTerminanEnV);



        grafo.agregarArco(1, 2, 3);
        grafo.agregarArco(1, 3, 3);
        grafo.agregarArco(2, 4, 3);
        grafo.agregarArco(3, 4, 3);
        grafo.agregarArco(4, 5, 3);

        // Crear instancia de Ej6ConexionesPc
        Ej6ConexionesPc ej6 = new Ej6ConexionesPc(grafo, 1, 5, 3);

        // Verificar si existe conexión
        boolean resultado = ej6.existeConexion();

        // Imprimir resultado
            System.out.println("existe conexión = " + resultado);
            */

        /*
        grafo.agregarArco(1, 2, 3);
        grafo.agregarArco(1, 3, 3);
        grafo.agregarArco(2, 4, 3);
        grafo.agregarArco(3, 4, 3);
        grafo.agregarArco(4, 5, 3);

        Ej7Ciudad camino = new Ej7Ciudad(grafo, 1, 4);

        System.out.println("el camino mas corto es " + camino.caminoMasCorto());
         */

        int buenosAires = 1;
        int lasFlores = 2;
        int rauch = 3;
        int tandil = 4;
        int ayacucho = 5;

        // Agregar arcos al grafo
        grafo.agregarArco(buenosAires, lasFlores, null);
        grafo.agregarArco(buenosAires, ayacucho, null);
        grafo.agregarArco(ayacucho, rauch, null);
        grafo.agregarArco(lasFlores, rauch, null);
        grafo.agregarArco(rauch, tandil, null);


        Arco<String> tramoCortado = new Arco<>(lasFlores, rauch, null);

        Ej9CaminosAlternativos caminosAlternativos = new Ej9CaminosAlternativos(grafo, buenosAires, tandil, tramoCortado);

        // Obtener caminos disponibles
        List<List<Integer>> caminos = caminosAlternativos.caminosDisponibles();
        System.out.println("Caminos disponibles desde Buenos Aires a Tandil:");
        for (List<Integer> camino : caminos) {
            System.out.println(camino);
        }
    }
}
