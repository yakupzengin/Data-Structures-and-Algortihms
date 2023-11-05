public class CircularQueue<T> {
    int rear, front;
    T[] items;
    public CircularQueue(Class<T> dataType, int size){
        this.rear=this.front=0;
        items=(T[])java.lang.reflect.Array.newInstance(dataType, size+1);
    }
    public boolean isEmpty()
    {
        return rear == front;

    }
    public int size()
    {
        return items.length;
    }
    public boolean isFull()
    {
        return (rear + 1) % size() == front;
    }
    public void enQueue (T val) throws  Exception{
        if(isFull()){
            throw new Exception("Queue is full)");
        }
        else{
            this.rear=(this.rear+1)%size();
            this.items[this.rear]=val;
        }
    }
    public T deQueue () throws  Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        else{
            this.front=(this.front+1)%size();
            return this.items[this.front];
        }
    }
    public void display(){
        int i=(front+1)%size();
        while(i!=(rear+1)%size()){
            System.out.println(items[i]);
            i=(i+1)%size();
        }
    }

}