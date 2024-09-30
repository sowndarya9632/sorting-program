package binarysearch;

public class SquareRoot {

    public static void main(String[] args) {
        int number = 10;
        int precision = 3; // Specify the precision
        double result = integerSquareRoot(number, precision);
        System.out.printf("The square root of %d up to %d decimal places is: %.3f%n", number, precision, result);
    }

    public static double integerSquareRoot(int n, int precision) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot compute the square root of a negative number.");
        }
        if (n == 0 || n == 1) {
            return n;
        }

        // Binary search for the integer part
        int left = 0, right = n;
        int integerPart = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSquared = (long) mid * mid; // Use long to avoid overflow

            if (midSquared == n) {
                return mid; // Exact square root found
            } else if (midSquared < n) {
                integerPart = mid; // Update the integer part
                left = mid + 1; // Search right
            } else {
                right = mid - 1; // Search left
            }
        }

        // If precision is required, refine the result
        double result = integerPart;
        double increment = Math.pow(10, -precision); // Increment based on precision

        // Find the fractional part
        for (int i = 0; i < precision; i++) {
            while ((result + increment) * (result + increment) <= n) {
                result += increment; // Increment the result
            }
            increment /= 10; // Move to the next decimal place
        }

        return Math.round(result * Math.pow(10, precision)) / Math.pow(10, precision);
    }
}

