

package coen352.tut4;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while ((i > -1) && (arr[i] > key)) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }

    static void printArray(int[] arr) {
        //simple for loop to print the elements of sorted array
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {21, 18, 15, 23, 52, 12, 61};
//calling the sort function which performs insertion sort
        insertionSort(arr1);
//calling the printArray function which performs printing of array
        printArray(arr1);
    }
}