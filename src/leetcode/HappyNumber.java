package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/9/20.
 */
public class HappyNumber {

    public static void main(String[] args){
        int n =19;
        System.out.println(isHappy(n));
    }
    public static boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        int result = n;
        while(result!=1){
            int val = 0 ;
            while( result > 0 ){
                int tempMul = result % 10;
                val += (tempMul * tempMul);
                result = result / 10;
            }
            result=val;
//            String s = String.valueOf(result);
//            result = 0;
//            for(int i=0;i<s.length();i++){
//                result += (s.charAt(i) - '0') * (s.charAt(i) - '0');
//            }
            if(list.contains(result)){
                return false;
            }else {
                list.add(result);
            }
        }
        return true;
    }
}
