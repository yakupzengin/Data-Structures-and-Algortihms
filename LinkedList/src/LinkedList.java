public class LinkedList<T extends Comparable> {
    private Node<T> head;

    public Node<T> getHead(){
        return head;
    }
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

    public Node<T> findMinNode(Node<T> startingPoint){
        Node<T> iterator = startingPoint;
        Node<T> minNode = startingPoint;
        while(iterator != null){
            if (minNode.value.compareTo(iterator.value) >0){
                minNode = iterator;
            }
            iterator = iterator.next;
        }
        return minNode;
    }
    public void selectionSort(){
        Node<T > iterator = head;
        if (head == null){
            return;
        }
        while(iterator.next != null){
            Node<T> minNode = findMinNode(iterator);
            T temp = iterator.value;
            iterator.value = minNode.value;
            minNode.value = temp;
            iterator = iterator.next;
        }
    }
    public void insertionSort() {
        if (head == null || head.next == null) {
            // No need to sort if the list has 0 or 1 element
            return;
        }

        Node<T> sorted = null; // Head of the sorted list

        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;

            // Insert the current node into the sorted list
            if (sorted == null || sorted.value.compareTo(current.value) > 0) {
                current.next = sorted;
                sorted = current;
            } else {
                Node<T> temp = sorted;
                while (temp.next != null && temp.next.value.compareTo(current.value) < 0) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }

            current = next;
        }

        // Update the head of the linked list to the sorted list
        head = sorted;
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
            if (iterator.value.compareTo(val)==0){
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
        int n = count();
        if (n <= 1) {
            // No need to sort if the list has 0 or 1 element
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            Node<T> current = head;
            Node<T> nextNode = head.next;

            for (int j = 0; j < n - 1 - i; j++) {
                if (current.value.compareTo(nextNode.value) > 0) {
                    // Swap nodes
                    if (current == head) {
                        head = nextNode;
                    } else {
                        Node<T> prev = head;
                        while (prev.next != current) {
                            prev = prev.next;
                        }
                        prev.next = nextNode;
                    }
                    current.next = nextNode.next;
                    nextNode.next = current;
                } else {
                    current = current.next;
                }
                nextNode = current.next;
            }
        }
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
    public T findMaxRecursive2(){
        return findMaxRecursive2(head,head.value);
    }
    private T findMaxRecursive2(Node<T> current,T currentMax ){
        if (current==null){
            return currentMax;
        }

        currentMax = (current.value.compareTo(currentMax) > 0) ? current.value : currentMax;

        return findMaxRecursive2(current.next,currentMax);
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
        Node<T> newNode = new Node<>(val);

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
    public void recursiveDeleteAll(T val) {
        head = recursiveDeleteAll(head, val);
    }

    private Node<T> recursiveDeleteAll(Node<T> current, T val) {
        if (current == null) {
            return null;
        }
        if (current.value.compareTo(val) == 0) {
            return recursiveDeleteAll(current.next, val);
        } else {
            current.next = recursiveDeleteAll(current.next, val);
            return current;
        }
    }
    // Finds the maximum value in the list recursively
    public T findMax() {
        return findMaxRecursive(head);
    }

    // Helper function for recursive findMax
    private T findMaxRecursive(Node<T> current) {
        if (current == null) {
            return null;
        }

        T currentValue = current.value;
        T nextMax = findMaxRecursive(current.next);

        // Compare the current value with the maximum value in the rest of the list
        if (nextMax == null || currentValue.compareTo(nextMax) > 0) {
            return currentValue;
        } else {
            return nextMax;
        }
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
