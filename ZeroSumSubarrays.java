import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>(); // Map to store cumulative sums and their indices
        int sum = 0; // Cumulative sum

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Add current element to the sum
            if (sum == 0) {
                // If sum is zero, subarray from start to current index is a zero-sum subarray
                result.add(new int[] { 0, i });
            }
            if (sumMap.containsKey(sum)) {
                // If sum exists in the map, all subarrays between previous indices and current
                // index sum to zero
                for (int index : sumMap.get(sum)) {
                    result.add(new int[] { index + 1, i });
                }
            }
            // Add current sum and index to the map
            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        List<int[]> zeroSumSubarrays = findZeroSumSubarrays(arr);
        System.out.println("Zero-Sum Subarrays:");
        for (int[] subarray : zeroSumSubarrays) {
            System.out.println(Arrays.toString(subarray)); // Print start and end indices
        }
    }
}