package tp1.ej9;

public class Palindroma {

    public boolean esPalindromaRecursiva(String cadena) {
        if (cadena.length() == 0 || cadena.length() == 1) {
            return true;
        } else {
            if (cadena.charAt(0) == cadena.charAt(cadena.length() - 1)) {
                return esPalindromaRecursiva(cadena.substring(1, cadena.length() - 1));
            } else {
                return false;
            }
        }
    }

}
