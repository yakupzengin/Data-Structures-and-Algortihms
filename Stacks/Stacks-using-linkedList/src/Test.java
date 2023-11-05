public class Test {
    public static void main(String[] args){
        Stack myStack = new Stack(); // Assuming Stack class is defined

        // Pushing elements onto the stack
        myStack.push("Data");
        myStack.push("Structures");
        myStack.push("Algorithms");

        System.out.println(myStack.peek()); // Display the top element without removing it

        myStack.pop(); // Remove the top element

        System.out.println(myStack.isEmpty()); // Check if the stack is empty

        System.out.println(myStack.getLastElement()); // Get the last element without removing it
    }
}
