/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut3;

// Java program to implement Queue using
// two stacks with costly deQueue()

import java.util.Stack;

class Queue_Ex2
{
    static class Queue
    {
        static Stack<Integer> s1 = new Stack<Integer>();
        static Stack<Integer> s2 = new Stack<Integer>();

        static void enQueue(int x) {
            // Push item into s1
            s1.push(x);
        }

        // Dequeue an item from the queue
        static int deQueue() {
            // if first stack is empty
            if (s1.isEmpty()) {
                System.out.println("Q is Empty");
                System.exit(0);
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            // Return top of s2
            int x = s2.peek();
            s2.pop();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return x;
        }
    };

    // Driver code
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}