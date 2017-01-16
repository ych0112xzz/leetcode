package leetcode;




import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ych0112xzz on 2016/9/19.
 */
public class ValidAnagram {

    public static void main(String[] args){
        String s ="a";
        String t="b";
        System.out.println(isAnagram(s,t));
    }

    public  static boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        //StringBuilder sb = new StringBuilder(s);
       // StringBuilder st = new StringBuilder(t);
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
        //return String.valueOf(s1).equals(String.valueOf(t1));
        //System.out.println(s1.toString());
        //System.out.println(t1.toString());
        //st.reverse();
//        int size = s1.length;
//        for(int i=0;i<size;i++){
//            System.out.println(s1[0]);
//            System.out.println(t1[0]);
//           if(s1[i]!=t1[i]){
//               return false;
//           }
//        }
//        return true;
    }
}
