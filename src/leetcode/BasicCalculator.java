package leetcode;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ych0112xzz on 2016/9/28.
 */
public class BasicCalculator {

    public static void main(String[] args) {
        String s = "2147483647";
        System.out.println(new BasicCalculator().calculate(s));
    }

//    public static int calculate(String s){
//        Pattern p = Pattern.compile("(\\()?((\\d+)(\\(|\\)|\\+|\\-))+");
//        Matcher m = p.matcher(s);
//        while(m.find()){
//            System.out.println(m.group());
//        }
//
//        return 0;
//    }

    public int calculate(String s) {
        int result = 0;


        Stack<Integer> stack = new Stack<>();
        char[] data = s.replaceAll(" ", "").toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == '(' || data[i] == '+' || data[i] == '-') {
                stack.push(data[i] - '0');
                System.out.println(stack.peek());
            } else if (data[i] == ')') {
                int tmp = stack.pop();
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(tmp);
                    continue;
                }
                int op = stack.peek() + '0';
                if (op == '+' || op == '-') {
                    stack.pop();
                    int preTmp = stack.pop();
                    System.out.println(preTmp);
                    if (op == '+') result = preTmp + tmp;
                    else result = preTmp - tmp;
                    stack.push(result);
                    System.out.println(stack.peek());
                } else {
                    stack.push(tmp);
                }
            } else {

                int dataTmp = 0;
                while (i<data.length&&data[i]>=48&& data[i] <= 57) {
                    dataTmp = dataTmp * 10 + data[i] - '0';
                    System.out.println(dataTmp);
                    i++;
                }
                i--;
                // System.out.println(op);
                if(stack.isEmpty()){
                    stack.push(dataTmp);
                    continue;
                }
                else {
                    int op = stack.peek() + '0';
                    if (op == '+' || op == '-') {
                        stack.pop();
                        int tmp = stack.pop();
                        if (op == '+') result = tmp + dataTmp;
                        else result = tmp - dataTmp;

                        stack.push(result);
                        System.out.println(stack.peek());
                    } else {
                        stack.push(dataTmp);
                        System.out.println(stack.peek());
                    }
                }

            }
        }
//        for(int i =0;i<stack.size();i++){
//            System.out.println(stack.pop());
//        }
        return stack.pop();
    }
}
