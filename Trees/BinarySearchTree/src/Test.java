public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        // Insert values into the binary search tree
        binarySearchTree.insert(100);
        binarySearchTree.insert(50);
        binarySearchTree.insert(75);
        binarySearchTree.insert(25);
        binarySearchTree.insert(80);
        binarySearchTree.insert(35);
        binarySearchTree.insert(65);
        binarySearchTree.insert(45);

        // Perform in-order traversal and print the nodes
        binarySearchTree.inOrder();

        // Search for a value in the binary search tree and print the result
        System.out.println(binarySearchTree.search(16));
        System.out.println(binarySearchTree.search(101));
        System.out.println("Height R : "+binarySearchTree.findHeight());
        System.out.println("Height NR : "+binarySearchTree.findHeightNR());
        System.out.println("**");
        System.out.println("inorder");
        binarySearchTree.inOrder();
        System.out.println("**");
        binarySearchTree.inOrderNR();
        System.out.println("***");
        binarySearchTree.postOrder();
        System.out.println("***");
        binarySearchTree.postOrderNR();
        System.out.println("***");

    }
}