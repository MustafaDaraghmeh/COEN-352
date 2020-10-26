/*
 *  2020. Mustafa Daraghmeh.
 */

/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut6;

import java.util.Random;

public class QuickSortOptimization {

    // cutoff to insertion sort, must be >= 1
    private static int INSERTION_SORT_CUTOFF = 8;
    public boolean verbose=false;
    public QuickSortOptimization(int cutoff) {
        this.INSERTION_SORT_CUTOFF = cutoff;
    }

    // This function used to split the problem into small sub-problem.
    // Divide phase
    public int partition(int[] arr, int start, int end){
        int n  = end - start + 1;
        if (n <= INSERTION_SORT_CUTOFF) {
            if(verbose) {
                System.out.println("Run insertion sort at partition = " + start);
            }
            insertionSort(arr);
        }
        else {

            // Pivot can be selected randomly, but in this case I make the last
            // element is the pivot for simplicity
            int pivot = arr[end];
            // Start searching step
            for (int i = start; i < end; i++) {
                if (arr[i] < pivot) {
                    int temp = arr[start];
                    arr[start] = arr[i];
                    arr[i] = temp;
                    start++;
                }
            }
            // Swap the last item to the most right part.
            int temp = arr[start];
            arr[start] = pivot;
            arr[end] = temp;
            if(verbose) {
                System.out.println("Run quick sort at partition = " + start);
            }
        }
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
        if(verbose) {
            System.out.println("Partition # "+partition);
            display(arr);
        }
    }

    // method for printing the elements
    public void display(int[] a) {
        int size = a.length;

        for (int i = 0; i < size; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    // sort from a[lo] to a[hi] using insertion sort
    private void insertionSort(int[] result) {
        for (int i = 1; i < result.length; i++) {
            int tmp = result[i];
            int j = i - 1;

            while (j >= 0 && tmp < result[j]) {
                result[j + 1] = result[j];
                --j;
            }

            result[j + 1] = tmp;
        }
    }

    static final double DIV_FACTOR = 1000000000.0;

    public static void test_QuickSort_Optimization(int data_size)
    {
        Random rn = new Random();
        int[] arr = new int[data_size];
        double time = 0.0;
        // init array
        for (int i = 0; i < data_size; ++i)
        {
            arr[i] = rn.nextInt(10000);
        }
        double minimum_time = 1000.0;
        int optimal_cutoff = 0;
        // Let's test different cutoff for this optimization technique.
        for (int cutoff = 2; cutoff < data_size/4;++cutoff) {
            // Start process.
            QuickSortOptimization optimization = new QuickSortOptimization(cutoff);
            long start = System.nanoTime();
            optimization.quickSort(arr, 0, arr.length - 1);
            long end = System.nanoTime();
//            optimization.display(arr);
            time = (end - start) / DIV_FACTOR;
            System.out.println("Time of cutoff = " + cutoff + " = "+time+" sec");
            if(time < minimum_time)
            {
                minimum_time = time;
                optimal_cutoff = cutoff;
            }
        }
        System.out.println("The best cutoff = " + optimal_cutoff + " with time = "+minimum_time+" sec");
    }

    public static void main(String args[])
    {
        test_QuickSort_Optimization(1000);

    }


}
