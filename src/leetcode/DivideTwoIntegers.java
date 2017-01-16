package leetcode;

/**
 * Created by ych0112xzz on 2016/7/26.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        int divided = -2147483648;
        int divisor = -2;
        int quotients = divide(divided, divisor);
        System.out.println(quotients);
    }
/*
    public static int divide(int dividend, int divisor) {
        boolean isNegative = false;
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        if (divisor == 0) {
            return 0;
        }
        if (dividend == MIN && divisor == -1) {
            return MAX;
        }

        if ((dividend < 0 && divisor > 0) || (dividend > 0) && divisor < 0) {
            isNegative = true;
        }
        //注意类型转换
        long dividedValue = Math.abs((long)dividend);
        long divisorValue = Math.abs((long)divisor);
        //System.out.println(dividedValue);
        long quotients = 1l;
        long cnt=1l;
        long temp = divisorValue;
//        while (temp <= dividedValue) {
//            quotients++;
//            temp = temp+divisorValue;
//
//        }
       while(true){
           if(dividedValue<divisorValue){
               quotients -=1l;
               break;
           }
           temp<<=1;
           if(temp<=dividedValue){
               cnt<<=1;
               quotients=quotients+(cnt>>1);
           }else{
               temp>>=1;
               dividedValue -=temp;
               temp=divisorValue;
               cnt=1l;
               quotients+=1l;

           }
       }
        if (isNegative) {
            return 0 - (int) (quotients);
        } else {
            return (int) quotients;
        }
    }*/


    /*
    * 位运算
    * */
    public static int divide(int dividend, int divisor) {
        boolean flag = false;
        if (dividend >> 31 == divisor >> 31) {
            flag = true;
        }
        int result = 0;
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if(dividend==Integer.MIN_VALUE){
            if(divisor==-1){
                return Integer.MAX_VALUE;
            }
            result = 1;
            dividend = dividend + Math.abs(divisor);
        }

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        System.out.println(a+"\t"+b);

        for (int i = 31; i >= 0; i--) {
            if (b <= a >> i) {
                result += (1<<i);
                a = a - (b << i);
            }
        }
        return flag == true ? result : (0-result);

    }
}
