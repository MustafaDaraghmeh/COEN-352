/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut3;
import java.util.LinkedList;
import java.util.Queue;
public class QueueDemo1 {
    public static void main(String []er) {
        //creating instance of LinkedList to decalre methods of Queue
        Queue<String>q=new LinkedList<String>();

        //adding elements into queue

        q.add("AI");
        q.add("DS");
        q.add("Java");
        //also used to add element
        q.offer("Machine Learning");
        q.add("App Development");
        System.out.println("Elements in Queues are:"+q);

        //offer: It also adds the specified element to the queue. It performs the same work as the add() method.

        //remove the head element of the queue
        q.remove();

        System.out.println("Elements in Queues are after using remove method:"+q);

        //removing element using poll method
        q.poll();
        //The poll() method is similar to remove () method,
        // but the only difference is poll () returns null if the queue is empty.

        System.out.println("Elements in Queues are after using poll method:"+q);

        //using peek method
        System.out.println("The head element of queue is (using peek () method) :"+q.peek());

        //using element() method
        System.out.println("The head element of queue is (using element() method):"+q.element());
        //An element() method also returns the head of the queue.
        // But difference b/w element () method and peek() returns null if the queue is empty.
    }
}