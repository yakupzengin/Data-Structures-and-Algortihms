public class LinkedListNode<T> {
    public HuffmanNode node;
    public LinkedListNode next;

    public LinkedListNode(HuffmanNode node){
        this.node=node;
        this.next=null;
    }
}