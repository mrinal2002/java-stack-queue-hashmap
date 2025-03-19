import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1; // Stack for enqueue
    private Stack<Integer> stack2; // Stack for dequeue

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue: Push to stack1 (like adding to the back of the queue)
    public void enqueue(int x) {
        stack1.push(x); // Just push it, no questions asked!
    }

    // Dequeue: Pop from stack2 (like removing from the front of the queue)
    public int dequeue() {
        if (stack2.isEmpty()) {
            // Oh no! stack2 is empty. Let's move stuff from stack1 to stack2.
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // Flip it like a pancake!
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty! No more snacks left.");
        }
        return stack2.pop(); // Finally, serve the first customer!
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // 1 (first in, first out!)
        System.out.println(queue.dequeue()); // 2
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.dequeue()); // 4
    }
}