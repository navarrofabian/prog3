package tpe;

import java.util.*;

public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;

	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}

	public List<List<Integer>> caminos() {
		List<List<Integer>> caminos = new ArrayList<>();
		List<Integer> caminoActual = new ArrayList<>();
		Set<Arco<?>> arcosVisitados = new HashSet<>();
		dfsCaminos(origen, destino, lim, caminoActual, caminos, arcosVisitados);

		return caminos;
	}

	private void dfsCaminos(int actual, int destino, int lim, List<Integer> caminoActual, List<List<Integer>> caminos, Set<Arco<?>> arcosVisitados) {
		caminoActual.add(actual);

		if (actual == destino) {
			caminos.add(new ArrayList<>(caminoActual));
		} else if (caminoActual.size() <= lim) { // Verificar límite de arcos

			for (Iterator<Integer> it = grafo.obtenerAdyacentes(actual); it.hasNext(); ) {
				int ad = it.next();
				Arco<?> arco = grafo.obtenerArco(actual, ad);
				if (!arcosVisitados.contains(arco)) { //revisar && !visitados.contains(vecino)
					arcosVisitados.add(arco); // Marcar el arco como visitado
					dfsCaminos(ad, destino, lim, caminoActual, caminos, arcosVisitados);
					arcosVisitados.remove(arco); // Sacar el arco para explorar otras opciones
				}
			}
		}
		caminoActual.remove(caminoActual.size() - 1);
	}

}
