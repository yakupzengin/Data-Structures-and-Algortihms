// Stack class implementing basic stack operations
public class Stack {
    private int[] values;
    private int top;

    // Constructor
    public Stack(int size) {
        this.top = -1;
        this.values = new int[size];
    }

    // Returns the size of the stack
    public int size() {
        return values.length;
    }

    // Returns the top element without removing it
    public int peek() {
        if (isEmpty())
            return -1;
        return this.values[this.top];
    }

    // Returns the count of elements in the stack
    public int count() {
        return this.top + 1;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return this.top == -1;
    }

    // Checks if the stack is full
    public boolean isFull() {
        return this.top == values.length - 1;
    }

    // Pushes an element onto the stack
    public void push(int val) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            this.top++;
            this.values[top] = val;
        }
    }

    // Pops the top element from the stack
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        this.top--;
        return this.values[this.top + 1];
    }

    // Displays the elements of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = this.top; i > -1; i--) {
            System.out.println(this.values[i]);
        }
    }
}