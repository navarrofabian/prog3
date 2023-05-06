package tp3.grafos;

import java.util.HashMap;
import java.util.LinkedList;

public class Vertice {

    private int verticeId;
    private LinkedList<Arco>arcos;

    //private HashMap<Integer, Arco> arcos;

    public Vertice(int verticeId, LinkedList<Arco> arcos) {
        this.verticeId = verticeId;
        this.arcos = arcos;
    }

    public int getVerticeId() {
        return verticeId;
    }

    public LinkedList<Arco> getArcos() {
        return arcos;
    }

}
