/*
 *  2020. Mustafa Daraghmeh.
 */

/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut6;

import java.util.Random;

public class Problem6Driver {

    public static void main(String[] args) {
        int data_size=10000;
        Random rn = new Random();
        int[] arr = new int[data_size];
        // init array
        for (int i = 0; i < data_size; ++i)
        {
            arr[i] = rn.nextInt(100000);
        }
        long start = System.currentTimeMillis();
        QuickSortLeftMost quickSortLeftMost=new QuickSortLeftMost();
        quickSortLeftMost.quickSort(arr,0, arr.length -1);
        long end = System.currentTimeMillis();
        long QuickSortLeftMostTime = end - start;
        System.out.println("Execution Time of QuickSort-LeftMost is " + QuickSortLeftMostTime);

        start = System.currentTimeMillis();
        QuickSortRightMost quickSortRightMost=new QuickSortRightMost();
        quickSortRightMost.quickSort(arr,0, arr.length -1);
        end = System.currentTimeMillis();
        long QuickSortRightMostTime = end - start;
        System.out.println("Execution Time of QuickSort-RightMost is " + QuickSortRightMostTime);

        start = System.currentTimeMillis();
        QuickSortMiddleElement quickSortMiddleElement=new QuickSortMiddleElement();
        quickSortMiddleElement.quickSort(arr,0, arr.length -1);
        end = System.currentTimeMillis();
        long QuickSortMiddleElementTime = end - start;
        System.out.println("Execution Time of QuickSort-MiddleElement is " + QuickSortMiddleElementTime);

    }
}
