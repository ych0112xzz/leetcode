package leetcode;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by ych0112xzz on 2016/7/26.
 */
public class ValidParentheses {

    public static void  main(String[] args){
        long start =System.nanoTime();
        String s="{}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[]()";
        boolean is = isValid(s);
        System.out.println(is);
        long end = System.nanoTime();
        System.out.println(end-start+"ns");
    }

   /* public static boolean isValid(String s) {
        char[] data = new char[s.length()];
        int top=-1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='{'||c=='['||c=='('&&top<s.length()/2){
                data[++top]=c;
            }else if(c=='}'&&top!=-1){
                char temp=data[top];
                if (temp =='{') {
                    top--;
                }else{
                    return false;
                }
            }else if(c==']'&&top!=-1){
                char temp=data[top];
                if (temp =='[') {
                    top--;
                }else{
                    return false;
                }
            }else if(c==')'&&top!=-1){
                char temp=data[top];
                if (temp =='(') {
                    top--;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        if(top==-1){
            return true;
        }else{
            return false;
        }

    }*/

    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        char[] data=s.toCharArray();
        for(int i=0;i<data.length;i++){
            if(data[i]=='('||data[i]=='{'||data[i]=='['){
                stack.push(data[i]);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char c=stack.pop();
                if((data[i]=='}'&&c!='{')||(data[i]==']'&&c!='[')||(data[i]==')'&&c!='(')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
