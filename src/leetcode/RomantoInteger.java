package leetcode;

import java.util.HashMap;

/**
 * Created by ych0112xzz on 2016/9/9.
 */
public class RomantoInteger {

    public static void main(String[] args) {
        String s = "MCDXXXVII";
        int result = romanToInt(s);
        System.out.println(result);
    }


    public static int romanToInt(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        hashmap.put('I', 1);
        hashmap.put('V', 5);
        hashmap.put('X', 10);
        hashmap.put('L', 50);
        hashmap.put('C', 100);
        hashmap.put('D', 500);
        hashmap.put('M', 1000);
        int result = 0;
        boolean isOver = false;
        if (s.length() == 0) {
            return 0;
        }
        char c = s.charAt(0);
        result += hashmap.get(c);
        for (int i = 1; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (hashmap.get(tmp) > hashmap.get(c)) {
                result = result - hashmap.get(c) * 2 + hashmap.get(tmp);
                System.out.println(result);

//                if (++i < s.length()) {
//                    c = s.charAt(i);
//                    if (i == s.length() - 1) {
//                        result += hashmap.get(c);
//                    }
//                }

            } else {
                result += hashmap.get(tmp);
                System.out.println(result);
            }
            c = tmp;

        }


//        for (int i = 1; i < s.length(); i++) {
//
//            char tmp = s.charAt(i);
//           // isOver = false;
//           // System.out.println(c);
//            if(c=='I'||c=='X'||c=='C'){
//                if(hashmap.get(tmp)>hashmap.get(c)){
//                    result += hashmap.get(tmp) - hashmap.get(c);
//                   // System.out.println(result);
//                    if(++i<s.length()) {
//                        c = s.charAt(i);
//                       // isOver=true;
//                        if(i==s.length()-1){
//                            result += hashmap.get(c);
//                        }
//                    }
//                }else{
//                    result += hashmap.get(c);
//                    System.out.println(result);
//                    c=tmp;
//                    if(i==s.length()-1){
//                        result += hashmap.get(c);
//                    }
//                }
//            }else{
//                result += hashmap.get(c);
//                System.out.println(result);
//                c=tmp;
//                if(i==s.length()-1){
//                    result += hashmap.get(c);
//                }
//            }
//
//        }

        //System.out.println(isOver);
        return result;
    }
}
