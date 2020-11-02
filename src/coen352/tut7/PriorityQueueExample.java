/*
 *  2020. Mustafa Daraghmeh.
 */

/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut7;
//We use PriorityQueue class to implement Heaps in Java.
// By default Min Heap is implemented by this class.
// To implement Max Heap, we use Collections.reverseOrder()//
//
// Java program to demonstrate working of PriorityQueue
// as a Max Heap

import java.util.*;

class PriorityQueueExample {

    public static void main(String[] args)
    {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue =
                new PriorityQueue<>(Collections.reverseOrder());

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(30);
        pQueue.add(20);
        pQueue.add(400);

        // Printing the most priority element
        System.out.println("Head value using peek function:" +
                pQueue.peek());

        // Printing all elements
        System.out.println("The queue elements:");
        for (Integer integer : pQueue) System.out.println(integer);

        // Removing the top priority element (or head) and
        // printing the modified pQueue using poll()
        pQueue.poll();
        System.out.println("After removing an element "
                + "with poll function:");
        for (Integer integer : pQueue) System.out.println(integer);

        // Removing 30 using remove()
        pQueue.remove(30);
        System.out.println("after removing 30 with"
                + " remove function:");
        for (Integer integer : pQueue) System.out.println(integer);

        // Check if an element is present using contains()
        boolean b = pQueue.contains(20);
        System.out.println("Priority queue contains 20 "
                + "or not?: " + b);

        // Getting objects from the queue using toArray()
        // in an array and print the array
        Object[] arr = pQueue.toArray();
        System.out.println("Value in array: ");
        for (Object o : arr) System.out.println("Value: " + o.toString());
    }
}
