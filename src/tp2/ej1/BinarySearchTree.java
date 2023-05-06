package tp2.ej1;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
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
        //setRaiz(raiz);
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

    public boolean hasElem(int elemento){
        if(this.isEmpty()){
            return false;
        }
        else{
            return hasElemRec(this.raiz, elemento);
        }

    }

    private boolean hasElemRec(TreeNode nodoActual, int value){
        if (nodoActual == null) {
            return false;
        }
        if(value == nodoActual.getValue()){
            return true;
        }
        else if (value < nodoActual.getValue()) {
            return hasElemRec(nodoActual.getLeft(), value);
        }
        else{
            return hasElemRec(nodoActual.getRight(), value);
        }
    }

    public int getHeight(){
        return getHeightRec(this.raiz);
    }

    private int getHeightRec(TreeNode nodoActual){
        if(nodoActual == null){
            return 0;
        }
        else{
            int heightLeft = getHeightRec(nodoActual.getLeft());
            int heightRight = getHeightRec(nodoActual.getRight());
            return Math.max(heightLeft, heightRight) + 1;
        }
    }

    private TreeNode getMinValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public void printInOrder(){
        printInOrderRec(this.getRaiz());
    }

    private void printInOrderRec(TreeNode nodoActual){
        if(nodoActual == null){
            return;
        }
        printInOrderRec(nodoActual.getLeft());
        System.out.print(nodoActual.getValue());
        printInOrderRec(nodoActual.getRight());
    }

    public void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    public List<Integer> getLongestBranch(){
        if(this.isEmpty()){
            return new ArrayList<>();
        }
        else {
            return getLongestBranchRec(this.raiz);
        }
    }

    private List<Integer> getLongestBranchRec(TreeNode nodoActual){
        if(nodoActual == null){
            return new ArrayList<>();
        }
        else {
            List<Integer> leftList = getLongestBranchRec(nodoActual.getLeft());
            List<Integer> rightList = getLongestBranchRec(nodoActual.getRight());
            List<Integer> longestList;
            if(leftList.size() > rightList.size()){
                longestList = leftList;
            }
            else {
                longestList = rightList;
            }
            longestList.add(0, nodoActual.getValue());
            return longestList;
        }
    }

    public List<Integer> getFrontera(){
        List<Integer> fronteraList = new ArrayList<>();
        if(!this.isEmpty()){
            getFronteraRec(this.raiz, fronteraList);
        }
        return fronteraList;
    }


    private void getFronteraRec(TreeNode nodoActual, List<Integer> fronteraList){
        if(nodoActual.getLeft() == null && nodoActual.getRight() == null){
            fronteraList.add(nodoActual.getValue());
        }
        else{
            if(nodoActual.getLeft() != null){
                getFronteraRec(nodoActual.getLeft(), fronteraList);
            }
            if(nodoActual.getRight() != null){
                getFronteraRec(nodoActual.getRight(), fronteraList);
            }
        }
    }

    public Integer getMaxElem() {
        if (isEmpty()) {
            return null;
        }
        TreeNode currentNode = raiz;
        while (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }
        return currentNode.getValue();
    }

    public List<Integer> getElemAtLevel(int level) {
        List<Integer> levelList = new ArrayList<Integer>();
        getElemAtLevelRec(this.raiz, level, levelList);
        return levelList;
    }

    private void getElemAtLevelRec(TreeNode node, int level, List<Integer> levelList) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            levelList.add(node.getValue());
        } else if (level > 1) {
            getElemAtLevelRec(node.getLeft(), level - 1, levelList);
            getElemAtLevelRec(node.getRight(), level - 1, levelList);
        }
    }

    //EJERCICIO 2
    /*Dado un árbol binario de búsquedas que almacena números enteros, implementar un algoritmo
    que retorne la suma de todos los nodos internos del árbol.
     */

    public int sumaTotal(){
        return sumaTotalRec(this.raiz);
    }

    private int sumaTotalRec(TreeNode nodoActual){
        if(nodoActual == null){
            return 0;
        }
        int suma = sumaTotalRec(nodoActual.getLeft()) + nodoActual.getValue() + sumaTotalRec(nodoActual.getRight());
        return suma;
    }

    /*
    Ejercicio 3
        Dado un árbol binario de búsqueda que almacena
        números enteros y un valor de entrada K, implementar un
        algoritmo que permita obtener un listado con los valores
        de todas las hojas cuyo valor supere K.
     */
    public List<Integer> getLeavesGreaterThanK(int k){
        List<Integer> result = new ArrayList<>();
        getLeavesGreaterThanKRec(this.raiz, k, result);
        return result;
    }

    private void getLeavesGreaterThanKRec(TreeNode nodoActual, int k, List<Integer> result){
        if(nodoActual == null){
            return;
        }
        if(nodoActual.getLeft() == null && nodoActual.getRight() == null && nodoActual.getValue() > k){
            result.add(nodoActual.getValue());
        }
        getLeavesGreaterThanKRec(nodoActual.getLeft(), k, result);
        getLeavesGreaterThanKRec(nodoActual.getRight(), k, result);
    }

    /*
    Ejercicio 4
        Se posee un árbol binario (no de búsqueda), donde los nodos internos están vacíos, mientras
        que las hojas tienen valores enteros. Se debe implementar un método que recorra el árbol y
        coloque valores en los nodos vacíos (los nodos internos). El valor de cada nodo interno debe
        ser igual al valor de su hijo derecho, menos el valor de su hijo izquierdo. En caso de que el
        nodo tenga un solo hijo, el valor del hijo faltante se reemplaza por un 0.
     */

    public void fillInternalNodes() {
        fillInternalNodesRec(this.raiz);
    }

    private void fillInternalNodesRec(TreeNode node) {
        if (node == null || node.getLeft() == null && node.getRight() == null) {
            return;
        }

        fillInternalNodesRec(node.getLeft());
        fillInternalNodesRec(node.getRight());

        int leftVal = 0;
        if (node.getLeft() != null) {
            leftVal = node.getLeft().getValue();
        }

        int rightVal = 0;
        if (node.getRight() != null) {
            rightVal = node.getRight().getValue();
        }

        node.setValue(rightVal - leftVal);
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


}
