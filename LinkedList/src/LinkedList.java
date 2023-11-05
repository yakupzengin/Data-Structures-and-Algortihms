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
    public void deleteTheFirst(){
        if (head != null)
            head = head.next;
    }
    public void delete(T val){
        if(head == null){
            return;
        }
        if (head.value.compareTo(val) ==0)
            head = head.next;
        else {
            Node<T> previous=head , iterator = head;
            while(iterator != null && iterator.next.value.compareTo(val) !=0){
                previous=iterator;
                iterator = iterator.next;
            }
            if (iterator !=null)
                previous.next = iterator.next;
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