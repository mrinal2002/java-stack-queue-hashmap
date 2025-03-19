import java.util.*;

public class PairWithSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> visited = new HashSet<>(); // Set to store visited numbers
        for (int num : arr) {
            int complement = target - num; // Calculate the complement
            if (visited.contains(complement)) {
                return true; // Found a pair!
            }
            visited.add(num); // Add current number to the set
        }
        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int target = 16;
        System.out.println("Pair with sum " + target + " exists? " + hasPairWithSum(arr, target)); // true
    }
}