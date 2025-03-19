import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Map to store number and its index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the complement
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // Found the pair!
            }
            map.put(nums[i], i); // Add current number and its index to the map
        }
        throw new IllegalArgumentException("No two sum solution!"); // No solution found
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result)); // [0, 1]
    }
}