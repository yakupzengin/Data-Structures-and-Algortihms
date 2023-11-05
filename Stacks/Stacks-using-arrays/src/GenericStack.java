// A generic stack class supporting various stack operations
public class GenericStack<T extends Comparable> {
    private T[] items;
    private int top;

    // Constructor initializing the stack with a specified size
    public GenericStack(Class<T> dataType, int size) {
        this.top = -1;
        items = (T[]) java.lang.reflect.Array.newInstance(dataType, size);
    }

    // Removes and returns the top element from the stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return items[0];
        } else {
            this.top--;
            return this.items[this.top + 1];
        }
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return this.top == -1;
    }

    // Checks if the stack is full
    public boolean isFull() {
        return this.top == this.items.length - 1;
    }

    // Returns the size of the stack
    public int size() {
        return this.items.length;
    }

    // Returns the top element without removing it
    public T peek() {
        return this.items[this.top];
    }

    // Clears the stack
    public void clear() {
        this.top = -1;
    }

    // Displays the elements of the stack
    public void display() {
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.println(this.items[i]);
            }
        }
    }

    // Pushes an element onto the stack
    public void push(T val) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            this.items[++this.top] = val;
        }
    }
}
