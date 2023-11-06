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
        System.out.println(linkedList.searh(5));
        System.out.println("**");
        System.out.println(linkedList.count());
        System.out.println("**");
        linkedList.recursiveAddToEnd(2);
        linkedList.recursiveAddToEnd(1);
        linkedList.insertToFront(5);
        linkedList.insertToFront(2);
        linkedList.recursiveAddToEnd(2);
        linkedList.display();
        System.out.println("**");
        linkedList.deleteAll(2);
        linkedList.display();
        System.out.println("**");
        linkedList.deleteAll(1);
        linkedList.display();


    }
}
