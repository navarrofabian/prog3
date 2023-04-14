package tp1.ej9;

public class Main {
    public static void main(String[] args) {
        String str1 = "reconocer";
        String str2 = "hola";
        String str3 = "anilina";

        Palindroma pal = new Palindroma();
        System.out.println(pal.esPalindromaRecursiva(str1)); // true
        System.out.println(pal.esPalindromaRecursiva(str2)); // false
        System.out.println(pal.esPalindromaRecursiva(str3)); // true
    }
}