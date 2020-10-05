package coen352.tut4;

public class FibonacciNumberUsingRecursion {

    /**
     * @param args
     * @author Umashankar

     */
    public static void main(String[] args) {
        //fibonacci series --> 0,1,1,2,3,5,8,13. . . .
        //fibonacciNumber(0) represents 0th fibonacci number, fibonacciNumber(6) represents 5th fibonacci number with zero based index. i.e., 8
        System.out.println("Fibonacci Series for 10 numbers");
        int fibonacciSeriesLength = 10;
        for (int i = 0; i < fibonacciSeriesLength; i++) {
            int temp= fibonacciNumber(i);
            System.out.print( temp + ",");
        }
    }

    /**
     * <p>Fibonacci Number using Recursion</p>
     * fib(n)    = 0  if(n=0)
     * = 1  if(n=1)
     * = fib(n-1)+fib(n-2)
     *
     * @param n
     * @return
     */
    public static int fibonacciNumber(int n) {
        //fibonacci series --> 0,1,1,2,3,5,8,13. . . .
        //base cases
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {   //recursive case
            return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
        }
    }

}