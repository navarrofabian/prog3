package tp3.grafos;

public class Arco<T> {
    private int origen;
    private int destino;
    private T etiqueta;

    public Arco(int destino) {
        this.destino = destino;
    }

    public int getVerticeOrigen() {
        return origen;
    }

    public void setVerticeOrigen(int verticeOrigen) {
        this.origen = verticeOrigen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int verticeDestino) {
        this.destino = verticeDestino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }
}
