/**
 * Implementation of a Doubly Linked List with generic elements
 * The class provides methods for creating nodes inserting elements to the front
 * and end of the list, deleting elements, and displaying the content of the list.
 *
 * @param <T> The type of elements held in the Doubly Linked List, which must extend Comparable.
 */
public class DoublyLinkedList<T extends Comparable> {

    // Head of the doubly linked list
    DNode<T> head;

    /**
     * Creates a new node with the given value.
     *
     * @param val The value to be stored in the new node.
     * @return A new DNode containing the specified value.
     */
    public DNode<T> createNode(T val) {
        return new DNode<>(val);
    }

    /**
     * Inserts a new element at the front of the doubly linked list.
     *
     * @param val The value to be inserted.
     */
    public void insertToFront(T val) {
        DNode<T> newNode = createNode(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    /**
     * Inserts a new element at the end of the doubly linked list.
     *
     * @param val The value to be inserted.
     */
    public void insertToEnd(T val) {
        DNode<T> newNode = createNode(val);
        if (head == null) {
            head = newNode;
        } else {
            DNode<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            newNode.prev = iterator;
            iterator.next = newNode;
        }
    }

    /**
     * Deletes the first occurrence of the specified value from the list.
     *
     * @param val The value to be deleted.
     */
    public void delete(T val) {
        if (head == null)
            return;
        else if (head.value.compareTo(val) == 0) {
            head = head.next;
            if (head != null)
                head.prev = null;
        } else {
            DNode<T> iterator = head;
            while (iterator != null && iterator.value.compareTo(val) != 0) {
                iterator = iterator.next;
            }
            if (iterator == null)
                return;
            else {
                iterator.prev.next = iterator.next;
                if (iterator.next != null)
                    iterator.next.prev = iterator.prev;
            }
        }
    }

    /**
     * Displays the elements of the doubly linked list.
     */
    public void display() {
        DNode<T> iterator = head;
        while (iterator != null) {
            System.out.print(iterator.value + " ");
            iterator = iterator.next;
        }
        System.out.println();
    }
}
