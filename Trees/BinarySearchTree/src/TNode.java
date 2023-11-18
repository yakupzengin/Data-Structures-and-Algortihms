public class TNode<T extends Comparable> {
    public T value;
    public TNode<T> left, right;

    // Constructor
    public TNode(T val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }

    // Override toString method to provide a string representation of the node
    public String toString() {
        return String.valueOf(value);
    }
}