/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut2;

public class ElapsedTimeTest {

    public static void main(String[] args) {

        // TimeType.seconds, TimeType.milliSeconds, TimeType.nanoSeconds
        StopWatch watch = new StopWatch(TimeType.nanoSeconds);
        watch.start();
        // some code
        watch.stop();
        System.out.println(watch.getTime());

        long startMillis= System.currentTimeMillis();
        {
            // some code
        }
        long endMillis= System.currentTimeMillis();
        System.out.println("Elapsed Time in Millis is: "
                +(endMillis-startMillis));

        long startNano=System.nanoTime();
        {
            //some code
        }
        long endNano=System.nanoTime();
        System.out.println("Elapsed Time in Nano is: "
                + (endNano-startNano));
    }
}
