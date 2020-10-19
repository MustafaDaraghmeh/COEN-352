/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut5;

/* Java program for Merge Sort */
class MergeSort_EX1 {
    // Merges two sub arrays of array[].
    // First subarray is array[l..m]
    // Second subarray is array[m+1..r]
    void merge(int[] array, int low, int mid, int high) {
        // Find sizes of two sub arrays to be merged
        int LeftSubArraySize = mid - low + 1;
        int RightSubArraySize = high - mid;

        /* Create temp arrays */
        int[] LeftSubArray = new int[LeftSubArraySize];
        int[] RightSubArray = new int[RightSubArraySize];

        /*Copy data to temp arrays*/
        if (LeftSubArraySize >= 0) System.arraycopy(array,
                low,
                LeftSubArray,
                0,
                LeftSubArraySize);

        for (int j = 0; j < RightSubArraySize; ++j)
            RightSubArray[j] = array[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second sub arrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = low;
        while (i < LeftSubArraySize && j < RightSubArraySize) {
            if (LeftSubArray[i] <= RightSubArray[j]) {
                array[k] = LeftSubArray[i];
                i++;
            } else {
                array[k] = RightSubArray[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < LeftSubArraySize) {
            array[k] = LeftSubArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < RightSubArraySize) {
            array[k] = RightSubArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[left..right] using
    // merge()
    void sort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int m = (left + right) / 2;

            // Sort first and second halves
            sort(arr, left, m);
            sort(arr, m + 1, right);

            // Merge the sorted halves
            merge(arr, left, m, right);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort_EX1 ob = new MergeSort_EX1();

        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
