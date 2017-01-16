package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/9/22.
 */
public class FindtheDifference {

    //    public static char findTheDifference(String s, String t) {
//        char c = 'A';
//        char[] as = s.toCharArray();
//        char[] at = t.toCharArray();
//        Arrays.sort(as);
//        Arrays.sort(at);
//        for(int i=0;i<as.length;i++){
//            if(as[i]!=at[i]){
//                c = at[i];
//                break;
//            }
//        }
//        return c=='A'?at[at.length-1]:c;
//    }


    public static char findTheDifference(String s, String t) {
        char c = 'A';
        int[] data=new int[26];
        char[] as = s.toCharArray();
        char[] at = t.toCharArray();
        for(int i=0;i<as.length;i++){
            data[as[i]-'a']++;
        }

        for(int i=0;i<at.length;i++){
            data[at[i] - 'a']--;
            if(data[at[i]-'a']<0){
                c=at[i];
                break;
            }
        }
        return c;
    }

   /* public static char findTheDifference(String s, String t) {
        int result = 0;
        char[] as = s.toCharArray();
        char[] at = t.toCharArray();
        for (int i = 0; i < as.length; i++) {
            result ^= as[i];
        }

        for (int i = 0; i < at.length; i++) {
            result ^= at[i];
        }
        return (char) result;
    }*/
}
