package leetcode;

import java.util.HashMap;

/**
 * Created by ych0112xzz on 2016/7/21.
 */
public class Longest_Substring {

    public static void main(String args[]) {
        //String s = "yangchengchenxinliuzheng";
        String s = "abbac";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashmap = new HashMap();
        if (s.length() == 0) {
            return 0;
        }

        int i = 0, j = 0;
        int tem = 0;
        int result = 0;
        while (j < s.length()) {
            char test = s.charAt(j);
            if (hashmap.containsKey(test)) {
                int len = j - i;
                result = (result > len) ? result : len;
                int index = hashmap.get(test);
                i = Math.max(i, index + 1);
                hashmap.put(test, j);

            } else {
                hashmap.put(test, j);
                //tem++;
            }
            j++;
        }
        if (result < j - i) {
            return j - i;
        }

        return result;
    }
}
