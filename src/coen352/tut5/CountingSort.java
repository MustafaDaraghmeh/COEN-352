/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut5;

// Implementation of Counting Sort
class CountingSort {
    /* A utility function to print array of size n */
    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String[] args) {
        CountingSort ob = new CountingSort();
        int[] arr = {5, 2, 2, 8, 3, 2, 6, 3, 7};
        System.out.println("Given Array");

        printArray(arr);
        ob.sort(arr);
        System.out.println("\nSorted array");
        printArray(arr);
    }

    void sort(int[] arr) {
        int length = arr.length;
        int max = largest(arr) + 1;

        // The output integer array that will have sorted arr
        int[] output = new int[length];

        // Create a count array to store count of individual
        // integers and initialize count array as 0
        int[] count = new int[max];
        for (int i = 0; i < max; ++i)
            count[i] = 0;

        // store count of each integer
        for (int j : arr) ++count[j];

        // Change count[i] so that count[i] now contains actual
        // position of this integer in output array
        for (int i = 1; i < max; ++i)
            count[i] += count[i - 1];

        // Build the output integer array
        // To make it stable we are operating in reverse order.
        for (int i = length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted integers
        System.arraycopy(output, 0, arr, 0, length);
    }

    // Method to find maximum in arr[]
    int largest(int[] arr) {
        // Initialize maximum element
        int max = arr[0];
        // Traverse array elements from second and
        // compare every element with current max
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
}
