// Test class with main method for testing stack operations
public class Test {
    public static void  main(String[] args) {


        Stack myStack=new Stack(5);
        myStack.push(55);
        myStack.push(66);
        myStack.push(102);
        myStack.push(1);
        myStack.push(13);

        StackOperations stackOperation = new StackOperations();
        System.out.println(stackOperation.search(myStack, 66));

        Stack mySecondStack = new Stack(5);
        mySecondStack.push(55);
        mySecondStack.push(66);
        mySecondStack.push(102);
        mySecondStack.push(1);
        mySecondStack.push(13);

        System.out.println(stackOperation.isEqual(myStack,mySecondStack));
        mySecondStack.display();

        String text = "1.Ara.1";
        System.out.println("Is '" + text + "' a palindrome? " + stackOperation.isPalindrome(text));


    }
}



