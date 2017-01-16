package test;

import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/7/26.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        long start = System.nanoTime();
        String s = "{}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[](){}[]()";
        boolean is = isValid(s);
        long end = System.nanoTime();
        System.out.println(is);
        System.out.println(end - start + "ns");
    }

    public static boolean isValid(String s) {
        int len = s.length();
        if (len == 0)
            return true;
        Stack<Character> st = new Stack<Character>();
        st.add(s.charAt(0));
        int i = 1;
        while (i < len) {
            switch (s.charAt(i)) {
                case '(':
                    st.add('(');
                    break;
                case ')':
                    if (!st.empty() && st.peek() == '(') {
                        st.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    st.add('{');
                    break;
                case '}':
                    if (!st.empty() && st.peek() == '{') {
                        st.pop();
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    st.add('[');
                    break;
                case ']':
                    if (!st.empty() && st.peek() == '[') {
                        st.pop();
                    } else {
                        return false;
                    }
                    break;
            }
            i++;
        }
        return st.empty();
    }
}
