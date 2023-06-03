package tp3Refactor;

import java.util.*;

public class Ej7Ciudad {

    private Grafo<?> grafo;
    private int esquina1;
    private int esquina2;

    public Ej7Ciudad(Grafo<?> grafo, int esquina1, int esquina2){
        this.grafo = grafo;
        this.esquina1 = esquina1;
        this.esquina2 = esquina2;
    }

    public List<Integer> caminoMasCorto() {
        List<Integer> resultado = new ArrayList<>();
        //creo una lista de padres para guardar el recorrido
        Map<Integer, Integer> padres = new HashMap<>();
        Set<Integer> visitados = new HashSet<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(esquina1);

        boolean encontrado = false;
        while (!cola.isEmpty() && !encontrado) {
            Integer actual = cola.poll();
            visitados.add(actual);

            for (Iterator<Integer> it = grafo.obtenerAdyacentes(actual); it.hasNext(); ) {
                Integer adyacente = it.next();

                if (!visitados.contains(adyacente)) {
                    //agrego a la lista el vertice adyacente(hijo) y el actual(padre)
                    padres.put(adyacente, actual);
                    cola.add(adyacente);

                    if (adyacente == esquina2) {
                        encontrado = true;
                        break;
                    }
                }
            }
        }

        if (encontrado) {
            Integer actual = esquina2;
            while (actual != esquina1) {
                resultado.add(actual);
                //obtengo el valor vinculado al valor actual en la lista padres
                actual = padres.get(actual);
            }
            //agrego el ultimo valor
            resultado.add(esquina1);
            //invierto la lista antes de retornarla
            Collections.reverse(resultado);
        }

        return resultado;
    }

}
