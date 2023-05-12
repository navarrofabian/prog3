package tpe;


import java.util.*;

public class ServicioDFS {

	private Grafo<?> grafo;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	public List<Integer> dfsForest() {
		List<Integer> resultado = new ArrayList<>();
		Set<Integer> visitados = new HashSet<>();

		for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext(); ) {
			Integer v = it.next();
			if (!visitados.contains(v)) {
				dfsVisit(v, visitados, resultado);
			}
		}

		return resultado;
	}

	private void dfsVisit(Integer v, Set<Integer> visitados, List<Integer> resultado) {
		visitados.add(v);
		resultado.add(v);

		for (Iterator<Integer> it = grafo.obtenerAdyacentes(v); it.hasNext(); ) {
			Integer ad = it.next();
			if (!visitados.contains(ad)) {
				dfsVisit(ad, visitados, resultado);
			}
		}
	}
}


	/*
	public List<Integer> dfsForest() {
		List<Integer> negros = new ArrayList<>();
		List<Integer> amarillos = new ArrayList<>();
		List<Integer> resultado = new ArrayList<>();
		int tiempo = 0;

		for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext(); ) {
			Integer v = it.next();
			if (!negros.contains(v) || !amarillos.contains(v)) {
				resultado.addAll(dfsVisit(v, negros, amarillos, tiempo));
			}
		}
		return resultado;
	}

	private List<Integer> dfsVisit(Integer v, List<Integer> negros, List<Integer> amarillos, int tiempo) {
		amarillos.add(v);
		tiempo++;
		for (Iterator<Integer> it = grafo.obtenerAdyacentes(v); it.hasNext(); ) {
			Integer ad = it.next();
			if (!negros.contains(ad) || !amarillos.contains(ad)) {
				dfsVisit(ad, negros, amarillos, tiempo);
			}
		}
		negros.add(v);
		tiempo++;
		return negros;
	}
	 */


