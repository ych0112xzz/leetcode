package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/7/22.
 */
public class LetterCombinationsofaPhoneNumber {
    private static final char[][] charMap = {
            {}, // 0
            {}, // 1
            {'a', 'b', 'c'}, //2
            {'d', 'e', 'f'}, //3
            {'g', 'h', 'i'}, //4
            {'j', 'k', 'l'}, //5
            {'m', 'n', 'o'}, //6
            {'p', 'q', 'r', 's'}, //7
            {'t', 'u', 'v'}, //8
            {'w', 'x', 'y', 'z'}, //9
    };

    public static void main(String[] args) {
        String digits = "";
        List<String> list = letterCombinations(digits);
        System.out.println(list);
        if(list!=null) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }


    /*public static List<String> letterCombinations(String digits) {


        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(digits.length()==0){

            return list;
        }
        int i = 0;
        letterCombinations(digits, i, sb, list);
        return list;
    }


    public static void letterCombinations(String digits, int i, StringBuilder sb, ArrayList<String> list) {
        if (i >= digits.length()) {
            list.add(sb.toString());
            return;
        } else {
            int index = Integer.parseInt(String.valueOf(digits.charAt(i)));
            char[] data = charMap[index];
            for (int j = 0; j < data.length; j++) {
                sb.append(data[j]);
                letterCombinations(digits, i + 1, sb, list);
                sb.deleteCharAt(sb.length() - 1);//循环结束取出最后一个元素,在循环体中用的是同一个sb
            }
        }
    }*/


    /*
    * DFS
    * */
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    /*public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.length() == 0) {
            return result;
        }
        letterCombinations("", 0, digits, result);
        return result;
    }

    private static void letterCombinations(String s, int i, String digits, List<String> result) {
        if (i >= digits.length()) {
            result.add(s);
            return;
        }
        String data = KEYS[digits.charAt(i) - '0'];
        for(int j=0;j<data.length();j++) {
            letterCombinations(s + data.charAt(j), i + 1, digits, result);
        }
    }*/

    /*
    * BFS
    * */
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> deque = new LinkedList<>();
        if (digits.length() == 0) {
            return deque;
        }
        deque.offer("");
        char[] data = digits.toCharArray();
        for(int i=0;i<data.length;i++) {
            int size = deque.size();
            while (size-- > 0) {
                String prefix = deque.poll();
                String tmp = KEYS[data[i]-'0'];
                for(int j=0;j<tmp.length();j++) {
                    deque.offer(prefix + tmp.charAt(j));
                }
            }
        }
        return deque;
    }
}
