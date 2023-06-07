package tp4.ej4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> conjunto = new ArrayList<>();
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(4);
        conjunto.add(7);
        conjunto.add(8);


        ParticionConjunto backtracking = new ParticionConjunto(conjunto);
        boolean existeParticion = backtracking.particionConjunto();

        if (!existeParticion) {
            System.out.println("No se encontró una partición válida.");
        }
    }
}

