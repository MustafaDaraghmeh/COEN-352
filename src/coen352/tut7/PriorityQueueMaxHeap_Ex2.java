/*
 *  2020. Mustafa Daraghmeh.
 */

/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut7;

// Java program to demonstrate the working of PriorityQueue Max Heap
import java.util.Collections;
import java.util.PriorityQueue;
class PriorityQueueMaxHeap_Ex2 {
    // Main Method
    public static void main(String[] args)
    {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);
        pQueue.add(150);
        pQueue.add(5);
        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());
        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());
        // Printing the top element again
        System.out.println(pQueue.peek());
    }
}

