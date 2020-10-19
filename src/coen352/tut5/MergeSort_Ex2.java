/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut5;

public class MergeSort_Ex2 {
    public void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    public void merge(int[] array, int l, int m, int r) {
        int[] temp = array.clone();
        int left = l;
        int right = m + 1;
        int pos = left;

        while (left <= m || right <= r) {
            if (left <= m && right <= r) {
                if (temp[left] <= temp[right]) {
                    array[pos] = temp[left];
                    left++;
                } else {
                    array[pos] = temp[right];
                    right++;
                }
            } else if (left <= m) {
                array[pos] = temp[left];
                left++;
            } else if (right <= r) {
                array[pos] = temp[right];
                right++;
            }
            pos++;
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {888, 22, 153, 215, 677, 877};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort_Ex2 ob = new MergeSort_Ex2();

        ob.mergeSort(arr,
                0,
                arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
