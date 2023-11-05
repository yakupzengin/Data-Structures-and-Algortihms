public class Test {
    public static void main(String [] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertToEnd(1);
        linkedList.insertToEnd(2);
        linkedList.insertToEnd(3);
        linkedList.display();
        System.out.println("**");
        linkedList.delete(3);
        linkedList.display();
        System.out.println("**");
        linkedList.delete(10);
        linkedList.display();
        System.out.println("**");
        linkedList.recursiveAddToEnd(5);
        linkedList.display();
        System.out.println("**");
        System.out.println(linkedList.findMin());
        System.out.println("**");
        linkedList.display();
        System.out.println("**");
        linkedList.sortedInsert(10);
        linkedList.display();
        System.out.println("**");
    }
}
