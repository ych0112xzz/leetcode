package leetcode;

import java.util.Stack;

/**
 * Created by ych0112xzz on 2017/5/4.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = ")";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }
   /* public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] data = s.toCharArray();
        int i = 0;
        int res = 0;
        while (i < data.length) {
            if (data[i] == '(') {
                stack.push(i);
            }else{
                if (!stack.isEmpty()) {
                    if (data[stack.peek()] == '(') {
                        stack.pop();
                    }else{
                        stack.push(i);
                    }
                }else{
                    stack.push(i);
                }
            }
            i++;
        }
        if (stack.isEmpty()) {
            res = data.length;
        }else{
            int a = data.length;
            int b = 0;
            while (!stack.isEmpty()) {
                b = stack.pop();
                res = Math.max(res, a - b - 1);
                a = b;
            }
            res = Math.max(res, a);
        }
        return res;
    }*/
   public int longestValidParentheses(String s) {
       int res = 0;
       int left = -1;
       Stack<Integer> stack = new Stack<>();
       for(int i=0;i<s.length();i++) {
           if (s.charAt(i) == '(') {
               stack.push(i);
           }else{
               if(stack.isEmpty()){
                   left = i;
               }else{
                   stack.pop();
                   if (stack.isEmpty()) {
                       res = Math.max(res, i - left);
                   }else{
                       res = Math.max(res, i - stack.peek());
                   }
               }
           }
       }
       return res;
   }
}
