
package coen352.tut4;

import java.util.*;

public class SelSortExample {
    //Method that implements Selectionsort
    public static void selsort(int[] arr) {
        int n = arr.length; //length of the array
        for (int i = 0; i < n - 1; i++) {
            int MIN = i; //set the first position as minimum
            System.out.println("Sorting based on Number " + (i + 1));
//Find the smallest element by comparing with the element in MIN position
            for (int j = i + 1; j < n; j++) {
                System.out.println("Comparing " + arr[MIN] + " and " + arr[j]);
                if (arr[j] < arr[MIN]) {
                    System.out.println(arr[MIN] + " is greater than " + arr[j]);
                    MIN = j;
                }
            }
//Swap the smallest element with element in MIN position
            int temp = arr[i];
            arr[i] = arr[MIN];
            arr[MIN] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 21, 6, 3, 19, 20}; // input array
        System.out.println("Elements in the array before Sorting: " + Arrays.toString(arr));
        selsort(arr);//calling the selection sort method
        System.out.println("Elements in the array after Sorting: " + Arrays.toString(arr));
    }
}