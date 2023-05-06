package tp2.ej5;

import tp2.ej1.TreeNode;

public class TreeNodeChar {

    char value;
    TreeNodeChar left;
    TreeNodeChar right;

    public TreeNodeChar(char value){
        setValue(value);
    }

    public char getChar() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public TreeNodeChar getLeft() {
        return left;
    }

    public void setLeft(TreeNodeChar left) {
        this.left = left;
    }

    public TreeNodeChar getRight() {
        return right;
    }

    public void setRight(TreeNodeChar right) {
        this.right = right;
    }
}
