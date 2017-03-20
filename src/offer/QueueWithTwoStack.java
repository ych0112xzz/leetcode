package offer;

import java.util.Stack;

/**
 * Created by ych0112xzz on 2017/3/13.
 */
public class QueueWithTwoStack {
    Stack<Integer> in ;
    Stack<Integer> out;
    /** Initialize your data structure here. */
    public QueueWithTwoStack() {
        in=new Stack<>();
        out=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result=0;
        /*if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }*/
        peek();
        result=out.pop();
        return result;
    }

    /** Get the front element. */
    public int peek() {
        int result=0;
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        result=out.peek();
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }
}
