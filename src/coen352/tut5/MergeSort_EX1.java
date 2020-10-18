/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut5;

/* Java program for Merge Sort */
class MergeSort_EX1 {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int low, int mid, int high) {
        // Find sizes of two subarrays to be merged
        int LeftSubArraySize = mid - low + 1;
        int RightSubArraySize = high - mid;

        /* Create temp arrays */
        int LeftSubArray[] = new int[LeftSubArraySize];
        int RightSubArray[] = new int[RightSubArraySize];

        /*Copy data to temp arrays*/
        for (int i = 0; i < LeftSubArraySize; ++i)
            LeftSubArray[i] = arr[low + i];
        for (int j = 0; j < RightSubArraySize; ++j)
            RightSubArray[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = low;
        while (i < LeftSubArraySize && j < RightSubArraySize) {
            if (LeftSubArray[i] <= RightSubArray[j]) {
                arr[k] = LeftSubArray[i];
                i++;
            } else {
                arr[k] = RightSubArray[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < LeftSubArraySize) {
            arr[k] = LeftSubArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < RightSubArraySize) {
            arr[k] = RightSubArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort_EX1 ob = new MergeSort_EX1();

        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
