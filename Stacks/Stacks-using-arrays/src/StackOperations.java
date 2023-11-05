
// StackOperations class with various stack-related methods
public class StackOperations {
    // Method to search a value in a given stack
    public static boolean search(Stack stk, int val) {
        Stack tempStack = new Stack(stk.count());
        boolean isFound = false;

        while (!stk.isEmpty()) {
            int topValue = stk.pop();
            tempStack.push(topValue);

            if (topValue == val) {
                isFound = true;
                break;
            }
        }

        while (!tempStack.isEmpty()) {
            stk.push(tempStack.pop());
        }

        return isFound;
    }

    // Method to remove a specific element from a given stack
    public static void remove(Stack stk, int val) {
        Stack tempStack = new Stack(stk.count());

        while (!stk.isEmpty()) {
            int topValue = stk.pop();

            if (topValue != val) {
                tempStack.push(topValue);
            }
        }

        while (!tempStack.isEmpty()) {
            stk.push(tempStack.pop());
        }
    }

    // Method to check if two stacks are equal
    public static boolean isEqual(Stack s1, Stack s2) {
        if (s1.count() != s2.count())
            return false;

        Stack tempStack1 = new Stack(s1.count());
        Stack tempStack2 = new Stack(s1.count());
        boolean result = true;

        while (!s1.isEmpty()) {
            int val1 = s1.pop();
            int val2 = s2.pop();
            tempStack1.push(val1);
            tempStack2.push(val2);

            if (val1 != val2) {
                result = false;
                break;
            }
        }

        while (!tempStack1.isEmpty()) {
            s1.push(tempStack1.pop());
            s2.push(tempStack2.pop());
        }

        return result;
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        GenericStack<Character> stack = new GenericStack<>(Character.class, input.length());

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
