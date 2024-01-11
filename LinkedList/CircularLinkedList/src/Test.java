public class Test {
    public static void main(String [] args){
        CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();
        circularLinkedList.insertToEnd(1);
        circularLinkedList.insertToEnd(20);
        circularLinkedList.insertToEnd(3);
        circularLinkedList.insertToEnd(0);
        circularLinkedList.insertToEnd(100);
        circularLinkedList.insertToEnd(10);
        circularLinkedList.display();
        System.out.println("*");
        circularLinkedList.selectionSort();
        circularLinkedList.display();
    }
}
