package binarysearch;

public class BitonicArrayPeakAlternative {

    // Method to find the peak element in a bitonic array
    public static int findPeak(int[] arr) {
        if (arr.length == 0) return -1; // Handle empty array

        int n = arr.length;

        // Check the first and last elements
        if (n == 1) return 0; // Single element is a peak
        if (arr[0] > arr[1]) return 0; // First element is a peak
        if (arr[n - 1] > arr[n - 2]) return n - 1; // Last element is a peak

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the peak
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid; // Mid is the peak
            } else if (arr[mid] < arr[mid + 1]) {
                // Move to the right side
                left = mid + 1;
            } else {
                // Move to the left side
                right = mid - 1;
            }
        }

        return -1; // This line should never be reached for a valid bitonic array
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 8, 12, 4, 2};
        int peakIndex = findPeak(a);
        if (peakIndex != -1) {
            System.out.println("Peak element index: " + peakIndex); // Output: index of peak
            System.out.println("Peak element: " + a[peakIndex]); // Output: value of peak
        } else {
            System.out.println("No peak element found.");
        }
    }
}
