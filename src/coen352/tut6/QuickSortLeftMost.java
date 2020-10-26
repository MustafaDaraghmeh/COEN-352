/*
 *  2020. Mustafa Daraghmeh.
 */

/*
 *  2020. Mustafa Daraghmeh.
 */

/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut6;

import java.util.Random;

public class QuickSortLeftMost {

    // This function used to split the problem into small sub-problem.
    // Divide phase
    public int partition(int[] arr, int start, int end){
        // Pivot can be selected randomly, but in this case I make the last
        // element is the pivot for simplicity
        int pivot = arr[0];
        // Start searching step
        for(int i=start; i < end; i++){
            if(arr[i] < pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }
        // Swap the last item to the most right part.
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }

    public void quickSort(int[] arr, int start, int end){

        int partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }

    // method for printing the elements
    public static void display(int[] a) {
        int size = a.length;

        for (int i = 0; i < size; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }


    public static void main(String[] args) {
        int data_size=10000;
        //int[] arr = {888, 22, 153, 215, 677, 877};
        Random rn = new Random();
        int[] arr = new int[data_size];
        double time = 0.0;
        // init array
        for (int i = 0; i < data_size; ++i)
        {
            arr[i] = rn.nextInt(100000);
        }
        display(arr);
        QuickSortLeftMost ob=new QuickSortLeftMost();
        ob.quickSort(arr,0, arr.length -1);

        display(arr);

    }
}
