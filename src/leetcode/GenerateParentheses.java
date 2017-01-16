package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/12/26.
 */
public class GenerateParentheses {
    /*
    * DFS
    * */
    /*public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        String tmp = "";
        int pre = 0;
        int next = 0;
        generateParenthesis(n, result, tmp, pre,next);
        return result;
    }

    private void generateParenthesis(int n, List<String> result, String str, int pre,int next) {
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }
        if (pre < n) {
            generateParenthesis(n,result, str + "(", pre + 1,next);
        }
        if (next < pre) {
            generateParenthesis(n,result, str + ")", pre,next+1);
        }
    }*/


    /*DP
    * f(0): ""

    f(1): "("f(0)")"

    f(2): "("f(0)")"f(1), "("f(1)")"

    f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"

    So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"
    * */
    /*public List<String> generateParenthesis(int n) {
        List<List<String>> result = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add("");
        result.add(list);
        for (int i = 1; i <= n; i++) {
            list = new ArrayList<>();
            for(int j=0;j<i;j++) {
                for (String pre : result.get(j)) {
                    for (String next : result.get(i - 1 - j)) {
                        list.add("(" + pre + ")" + next);
                    }
                }
            }
            result.add(list);
        }
        return result.get(result.size() - 1);
    }*/


    /*
    *
    * */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();

        int i = 0;
        int open = n-1;
        int closed = n;
        char[] chars = new char[n*2+1];
        chars[i++] = chars[i++] = '(';

        while (chars[0] == '(') {
            if (open > 0) {
                chars[i++] = '(';
                open-- ;
            } else if (closed > 0 && open < closed) {
                chars[i++] = ')';
                closed-- ;
            } else {
                // Save result
                result.add(new String(chars, 1, n*2));

                // Find next open parenthesis which is possible
                // to replace with closed parenthesis
                while ((chars[--i] == ')' || (chars[i] == '(' && closed - open == 1))) {
                    if (chars[i] == ')') {
                        closed++;
                    } else {
                        open++;
                    }
                }
                chars[i++] = ')';
                closed--;
                open++;
            }
        }
        return result;
    }
}
