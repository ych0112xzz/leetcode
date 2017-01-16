package leetcode;

/**
 * Created by ych0112xzz on 2016/9/28.
 */
public class IntegerReplacement {
    public static void main(String[] args){
        int n=2147483647;
        System.out.println(integerReplacement(n));

    }


    /*
    * 递归
    * */

    /*public static int integerReplacement(int n) {
        if(n==1){
            return 0;
        }
        if(n==Integer.MAX_VALUE){
            return 32;
        }
        if(n%2==0){
            return integerReplacement(n / 2) + 1;
        }else{
            return Math.min(integerReplacement(n + 1), integerReplacement(n - 1))+1;
        }
    }*/

    /*
    * 循环，n+1能被4整除，选择n+1，否则选择n-1
    * */
    public static int integerReplacement(int n) {
        if(n==1){
            return 0;
        }
        if(n==Integer.MAX_VALUE){
            return 32;
        }
        int count = 0;
        while(n!=1) {
            if (n % 2 == 0) {
                n /= 2;

            }else{
                if((n+1)%4==0&&n!=3){
                    n += 1;
                }else{
                    n -= 1;
                }
            }
            count++;
        }
        return count;
    }

}
