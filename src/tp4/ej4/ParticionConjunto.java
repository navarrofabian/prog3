package tp4.ej4;

import java.util.ArrayList;

public class ParticionConjunto {

    private ArrayList<Integer> conjunto;
    private boolean encontrado;

    public ParticionConjunto(ArrayList<Integer> conjunto) {
        this.conjunto = conjunto;
        this.encontrado = false;
    }

    public boolean particionConjunto() {
        int sumaTotal = 0;
        for (int num : conjunto) {
            sumaTotal += num;
        }

        if (sumaTotal % 2 != 0) {
            // La suma total es impar, no es posible la partición
            return false;
        }

        ArrayList<Integer> conjuntoActual = new ArrayList<>();
        backtrack(0, conjuntoActual, 0, sumaTotal / 2);
        return encontrado;
    }

    private void backtrack(int index, ArrayList<Integer> conjuntoActual, int sumaActual, int sumaObjetivo) {
        if (sumaActual == sumaObjetivo) {
            // Se encontró una partición válida
            encontrado = true;
            System.out.println("Partición encontrada: " + conjuntoActual);
            return;
        }

        if (sumaActual > sumaObjetivo || index >= conjunto.size()) {
            // Se excedió el objetivo o se recorrió todo el conjunto
            return;
        }

        // Incluir el elemento actual en el subconjunto
        conjuntoActual.add(conjunto.get(index));
        backtrack(index + 1, conjuntoActual, sumaActual + conjunto.get(index), sumaObjetivo);
        conjuntoActual.remove(conjuntoActual.size() - 1); // Deshacer el cambio

        // No incluir el elemento actual en el subconjunto
        backtrack(index + 1, conjuntoActual, sumaActual, sumaObjetivo);
    }
}