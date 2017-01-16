package leetcode;

/**
 * Created by ych0112xzz on 2016/9/20.
 */
public class UglyNumber {
    public static void main(String[] args){
        int num =12;
        System.out.println(isUgly(num));
    }
    public static boolean isUgly(int num) {
        if(num==1){
            return true;
        }
        while(num%2==0){
            num /=2;
        }
        while(num%3==0){
            num /=3;
        }
        while(num%5==0){
            num /= 5;
        }
        return num==1;
    }
}
