package tp4.ej3;

import tp4.ej3.BackConjuntos;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> conjunto = new ArrayList<>();
        conjunto.add(1);
        conjunto.add(4);
        conjunto.add(3);
        conjunto.add(7);
        int m = 7;

        BackConjuntos backtracking = new BackConjuntos(conjunto, m);
        ArrayList<ArrayList<Integer>> resultados = backtracking.bt();

        // Imprimir los resultados
        for (ArrayList<Integer> resultado : resultados) {
            System.out.println(resultado);
        }
    }
}
