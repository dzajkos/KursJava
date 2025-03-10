public class Tree {

    int treeSize = 0;
    Node root = null;

    public void addNode(Integer value) {

        if(root == null) {
            root = new Node(value);
            treeSize++;
            return;
        }
        addNodeRecursive(value, root);
    }

    private Node addNodeRecursive(Integer value, Node current) {

        if (current == null) {
            treeSize++;
            return new Node(value);
        }
        if (current.getValue() > value) {
            current.setLeft(addNodeRecursive(value, current.getLeft()));
        }
        if (current.getValue() < value) {
            current.setRight(addNodeRecursive(value, current.getRight()));
        }
        return current;

    }

    public void print () {
    Node current = root;
    printRecursive(current);
    }

    private void printRecursive (Node current) {
        if (current != null) {
            printRecursive(current.getLeft());
            System.out.println(current.getValue());
            printRecursive(current.getRight());
        }
    }


}
