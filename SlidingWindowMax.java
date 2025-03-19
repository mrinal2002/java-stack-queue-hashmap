import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0]; // Oops, no window here!
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices (like a sliding door)

        for (int i = 0; i < nums.length; i++) {
            // Remove indices of elements not in the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll(); // Out of the window, out of the deque!
            }
            // Remove indices of smaller elements from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast(); // Bye-bye, smaller elements!
            }
            deque.offer(i); // Add the current index to the deque
            // Add the maximum for the current window to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.print("Sliding Window Max: ");
        for (int num : result) {
            System.out.print(num + " "); // [3, 3, 5, 5, 6, 7]
        }
    }
}