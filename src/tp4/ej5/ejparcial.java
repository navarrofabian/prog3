package tp4.ej5;

public class ejparcial {

    public static final int MAXA = 20;
    public static final int MAXB = 20;
    public static final int N = 2;
    public static void main(String[]args){
        int[] arrSecInt = {-1,12,22,44,-1,22, 34,55,1,22,34,55,1,22,34,55,-1,23,34,57,-1};
        int[] arrPatron = {-1,-1,-1,-1,-1,-1,-1,-1,22, 34, 55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};
        int posIniPatron = encontrarInicio(arrPatron, 0);
        int posFinPatron = posIniPatron + 2; //encontrarFinPatron(arrPatron, posIniPatron);
        recorrerSecuencias(arrSecInt,arrPatron, posIniPatron, posFinPatron);
    }

    public static int encontrarInicio(int[]arr, int pos){
       while(pos < MAXB && arr[pos] == -1){
           pos++;
       }
       return pos;
    }
    public static int encontrarFin(int[] arr, int pos){
        while( pos < MAXB && arr[pos] != -1){
            pos++;
        }
        return pos - 1;
    }

    public static void recorrerSecuencias(int[] arrSec,int []patron, int posIPatron, int posFPatron){
        int posIni;
        int posFin = -1;
        int i = 0;
        int cantIguales = 0;
        while (i < MAXA){
            posIni = encontrarInicio(arrSec, posFin+1);
            posFin = encontrarFin(arrSec, posIni);
            boolean igual = esIgualAlPatron(posIni, posFin, posIPatron, posFPatron, arrSec, patron);
            if(igual){
                cantIguales++;
            }
            if(cantIguales > N){
                eliminarSecuencia(arrSec, posIni, posFin);
            }
            posIni = posFin;
            i++;

        }
    }

    public static void eliminarSecuencia(int [] arr, int posIni, int posFin){
        //TO DO corrimiento a izquierda
    }

    public static boolean esIgualAlPatron(int posI, int posF, int posIPatron, int posFPatron, int[]arrSec, int[] patron){
        while(posI < posF){
           if(arrSec[posI] != patron[posIPatron]){
                return false;
           }
            posIPatron++;
            posI++;
        }
        return true;
    }
}
