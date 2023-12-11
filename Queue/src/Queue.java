public class    Queue {
    private int [] values;
    private int rear,front;

    public Queue(int size){
        values=new int[size];
        rear=0;
        front=0;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public boolean isFull(){
        return rear==values.length;
    }
    public void enQueue(int val){
        if(isFull()) {
            System.out.println("queue is full");
            return;
        }
        values[rear]=val;
        rear++;
    }
    public int deQueue(){
        if(isEmpty())
            return -1;
        front++;
        return values[front-1];
    }
    public int count(){
        return rear-front;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <rear ; i++) {
            System.out.println(values[i]);
        }
    }



}
