package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, ArrayList<Arco<T>>> vertices;
	private int cantArcos;
	public GrafoDirigido(){
		vertices = new HashMap<Integer, ArrayList<Arco<T>>>();
		int cantArcos = 0;

	}

	@Override
	public void agregarVertice(int verticeId) {
		if(!vertices.containsKey(verticeId)){// sera O(n) ??
			vertices.put(verticeId, new ArrayList<Arco<T>>());//O(1)
		}
		// TODO Auto-generated method stub
	}

	@Override
	public void borrarVertice(int verticeId) {
		for(Integer i : vertices.keySet()){//O(n) porque recorro toda la lista de vertices, donde n, son los vertices
			borrarArco(i,verticeId);//(O(k) donde k, son los arcos de cada vertice
		}
		this.cantArcos = (this.cantArcos - vertices.get(verticeId).size());
		vertices.remove(verticeId);//O(n)
		//
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){//O(n)*2
			Arco<T> ar = new Arco<T>(verticeId1,verticeId2,etiqueta);
			if(!vertices.get(verticeId1).contains(ar)){//O(n) donde n es la cantidad de arcos que tiene el VerticeId1
				this.cantArcos ++;
				vertices.get(verticeId1).add(ar);
			}
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){//O(n)*2, donde n es cantidad de vertices
			Arco<T> ar = new Arco<T>(verticeId1,verticeId2,null);

			if(vertices.get(verticeId1).remove(ar)){//O(k), donde k es la cantidad de arcos que tiene de origen el verticeId1
				cantArcos--;
			}
		}
		//

	}

	@Override
	public boolean contieneVertice(int verticeId) {

		// TODO Auto-generated method stub
		return vertices.containsKey(verticeId);//O(n) donde n es la cantidad de vertices de la tabla.
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){//O(n)*2 para cada containsKey
			Arco<T> ar = new Arco<T>(verticeId1, verticeId2, null);
			return vertices.get(verticeId1).contains(ar);//O(k) donde k es la cantidad de arcos que tiene el verticeId1
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		for (Arco<T> i : vertices.get(verticeId1)) {//O(k) donde k es la cantidad de arcos que tiene verticeId1
			if(i.getVerticeDestino() == verticeId2)//O(1)
				return i;
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return vertices.size();//O(1) porque hashmap internamente guarda la info
	}

	@Override
	public int cantidadArcos() {

		// Comp O(1)
		return cantArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer i: vertices.keySet()) {//O(n) donde n son la cantidad de vertices
			list.add(i);
		}

		return list.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(Arco<T> i : vertices.get(verticeId)) {//O(n) donde n es la cantidad de arcos del verticeId
			ar.add(i.getVerticeDestino());//O(1) para arrayList
		}
		return ar.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> ar = new ArrayList<Arco<T>>();
		for(ArrayList<Arco<T>> i: vertices.values()) {//O(n) donde n es la cantidad de vertices
			ar.addAll(i);//+O(k) donde k es la cantidad de arcos que tiene cada vertices.
		}
		//queda en complejidad O(n)
		return ar.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return vertices.get(verticeId).iterator();//O(1) get() en hash tiene complejidad O(1)
		//return null;
	}

}