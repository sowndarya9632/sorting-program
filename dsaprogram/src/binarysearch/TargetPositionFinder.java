package binarysearch;

public class TargetPositionFinder {

    public static int findTargetPosition(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // To prevent overflow

            if (arr[mid] == target) {
                return mid; // Target found, return its index
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int targetValue = 5;
        int position = findTargetPosition(sortedArray, targetValue);

        System.out.println("Position of " + targetValue + ": " + position); // Output: Position of 5: 4
    }
}

