package tp2.ej5;

import tp2.ej1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeChar {
    TreeNodeChar raiz;

    public BinaryTreeChar(){

    }


    public void insert(char value) {
        this.raiz = insertRec(this.raiz, value);
    }

    private TreeNodeChar insertRec(TreeNodeChar nodoActual, char value) {
        if (nodoActual == null) {
            return new TreeNodeChar(value);
        }
        if (value < nodoActual.getChar()) {
            nodoActual.setLeft(insertRec(nodoActual.getLeft(), value));
        } else if (value > nodoActual.getChar()) {
            nodoActual.setRight(insertRec(nodoActual.getRight(), value));
        }
        return nodoActual;
    }

    public List<String> getWordsWithNVocal(int n){
        List<String> result = new ArrayList<>();
        if(this.raiz == null){
            return result;
        }
        getWordsWithNVocalRec(this.raiz, n,"", 0, result);
        return result;
    }

    private void getWordsWithNVocalRec(TreeNodeChar nodoActual, int n, String word, int numVocales, List<String> result){
        if(nodoActual == null){
            return;
        }

        String newWord = word + nodoActual.getChar();
        if(isLeaf(nodoActual) && numVocales == n){
            result.add(newWord);
        }
        else {
            char c  = Character.toLowerCase(nodoActual.getChar());
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                numVocales++;
            }
            getWordsWithNVocalRec(nodoActual.getLeft(), n, newWord, numVocales, result);
            getWordsWithNVocalRec(nodoActual.getRight(), n, newWord, numVocales, result);
        }

    }

    private boolean isLeaf(TreeNodeChar node) {
        return node.getLeft() == null && node.getRight() == null;
    }
}
