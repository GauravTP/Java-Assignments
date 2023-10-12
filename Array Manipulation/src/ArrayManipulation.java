import java.util.Arrays;
import java.util.Comparator;

public class ArrayManipulation {
    public static void main(String[] args) {
        // Sample array of integers
        int[] numbers = { 42, 15, 7, 88, 23, 56, 91, 4, 11 };

        // Finding the maximum value in the array
        int max = findMax(numbers);
        System.out.println("Maximum value: " + max);

        // Finding the minimum value in the array
        int min = findMin(numbers);
        System.out.println("Minimum value: " + min);

        // Sorting the array in ascending order
        int[] sortedArray = sortArray(numbers);
        System.out.println("Sorted array (ascending): " + Arrays.toString(sortedArray));

        // Reversing the array
        int[] reversedArray = reverseArray(numbers);
        System.out.println("Reversed array: " + Arrays.toString(reversedArray));

        // Reverse Sorting an array
        int[] reverseSortedArray = reverseSorted(numbers);
        System.out.println("Reverse Sorted array: " + Arrays.toString(reversedArray));
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int[] sortArray(int[] arr) {
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[arr.length - 1 - i];
        }

        return reversedArray;
    }

    public static int[] reverseSorted(int[] arr) {
        int[] sortedArray = sortArray(arr);
        int[] reverseSortedArray = reverseArray(sortedArray);
        return reverseSortedArray;
    }
}