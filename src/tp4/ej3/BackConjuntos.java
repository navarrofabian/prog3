package tp4.ej3;
/*
ejercicio 3.
Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
combinaciones de esos números tal que la suma sea igual a M.

 */
import java.util.ArrayList;

public class BackConjuntos {
    private ArrayList<Integer> conjunto;
    private ArrayList<ArrayList<Integer>> resultados;
    private int m;

    public BackConjuntos(ArrayList<Integer> conjunto, int m) {
        this.conjunto = conjunto;
        this.resultados = new ArrayList<>();
        this.m = m;
    }

    public ArrayList<ArrayList<Integer>> bt(){
        bt(0, new ArrayList<Integer>());
        return resultados;
    }

    private void bt(int suma, ArrayList<Integer> conjuntoActual){
        //si esta vacio
        if (conjunto.size() == 0) {
            if (suma == m)
                resultados.add(new ArrayList<>(conjuntoActual));
            return;
        }

        // primer cambio
        int n = conjunto.remove(0);

        // rama en la que no agrego el valor
        bt(suma, conjuntoActual);

        // poda
        if (!poda(suma)){
            // continuo cambios
            conjuntoActual.add(n);
            suma += n;

            // rama en la que agrego el valor
            bt(suma,conjuntoActual);

            // deshago cambios
            // resto el numero de la suma
            // saco el numero del conjunto actual
            suma -= n;
            conjuntoActual.remove(Integer.valueOf(n));
        };

        // deshago primer cambio
        // agrego el numero al conjunto
        conjunto.add(0, n);
    }

    private boolean poda(int suma){
        return suma > m;
    }

}