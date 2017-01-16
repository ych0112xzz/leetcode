package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/10/25.
 */

/*
* 使用hashmap
* */
/*
public class MinStack {
    Stack<Integer> stack;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int min = Integer.MAX_VALUE;
   // int size;
    public MinStack(){
        this.stack = new Stack<>();

    }

    */
/*
    * 注意min的改变
    * *//*

    public void push(int x){
        if(stack.size()==0){
            min=Integer.MAX_VALUE;
        }else{
            min = hashMap.get(stack.size());
        }
        stack.push(x);
        if(x<min){
            min = x;
        }
        hashMap.put(stack.size(), min);

    }
    public void pop(){
        hashMap.remove(stack.size());
        stack.pop();
    }
    public int top() {

        return stack.peek();
    }

    public int getMin(){
        return hashMap.get(stack.size());
    }
}
*/

/*
* 不用hashMap，关键在于min在top时，保留上一个min，用min=2x-min,
* */
/*
public class MinStack {
    private Stack<Long> s;
    private long min;
    */
/** initialize your data structure here. *//*

    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(long x) {
        if(s.isEmpty()){
            min = x;
            s.push(x);
        }else{
            if(x >= min) s.push(x);
            else{
                //the case when inserted x is smaller than current min
                s.push(2*x - min); //push 2*x - min instead of x into stack
                min = x; //set our new min val
            }
        }
    }

    public void pop() {
        long temp = s.pop();
        if(temp < min){
            //the case when the min element is removed from stack
            min = 2*min - temp; //restore the min
        }
    }

    public long top() {
        long temp = s.pop();
        s.push(temp);
        if(temp > min){
            return temp;
        }else{
            //the case when the top element is the min
            return min;
        }
    }

    public long getMin() {
        return min;
    }
}*/

/*
*直接用两个stack，一个用于存最小值，不需要min变量
* */
public class MinStack {

    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> pq = new Stack<Integer>();

    public MinStack() {

    }

    public void push(int x) {
        st.push(x);
        pq.push(Math.min(x,pq.size() > 0 ? pq.peek() : x));
    }

    public void pop() {
        st.pop();
        pq.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return pq.peek();
    }
}