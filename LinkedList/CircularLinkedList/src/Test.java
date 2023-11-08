public class Test {
    public static void main(String [] args){
        CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();
        circularLinkedList.insertToEnd(1);
        circularLinkedList.insertToEnd(2);
        circularLinkedList.insertToEnd(3);
        circularLinkedList.insertToEnd(1);
        circularLinkedList.display();
        circularLinkedList.delete(1);
        System.out.println("*");
        circularLinkedList.display();
    }
}
