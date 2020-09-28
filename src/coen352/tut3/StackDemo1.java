/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut3;
import java.util.Stack;

class StackDemo1 {
    public static void main(String a[]){
        Stack<Integer> stack = new Stack<Integer>();
        if(stack==null){
            //out of memory
             }
        System.out.println("Empty stack : "  + stack);
        System.out.println("Empty stack : "  + stack.isEmpty());

        stack.push(100);
        stack.push(102);
        stack.push(103);
        stack.push(104);

        System.out.println("Stack elements are : "  + stack);
        System.out.println("Stack: Pop Operation : "  + stack.pop());
        System.out.println("Stack: After Pop Operation : "  + stack);
        System.out.println("Stack : search() Operation : "  + stack.search(100));
        System.out.println("If Stack is empty : "  + stack.isEmpty());
    }
}
