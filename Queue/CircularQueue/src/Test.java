public class Test {
    public static void main(String [] args) throws Exception {
        CircularQueue<String> circularQueue = new CircularQueue<>(String.class,10);
        circularQueue.enQueue("Data");
        circularQueue.enQueue("Structures");
        circularQueue.enQueue("Algorithms");
        circularQueue.display();
        System.out.println("*****");
        circularQueue.deQueue();
        circularQueue.display();
        System.out.println("*****");
    }
}
