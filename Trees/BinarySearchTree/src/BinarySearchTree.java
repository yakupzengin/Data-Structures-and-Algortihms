import java.util.Stack;

public class BinarySearchTree<T extends Comparable> {
    private TNode<T> root;
    public int findHeight(){
        return findHeight(root);
    }
    public int findHeight(TNode<T> currentRoot){
        if (currentRoot !=null){
            int left = findHeight(currentRoot.left);
            int right = findHeight(currentRoot.right);
            return ( left > right ? left+1 : right+1);
        }
        return 0;
    }

    // None Recursively
    public int findHeightNR() {
        TNode<T> iterator = root;

        if (iterator == null) {
            return 0;
        }

        int leftSide = 0;
        while (iterator != null) {
            leftSide++;
            if (iterator.left != null) {
                iterator = iterator.left;
            } else if (iterator.right != null) {
                iterator = iterator.right;
            } else {
                break;
            }
        }

        int rightSide = 0;
        iterator = root; // Reset iterator to the root for right side traversal
        while (iterator != null) {
            rightSide++;
            if (iterator.right != null) {
                iterator = iterator.right;
            } else if (iterator.left != null) {
                iterator = iterator.left;
            } else {
                break;
            }
        }

        return Math.max(leftSide, rightSide);
    }


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

    private void inOrder(TNode<T> root) {
        // Perform in-order traversal and print the nodes
        if (root != null) {
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(TNode<T> root){
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root);
        }
    }

    public void inOrderNR() {
        if (root == null) {
            return;
        }

        Stack<TNode<T>> stack = new Stack<>();
        TNode<T> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.println(current);

            current = current.right;
        }
    }


    public void postOrderNR() {
        if (root == null) {
            return;
        }

        Stack<TNode<T>> stack = new Stack<>();
        TNode<T> iterator = root;
        TNode<T> lastVisited = null;

        while (iterator != null || !stack.isEmpty()) {
            if (iterator != null) {
                stack.push(iterator);
                iterator = iterator.left;
            } else {
                TNode<T> peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    // Move to the right subtree if exists and not visited yet
                    iterator = peekNode.right;
                } else {
                    // Visit the iterator node
                    System.out.println(peekNode);

                    // Mark the iterator node as last visited
                    lastVisited = stack.pop();
                }
            }
        }
    }

    // Search for a value in the binary search tree
    public boolean search(T val) {
        return search(root, val);
    }

    // Helper method for searching a value in the binary search tree
    public boolean search(TNode<T> root, T val) {
        if (root == null) {
            return false;
        }
        if (root.value.compareTo(val) == 0) {
            return true;
        } else if (root.value.compareTo(val) < 0) {
            return search(root.right, val);
        } else {
            return search(root.left, val);
        }
    }

    public TNode<T> findNode(T val) {
        return findNode(root, val);
    }

    public TNode<T> findNode(TNode<T> tempRoot, T val) {
        if (tempRoot == null) {
            return null;
        } else if (val.compareTo(tempRoot.value) == -1) {
            return findNode(tempRoot.left, val);
        } else if (val.compareTo(tempRoot.value) == 1) {
            return findNode(tempRoot.right, val);
        } else
            return tempRoot;
    }


    public TNode<T> findParent(T val) {
        if (search(val) == false || root.value.compareTo(val) == 0)
            return null;
        else {
            TNode<T> parent = root, iterator = root;
            while (iterator.value.compareTo(val) != 0) {
                parent = iterator;
                if (val.compareTo(iterator.value) == -1)
                    iterator = iterator.left;
                else
                    iterator = iterator.right;
            }
            return parent;
        }
    }
    public TNode<T> inorderSuccessor(T val){
        // check the current's value. İf there is no val , current = null , or current is gonna be value.
        TNode<T> current = findNode(val);
        if (current == null)
            return null;
        else if (current.right !=null) {
            TNode<T> iterator = current.right;
            while(iterator.left != null){
                iterator=iterator.left;
            }
            return iterator;
        } else if (current == root && root.right == null) {
            return null;
        } else if (current.right == null) {
            TNode<T> parent = findParent(val);
            if (parent.left == current){
                return parent;
            }else{
                TNode<T> grandParent = findParent(parent.value);
                while(grandParent != null && grandParent.left!=parent){
                    parent = grandParent;
                    grandParent = findParent(parent.value);
                }
                if(grandParent == null)
                    return null;
                else {
                    return grandParent;

                }
            }
        }
        return null;
    }
    public boolean isLeaf(T val){
        TNode<T> current=findNode(val);
        return (current.left==null && current.right==null);

    }

    public void delete( T val){
        if (isLeaf(val)){
            TNode<T> parent =findParent(val);
            if(parent.left.value.compareTo(val)==0)
                parent.left=null;
            else parent.right=null;

        }else{
            TNode<T> current=findNode(val);
            TNode<T> parent=findParent(val);
            if(current.left==null && current.right!=null)
            {
                if(parent.left==current)
                    parent.left=current.right;
                else
                    parent.right=current.right;
            }else if (current.right==null && current.left!=null)
            {
                if(parent.left==current)
                    parent.left=current.left;
                else
                    parent.right=current.left;
            }else{//means it has two children
                TNode<T> inorder=inorderSuccessor(val);
                delete(inorder.value);
                current.value=inorder.value;

            }
        }
    }
    public void swapValues(){
        if (root == null){
            return;
        }
        TNode<T> iterator = root;
        TNode<T> iterator2 = root;
        TNode<T> smallest = root;
        TNode<T> largest = root;
        while(iterator !=null){
            smallest = iterator;
            iterator = iterator.left;
        }
        while(iterator2 !=null){
            largest = iterator2;
            iterator2 = iterator2.right;
        }
        T temp = smallest.value;
        smallest.value = largest.value;
        largest.value = temp;

    }
}

