public class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0; // Starting point (let's hope it works!)
        int totalPetrol = 0; // Total petrol in the tank
        int currentPetrol = 0; // Petrol in the current tour

        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i] - distance[i]; // Calculate total petrol
            currentPetrol += petrol[i] - distance[i]; // Calculate current petrol
            if (currentPetrol < 0) {
                // Oops, we ran out of petrol! Start from the next pump.
                start = i + 1;
                currentPetrol = 0; // Reset the current petrol
            }
        }
        // If total petrol is non-negative, a solution exists
        return (totalPetrol >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int start = findStartingPoint(petrol, distance);
        System.out.println("Starting Point: " + start); // 1
    }
}