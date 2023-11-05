public class LinkedList<T> {
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
    public void display(){
        Node<T> iterator=head;
        while(iterator!=null){
            System.out.println(iterator);
            iterator=iterator.next;
        }

    }
}