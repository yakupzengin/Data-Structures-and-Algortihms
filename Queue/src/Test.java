public class Test {
    public static void main(String[] args) {

        Queue myQ=new Queue(5);
        myQ.enQueue(5);
        myQ.enQueue(7);
        myQ.enQueue(17);
        myQ.enQueue(72);
        myQ.deQueue();
        myQ.display();

    }
}
