public class LinkedList<T extends Comparable> {
    private Node<T> head;

    public Node<T> createNode(T val){
        return new Node<T>(val);
    }
    public void insertToFront(T val){
        Node<T> newNode=createNode(val);
        newNode.next=head;
        head=newNode;
    }
    public void insertToEnd(T val){
        Node<T> newNode=createNode(val);
        if(head==null){
            head=newNode;
            return;
        }
        Node<T> iterator=head;
        while(iterator.next!=null)
            iterator=iterator.next;
        iterator.next=newNode;

    }
    public int count(){
        int count = 0;
        Node<T> iterator = head;
        while (iterator != null){
            count++;
            iterator = iterator.next;
        }
        return count;
    }
    public boolean search(T val){
        Node<T> iterator = head;
        boolean isFound = false;
        while(iterator!=null ){
            if (iterator.value == val){
                isFound=true;
                return isFound;
            }
            iterator = iterator.next;
        }
        return isFound;
    }
    public boolean recursiveSearch(T val){
        return recursiveSearch(head,val);
    }
    public boolean recursiveSearch(Node<T> tempHead , T val){
        if (tempHead ==null )
            return false;

        if (tempHead.value.compareTo(val) == 0){
            return true;
        }
        return recursiveSearch(tempHead.next,val);
    }

    //-write a bubble sort algorithm that will sort the linked list
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


    //-swap first node and the last one. Swap nodes not values.
    public void swapFirstAndLastNodes(){

        if (head != null && head.next !=null){
            Node<T> lastBefore =head , last = head;

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
    public T findMin() {
        if (head==null)
            return null;
        T min = head.value;
        Node<T> iterator  = head.next;

        while(iterator != null){
            if (min.compareTo(iterator.value) == 1)
                min = iterator.value;
            iterator = iterator.next;
        }
        return min;
    }

    public void sortedInsert(T val) {
        Node<T> newNode = createNode(val);

        if (head==null){
            head = newNode;
        }else if (val.compareTo(head.value) <=0){
            newNode.next = head;
            head=newNode;
        }else{
            Node<T> iterator = head;
            while(iterator.next != null && iterator.next.value.compareTo(val) == -1 ) {
                iterator = iterator.next;
            }
            newNode.next = iterator.next;
            iterator.next = newNode;
        }
    }

    //  2 5 1 9 8 2 4 21 1 2 8 2 13 5 2
    public void deleteAll(T val){
        Node<T> previous = head , iterator =head;

        while(iterator != null ){
            if (head.value == val)
                head = head.next;
            if (iterator.value == val){
                previous.next = iterator.next;
            }
            previous = iterator;
            iterator = iterator.next;
        }
    }
    public void deleteTheFirst(){
        if(head!=null)
            head=head.next;
    }
    public void delete(T val){
        if(head==null)
            return;
        if(head.value.compareTo(val)==0)
            head=head.next;
        else{
            Node<T> previous=head, iterator=head;
            while(iterator!=null && iterator.value.compareTo(val)!=0)   {
                previous=iterator;
                iterator=iterator.next;
            }
            if(iterator!=null)
                previous.next=iterator.next;

        }
    }

    public void recursiveAddToEnd(T val){
        head=recursiveAddToEnd(head, val);
    }
    public Node<T> recursiveAddToEnd(Node<T> tempHead, T val)
    {
        if(tempHead==null)
            return createNode(val);
        else{
            tempHead.next=recursiveAddToEnd(tempHead.next, val);
        }
        return tempHead;
    }
    public void display(){
        Node<T> iterator=head;
        while(iterator!=null){
            System.out.println(iterator);
            iterator=iterator.next;
        }

    }
}