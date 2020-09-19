/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut2;

public class Problems {
    public static void main(String[] args){
        int n=10;
        Problem1(n);
        Problem2(n);
        Problem3(n);

    }
   public static void Problem1(int n){
        if(n==1)
            return;
        /* Outer loop executes n times. */
        for(int i=1; i<=n; i++){
            /* Inner loop executes only one time due to break statement. */
            for(int j=1;j<=n;j++){
                System.out.print("*");
                break;
            }
        }
   }

    public static void Problem2(int n){
        int count =0;
        for(int i=n/2; i<=n; i++){ /* Outer loop executes n/2 times. */
            for(int j=1;(j+(n/2))<=n;j++){/* Middle loop executes n/2 times.*/
                for(int k=1;k<=n;k=k*2){ /* Inner loop executes log n times. */
                    count++;
                }
            }
        }
        System.out.println("\n"+count);
    }
    public static void Problem3(int n){
        int count =0;
        for(int i=n/2; i<=n; i++){ /* Outer loop executes n/2 times. */
            for(int j=1;j<=n;j*=2){/* Middle loop executes log n times.*/
                for(int k=1;k<=n;k=k*2){ /* Inner loop executes log n times. */
                    count++;
                }
            }
        }
        System.out.println("\n"+count);
    }
}
