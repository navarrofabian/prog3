package tp3.grafos;

import java.util.Iterator;

public interface Grafo<T> {

    public boolean existeArco(int verticeId1, int verticeid2);
    public void agregarVertice(int verticeId);

    public void eliminarVertice(int verticeId);

}
