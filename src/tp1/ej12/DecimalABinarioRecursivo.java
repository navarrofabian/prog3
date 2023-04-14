package tp1.ej12;

public class DecimalABinarioRecursivo {

    public String decimalABinarioRecursivo(int decimal) {
        if (decimal == 0) {
            return "0";
        } else {
            return decimalABinarioRecursivoAux(decimal);
        }
    }

    private String decimalABinarioRecursivoAux(int decimal) {
        if (decimal == 0) {
            return "";
        } else if (decimal % 2 == 0) {
            return decimalABinarioRecursivoAux(decimal / 2) + "0";
        } else {
            return decimalABinarioRecursivoAux(decimal / 2) + "1";
        }
    }

}
