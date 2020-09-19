/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut2;

enum TimeType {

    nanoSeconds, milliSeconds, seconds
}

public class StopWatch {

    public StopWatch(TimeType _timeType) {
        start= 0;
        end=  0;
        timeType=_timeType;
    }

    public void start() {
        if (timeType==TimeType.nanoSeconds)
            start = System.nanoTime();
        else
            start = System.currentTimeMillis();
    }

    public void stop() {
        if (timeType==TimeType.nanoSeconds)
            end = System.nanoTime();
        else
            end = System.currentTimeMillis();
    }

    public long getTime() {
        if (timeType==TimeType.seconds)
            return ((end-start)/1000);
        else
            return end-start;
    }
    long start;
    long end;
    TimeType timeType;
}
