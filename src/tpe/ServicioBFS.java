package tpe;
import java.util.*;
public class ServicioBFS {
	private Grafo<?> grafo;
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	public List<Integer> bfsForest() {
		Set<Integer> visitados = new HashSet<>();
		List<List<Integer>> forest = new ArrayList<>();
		for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext(); ) {
			Integer v = it.next();
			if(!visitados.contains(v)){
				visitados.add(v);
				Queue<Integer> cola = new LinkedList<>();
				cola.add(v);
				List<Integer> arbol = new ArrayList<>();
				while(!cola.isEmpty()){
					//poll() extrae y elimina el primer elemento de la cola
					int actual = cola.poll();
					arbol.add(actual);

					for(Iterator<Integer> ite = grafo.obtenerAdyacentes(actual); ite.hasNext();){
						Integer vecino = ite.next();
						if(!visitados.contains(vecino)){
							visitados.add(vecino);
							cola.add(vecino);
						}
					}
				}
				forest.add(arbol);
			}
		}
		List<Integer> ordenDescubrimiento = new ArrayList<>();
		for(List<Integer> arbol : forest){
			ordenDescubrimiento.addAll(arbol);
		}
		return ordenDescubrimiento;
	}

}
