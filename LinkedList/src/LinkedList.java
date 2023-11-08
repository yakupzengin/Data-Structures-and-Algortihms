public class LinkedList<T extends Comparable> {
    private Node<T> head;

    // Creates a new node with the given value
    public Node<T> createNode(T val){
        return new Node<T>(val);
    }

    // Inserts a node containing the given value at the front of the list
    public void insertToFront(T val){
        Node<T> newNode = createNode(val);
        newNode.next = head;
        head = newNode;
    }

    // Inserts a node containing the given value at the end of the list
    public void insertToEnd(T val){
        Node<T> newNode = createNode(val);
        if(head == null){
            head = newNode;
            return;
        }
        Node<T> iterator = head;
        while(iterator.next != null)
            iterator = iterator.next;
        iterator.next = newNode;
    }

    // Counts the number of nodes in the list
    public int count(){
        int count = 0;
        Node<T> iterator = head;
        while (iterator != null){
            count++;
            iterator = iterator.next;
        }
        return count;
    }

    // Searches for a given value iteratively
    public boolean search(T val){
        Node<T> iterator = head;
        boolean isFound = false;
        while(iterator != null ){
            if (iterator.value == val){
                isFound = true;
                return isFound;
            }
            iterator = iterator.next;
        }
        return isFound;
    }

    // Searches for a given value recursively
    public boolean recursiveSearch(T val){
        return recursiveSearch(head, val);
    }

    // Helper function for recursive search
    private boolean recursiveSearch(Node<T> tempHead, T val){
        if (tempHead == null)
            return false;

        if (tempHead.value.compareTo(val) == 0){
            return true;
        }
        return recursiveSearch(tempHead.next, val);
    }

    // Performs a bubble sort on the linked list
    public void bubbleSort() {
        // Check if the list is empty or contains only one node
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Node<T> last = null;

        do {
            swapped = false;
            Node<T> current = head;
            Node<T> previous = null;
            Node<T> nextNode;

            while (current.next != last) {
                if (current.value.compareTo(current.next.value) > 0) {
                    // Swap nodes
                    nextNode = current.next;
                    if (previous != null) {
                        previous.next = nextNode;
                    } else {
                        head = nextNode;
                    }

                    current.next = nextNode.next;
                    nextNode.next = current;

                    previous = nextNode;
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            last = current;
        } while (swapped);
    }

    // Swaps the first node and the last node. Swap nodes, not values.
    public void swapFirstAndLastNodes(){
        if (head != null && head.next != null){
            Node<T> lastBefore = head, last = head;

            while(last.next != null){
                lastBefore = last;
                last = last.next;
            }
            last.next = head.next;
            lastBefore.next = head;
            head.next = null;
            head = last;
        }
    }

    // Finds the minimum value in the list
    public T findMin() {
        if (head == null)
            return null;
        T min = head.value;
        Node<T> iterator = head.next;

        while(iterator != null){
            if (min.compareTo(iterator.value) > 0)
                min = iterator.value;
            iterator = iterator.next;
        }
        return min;
    }

    // Inserts a node with the given value in a sorted manner
    public void sortedInsert(T val) {
        Node<T> newNode = createNode(val);

        if (head == null){
            head = newNode;
        } else if (val.compareTo(head.value) <= 0){
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> iterator = head;
            while(iterator.next != null && iterator.next.value.compareTo(val) <= -1 ) {
                iterator = iterator.next;
            }
            newNode.next = iterator.next;
            iterator.next = newNode;
        }
    }

    // Deletes all nodes with the given value
    public void deleteAll(T val){
        Node<T> previous = head, iterator = head;

        while(iterator != null){
            if (head.value == val)
                head = head.next;
            if (iterator.value == val){
                previous.next = iterator.next;
            }
            previous = iterator;
            iterator = iterator.next;
        }
    }

    // Deletes the first node
    public void deleteTheFirst(){
        if (head != null)
            head = head.next;
    }

    // Deletes the node with the given value
    public void delete(T val){
        if (head == null)
            return;
        if (head.value.compareTo(val) == 0)
            head = head.next;
        else {
            Node<T> previous = head, iterator = head;
            while(iterator != null && iterator.value.compareTo(val) != 0){
                previous = iterator;
                iterator = iterator.next;
            }
            if(iterator != null)
                previous.next = iterator.next;
        }
    }

    // Adds a node with the given value at the end using recursion
    public void recursiveAddToEnd(T val){
        head = recursiveAddToEnd(head, val);
    }

    // Helper function for recursive addition to the end
    private Node<T> recursiveAddToEnd(Node<T> tempHead, T val){
        if(tempHead == null)
            return createNode(val);
        else {
            tempHead.next = recursiveAddToEnd(tempHead.next, val);
        }
        return tempHead;
    }

    // Displays the linked list
    public void display(){
        Node<T> iterator = head;
        while(iterator != null){
            System.out.println(iterator);
            iterator = iterator.next;
        }
    }
}
