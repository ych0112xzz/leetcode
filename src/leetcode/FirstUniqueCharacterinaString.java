package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/9/21.
 */
public class FirstUniqueCharacterinaString {
    public static void main(String[] args) {
        String s = "cc";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int result = -1;
        char[] data = s.toCharArray();
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 0) {
                count[s.charAt(i) - 'a'] = i + 1;
            } else {
                count[s.charAt(i) - 'a'] -= (i + 1);
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                result = result != -1 && result < count[i] - 1 ? result : count[i] - 1;
                // System.out.println(result);
            }
        }

        return result;
    }

//    public static int firstUniqChar(String s) {
//        HashMap<Character, Boolean> hashMap = new HashMap<>();
//        List<Character> list = new ArrayList<>();
//        int result = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (hashMap.containsKey(s.charAt(i))) {
//                hashMap.put(s.charAt(i), false);
//            } else {
//                hashMap.put(s.charAt(i), true);
//            }
//
//        }
//
//        result = s.length() - 1;
//        boolean isEm = true;
//        for (Character key : hashMap.keySet()) {
//            if (hashMap.get(key) == true) {
//                isEm = false;
//                result = result < s.indexOf(key) ? result : s.indexOf(key);
//            }
//
//        }
//        if (isEm) {
//            return -1;
//        }
//        return result;
//    }
}




