public class Main {
    public static void main(String[] args) {
        Tree tree =new Tree();

        tree.addNode(6);
        tree.addNode(3);
        tree.addNode(8);
        tree.addNode(15);
        tree.addNode(7);
        tree.addNode(9);

        System.out.println("Rozmiar drzewa: " + tree.treeSize);
        tree.print();

    }
}
