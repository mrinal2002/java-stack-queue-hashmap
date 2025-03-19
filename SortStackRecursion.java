import java.util.Stack;

public class SortStackRecursion {
    // Recursive function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop(); // Pop the top element (like picking a candy)
            sortStack(stack); // Sort the rest of the stack (recursion magic!)
            insertSorted(stack, temp); // Insert the popped element back in the right place
        }
    }

    // Helper function to insert an element in sorted order
    private static void insertSorted(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x); // If the stack is empty or x is bigger, just push it!
        } else {
            int temp = stack.pop(); // Pop the top element (like digging deeper)
            insertSorted(stack, x); // Recursively find the right spot
            stack.push(temp); // Push the popped element back
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        System.out.println("Original Stack: " + stack); // [5, 1, 4, 2, 3]
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack); // [1, 2, 3, 4, 5]
    }
}