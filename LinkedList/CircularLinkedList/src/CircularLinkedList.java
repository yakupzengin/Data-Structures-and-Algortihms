public class CircularLinkedList<T extends Comparable> {
    Node<T> head;

    // Inserts a new node at the end of the circular linked list
    public void insertToEnd(T val) {
        Node<T> newNode = new Node<>(val);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node<T> iterator = head;
            while (iterator.next != head) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
            newNode.next = head;
        }
    }

    // Inserts a new node at the front of the circular linked list
    public void insertToFront(T val) {
        Node<T> newNode = new Node<>(val);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node<T> iterator = head;
            while (iterator.next != head) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // Deletes a given element from the circular linked list
    public void delete(T val) {
        if (head == null) {
            return; // Do nothing if the list is empty
        }

        Node<T> iterator = head, prev;

        if (head.value.compareTo(val) == 0) {
            while (iterator.next != head) {
                iterator = iterator.next;
            }
            iterator.next = head.next;
            head = head.next;
        } else {
            do {
                prev = iterator;
                iterator = iterator.next;
                if (iterator.value.compareTo(val) == 0) {
                    prev.next = iterator.next;
                    break;
                }
            } while (iterator != head);

            if (iterator == head) {
                return; // Element not found
            }
        }
    }

    // Displays the elements of the circular linked list
    public void display() {
        if (head == null) {
            return; // Do nothing if the list is empty
        }
        Node<T> iterator = head;
        do {
            System.out.println(iterator.value);
            iterator = iterator.next;
        } while (iterator != head);
    }
}
