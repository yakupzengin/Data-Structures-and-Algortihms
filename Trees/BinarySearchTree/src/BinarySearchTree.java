public class BinarySearchTree<T extends Comparable> {
    private TNode<T> root;

    public void insert(T val) {
        TNode<T> newNode = new TNode<>(val);

        if (root == null) {
            // If the tree is empty, set the new node as the root
            root = newNode;
        } else {
            TNode<T> iterator = root;

            // Traverse the tree to find the correct position for the new node
            while (iterator != null) {
                if (iterator.value.compareTo(val) > 0) {
                    // If the value is smaller, move to the left subtree
                    if (iterator.left != null) {
                        iterator = iterator.left;
                    } else {
                        // Insert the new node to the left
                        iterator.left = newNode;
                        return;
                    }
                } else if (iterator.value.compareTo(val) < 0) {
                    // If the value is larger, move to the right subtree
                    if (iterator.right != null) {
                        iterator = iterator.right;
                    } else {
                        // Insert the new node to the right
                        iterator.right = newNode;
                        return;
                    }
                } else {
                    // Duplicate value, print a message and return
                    System.out.println("Duplicate Value");
                    return;
                }
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TNode<T> root) {
        // Perform in-order traversal and print the nodes
        if (root != null) {
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }
    }
}