package tp4.ej5;

import java.util.Arrays;

public class AsignacionTareas {

    private int[] tareas;
    private int m; // cantidad de procesadores
    private int[] asignacionActual;
    private int[] mejorAsignacion;
    private int menorTiempo;

    public AsignacionTareas(int[] tareas, int m) {
        this.tareas = tareas;
        this.m = m;
        this.asignacionActual = new int[tareas.length];
        this.mejorAsignacion = new int[tareas.length];
        this.menorTiempo = Integer.MAX_VALUE;
    }

    public int[] encontrarMejorAsignacion() {
        backtrack(0);
        return mejorAsignacion;
    }

    private void backtrack(int tareaActual) {
        if (tareaActual == tareas.length) {
            int tiempoTotal = calcularTiempoTotal();
            if (tiempoTotal < menorTiempo) {
                menorTiempo = tiempoTotal;
                mejorAsignacion = Arrays.copyOf(asignacionActual, asignacionActual.length);
            }
            return;
        }

        for (int i = 0; i < m; i++) {
            asignacionActual[tareaActual] = i; // asignar la tarea al procesador i
            backtrack(tareaActual + 1); // avanzar a la siguiente tarea
        }
    }

    private int calcularTiempoTotal() {
        int[] tiemposProcesadores = new int[m];
        for (int i = 0; i < tareas.length; i++) {
            int tarea = tareas[i];
            int procesador = asignacionActual[i];
            tiemposProcesadores[procesador] += tarea;
        }
        return Arrays.stream(tiemposProcesadores).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] tareas = { 4, 2, 5, 1, 3 };
        int m = 3;
        AsignacionTareas asignacion = new AsignacionTareas(tareas, m);
        int[] mejorAsignacion = asignacion.encontrarMejorAsignacion();
        System.out.println("Mejor asignación de tareas a procesadores: " + Arrays.toString(mejorAsignacion));
        System.out.println("Tiempo total de ejecución: " + asignacion.menorTiempo);
    }
}
