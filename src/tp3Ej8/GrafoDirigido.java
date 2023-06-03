package tp3Ej8;

		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, Vertice<T>> vertices;
	private int cantArcos;

	public GrafoDirigido() {
		vertices = new HashMap<Integer, Vertice<T>>();
		cantArcos = 0;
	}

	@Override
	public void agregarVertice(int verticeId,  T valor) {
		if (!vertices.containsKey(verticeId)) {
			vertices.put(verticeId, new Vertice<T>(verticeId, valor));
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if (!vertices.containsKey(verticeId)) {
			return;
		}

		Vertice<T> vertice = vertices.get(verticeId);

		for (Arco<T> arco : vertice.getArcos()) {
			borrarArco(verticeId, arco.getVerticeDestino());
		}

		cantArcos -= vertice.getArcos().size();
		vertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
			Vertice<T> vertice1 = vertices.get(verticeId1);
			Vertice<T> vertice2 = vertices.get(verticeId2);

			if (!vertice1.contieneArcoConDestino(verticeId2)) {
				Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
				vertice1.agregarArco(arco);
				cantArcos++;
			}
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
			Vertice<T> vertice1 = vertices.get(verticeId1);
			if (vertice1.borrarArco(verticeId2)) {
				cantArcos--;
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
			Vertice<T> vertice = vertices.get(verticeId1);
			return vertice.contieneArcoConDestino(verticeId2);
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (vertices.containsKey(verticeId1)) {
			Vertice<T> vertice = vertices.get(verticeId1);
			return vertice.getArcoConDestino(verticeId2);
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		return cantArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if (vertices.containsKey(verticeId)) {
			Vertice<T> vertice = vertices.get(verticeId);
			return vertice.getAdyacentes().iterator();
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos = new ArrayList<Arco<T>>();
		for (Vertice<T> vertice : vertices.values()) {
			arcos.addAll(vertice.getArcos());
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		if (vertices.containsKey(verticeId)) {
			Vertice<T> vertice = vertices.get(verticeId);
			return vertice.getArcos().iterator();
		}
		return null;
	}

	@Override
	public Vertice<T> obtenerVertice(int verticeId) {
		if (vertices.containsKey(verticeId)) {
			return vertices.get(verticeId);
		}
		return null;
	}
}
