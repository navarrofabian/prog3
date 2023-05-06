package tp3.grafos;

public interface Grafo {

    public boolean existeArco(int verticeId1, int verticeid2);
    public void agregarVertice(int verticeId);

    public void eliminarVertice(int verticeId);
}
