/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut5;

// Merge two sorted arrays
public class MergeTwoSortedArrays {

    // Merge leftArray and rightArray into outputArray
    public static void mergeArrays(int[] leftArray, int[] rightArray, int[] outputArray) {
        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray.length;

        int i = 0;
        int j = 0;
        int k = 0;
        // Traverse both array
        while (i < leftArrayLength && j < rightArrayLength) {
            // Check if current element of left
            // array is smaller than current element
            // of right array. If yes, store left
            // array element and increment left array
            // index. Otherwise do same with right array
            if (leftArray[i] < rightArray[j])
                outputArray[k++] = leftArray[i++];
            else
                outputArray[k++] = rightArray[j++];
        }

        // Store remaining elements of left array
        while (i < leftArrayLength)
            outputArray[k++] = leftArray[i++];

        // Store remaining elements of right array
        while (j < rightArrayLength)
            outputArray[k++] = rightArray[j++];
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] leftArray = {1, 2, 2, 3, 3, 5, 70};
        int[] rightArray = {2, 4, 6, 8};
        System.out.println("Given Arrays");
        printArray(leftArray);
        printArray(rightArray);

        int[] outputArray = new int[leftArray.length + rightArray.length];

        mergeArrays(leftArray, rightArray, outputArray);
        System.out.println("\nSorted output array");
        printArray(outputArray);
    }
}

