
package coen352.tut4;

public class NaiveMethodFindPairN2 {
    // Naive method to find a pair in an array with given sum
    public static void findPair(int[] A, int sum)
    {
        // consider each element except last element
        for (int i = 0; i < A.length - 1; i++) //n
        {
            // start from i'th element till last element
            for (int j = i + 1; j < A.length; j++)  //n
            {
                // if desired sum is found, print it and return
                if (A[i] + A[j] == sum)
                {
                    System.out.println("Pair found at index " + i + " and " + j);
                    return;
                }
            }
        }

        // No pair with given sum exists in the array
        System.out.println("Pair not found");
    }

    public static void main (String[] args)
    {
        int[] A = { 8, 7, 2, 5, 3, 1 };
        int sum = 10;

        findPair(A, sum);
    }
}