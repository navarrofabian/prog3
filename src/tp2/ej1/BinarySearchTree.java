package tp2.ej1;
/*
Ejercicio 1.
Implemente la estructura de Árbol Binario para búsquedas.
Métodos:
● Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(), void insert(Integer),
boolean delete(Integer), int getHeight(), void printPosOrder(), void printPreOrder(), void
printInOrder(), List getLongestBranch(), List getFrontera(), Integer getMaxElem(), List
getElemAtLevel(int)
1. ¿Cuál es la complejidad de cada uno de estos métodos?
 */
public class BinarySearchTree {

    TreeNode raiz;

    public BinarySearchTree(){
        setRaiz(raiz);
    }

    public void insert(int value) {
        this.raiz = insertRec(this.raiz, value);
    }

    private TreeNode insertRec(TreeNode nodoActual, int value) {
        if (nodoActual == null) {
            return new TreeNode(value);
        }
        if (value < nodoActual.getValue()) {
            nodoActual.setLeft(insertRec(nodoActual.getLeft(), value));
        } else if (value > nodoActual.getValue()) {
            nodoActual.setRight(insertRec(nodoActual.getRight(), value));
        }
        return nodoActual;
    }


    public void delete(int value) {
        this.raiz = deleteRec(this.raiz, value);
    }

    private TreeNode deleteRec(TreeNode node, int value) {
        if (node == null) {
            return node;
        }
        if (value < node.getValue()) {
            node.setLeft(deleteRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(deleteRec(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            TreeNode minNode = getMinValueNode(node.getRight());
            node.setValue(minNode.getValue());
            node.setRight(deleteRec(node.getRight(), minNode.getValue()));
        }
        return node;
    }

    private TreeNode getMinValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }


    public boolean search(int value){
        return false;
    }

    public TreeNode getRaiz() {
        return raiz;
    }

    public void setRaiz(TreeNode raiz) {
        this.raiz = raiz;
    }

    public boolean isEmpty(){
        return this.raiz == null;
    }

    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.print(node.getValue() + " ");
            inorderTraversal(node.getRight());
        }
    }
}
