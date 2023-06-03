package tp3Ej8;

import java.util.ArrayList;

public class Vertice<T> {
    private int id;
    private ArrayList<Arco<T>> arcos;

    private T valor;

    public Vertice(int id, T valor) {
        this.id = id;
        this.arcos = new ArrayList<>();
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void agregarArco(Arco<T> arco) {
        arcos.add(arco);
    }

    public boolean borrarArco(int verticeDestino) {
        for (Arco<T> arco : arcos) {
            if (arco.getVerticeDestino() == verticeDestino) {
                arcos.remove(arco);
                return true;
            }
        }
        return false;
    }

    public boolean contieneArcoConDestino(int verticeDestino) {
        for (Arco<T> arco : arcos) {
            if (arco.getVerticeDestino() == verticeDestino) {
                return true;
            }
        }
        return false;
    }

    public Arco<T> getArcoConDestino(int verticeDestino) {
        for (Arco<T> arco : arcos) {
            if (arco.getVerticeDestino() == verticeDestino) {
                return arco;
            }
        }
        return null;
    }

    public ArrayList<Integer> getAdyacentes() {
        ArrayList<Integer> adyacentes = new ArrayList<>();
        for (Arco<T> arco : arcos) {
            adyacentes.add(arco.getVerticeDestino());
        }
        return adyacentes;
    }

    public ArrayList<Arco<T>> getArcos() {
        return arcos;
    }
}
