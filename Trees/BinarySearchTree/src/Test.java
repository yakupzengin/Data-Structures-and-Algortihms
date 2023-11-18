public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        // Insert values into the binary search tree
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(10);
        binarySearchTree.insert(16);
        binarySearchTree.insert(7);

        // Perform in-order traversal and print the nodes
        binarySearchTree.inOrder();
    }
}