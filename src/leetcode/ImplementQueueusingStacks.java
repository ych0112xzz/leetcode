package leetcode;

import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/10/20.
 */
public class ImplementQueueusingStacks {

    Stack<Integer> back = new Stack<>();
    Stack<Integer> front = new Stack<>();

    // Push element x to the back of queue.
    //或者重写push方法
    public void push(int x) {
        back.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!front.isEmpty()){
            front.pop();
        }else {
            while (!back.isEmpty()) {
                front.push(back.pop());
            }
            front.pop();
        }


    }

    // Get the front element.
    public int peek() {
        if(!front.isEmpty()){
            return front.peek();
        }
        while(!back.isEmpty()){
            front.push(back.pop());
        }
        return front.peek();

    }

    // Return whether the queue is empty.
    public boolean empty() {

        return back.isEmpty()&&front.isEmpty();
    }

}
