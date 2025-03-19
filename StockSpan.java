import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int[] span = new int[prices.length];
        Stack<Integer> stack = new Stack<>(); // Stack to store indices (like a time machine)

        for (int i = 0; i < prices.length; i++) {
            // Pop elements from stack while the current price is greater than the price at stack's top
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop(); // Bye-bye, smaller prices!
            }
            // If stack is empty, the span is i+1 (all previous days are smaller)
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i); // Push the current index to the stack
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);
        System.out.print("Stock Spans: ");
        for (int s : span) {
            System.out.print(s + " "); // [1, 1, 1, 2, 1, 4, 6]
        }
    }
}