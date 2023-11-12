public class Test {
    public static void main(String [] args){
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertToFront(0);
        doublyLinkedList.insertToFront(-1);
        doublyLinkedList.insertToFront(-2);

        doublyLinkedList.display();

        System.out.println("**");

        doublyLinkedList.insertToEnd(1);
        doublyLinkedList.insertToEnd(2);
        doublyLinkedList.insertToEnd(3);

        doublyLinkedList.display();

        System.out.println("**");

        doublyLinkedList.delete(3);

        doublyLinkedList.display();
    }
}
