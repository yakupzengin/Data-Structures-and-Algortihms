public class Test {
    public static void main(String [] args){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertToFront("Data");
        linkedList.insertToFront("Structures");
        linkedList.insertToFront("Algorithms");
        linkedList.insertToEnd("Java");

        linkedList.display();
    }
}
