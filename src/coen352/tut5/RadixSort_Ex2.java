/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut5;

import java.util.Arrays;

public class RadixSort_Ex2 {
    private static int get_max_val(int[] intsArray, int arrayLength) {
        int max_val = intsArray[0];
        for (int i = 1; i < arrayLength; i++)
            if (intsArray[i] > max_val)
                max_val = intsArray[i];
        return max_val;
    }

    private static void countSort(int[] intsArray, int arrayLength, int exp) {
        int[] result = new int[arrayLength];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < arrayLength; i++)
            count[(intsArray[i] / exp) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = arrayLength - 1; i >= 0; i--) {
            result[count[(intsArray[i] / exp) % 10] - 1] = intsArray[i];
            count[(intsArray[i] / exp) % 10]--;
        }
        for (i = 0; i < arrayLength; i++)
            intsArray[i] = result[i];
    }

    public static void radix_sort(int[] intsArray) {
        int arrayLength = intsArray.length;
        int m = get_max_val(intsArray, arrayLength);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(intsArray, arrayLength, exp);
    }
    /* A utility function to print array of size n */
    public static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {888, 22, 153, 215, 677, 877};

        System.out.println("Given Array");
        printArray(arr);

        radix_sort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
