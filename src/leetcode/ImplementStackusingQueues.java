package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ych0112xzz on 2017/3/13.
 */
public class ImplementStackusingQueues {
    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();
    public void push(int x) {
        if(q1.isEmpty()) {
            q1.add(x);
            for(int i = 0; i < q2.size(); i ++)
                q1.add(q2.poll());
        }else {
            q2.add(x);
            for(int i = 0; i < q1.size(); i++)
                q2.add(q1.poll());
        }
    }

    public void pop() {
        if(!q1.isEmpty())
            q1.poll();
        else
            q2.poll();
    }
    public int top() {
        return q1.isEmpty() ? q2.peek() : q1.peek();
    }
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
