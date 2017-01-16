package leetcode;

/**
 * Created by ych0112xzz on 2016/10/28.
 */
public class SumofTwoIntegers {

    public static void main(String[] args) {
        int a = -2147483648;
        int b = -2;
        System.out.println(new SumofTwoIntegers().div(a, b));
    }

    /*
    * 递归
    * */
    /*public int getSum(int a, int b) {
        if(b==0){
            return a;
        }
        int sum,carry;
        sum = a ^ b;
        carry = (a & b) << 1;
        return getSum(sum,carry);
    }*/

    public int getSum(int a, int b) {
        /*return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);*/
        while (b != 0) {
            int sum;
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;

        }
        return a;
    }

    public int sub(int a, int b) {
        return getSum(a, getSum(~b, 1));
    }

    int mul(int a, int b) {
        boolean flag = false;
        if (getSign(a) == getSign(b)) {
            flag = true;
        }
        a = getPositive(a);
        b = getPositive(b);
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = getSum(ans, a);
                //  System.out.println(a+"\t"+b+"\t"+ans);
            }
            a <<= 1;
            b >>= 1;
        }
        return flag == true ? ans : getNegtive(ans);
    }

    int div(int a, int b) {
        boolean flag = false;
        if (getSign(a) == getSign(b)) {
            flag = true;

        }
        int ans = 0;
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        }
        if (b == Integer.MIN_VALUE) {
            return 0;
        }
        if(a==Integer.MIN_VALUE){
            if(b==-1){
                return Integer.MAX_VALUE;
            }
            ans = 1;
            a = getSum(a,getPositive(b));
        }
        a = getPositive(a);
        b = getPositive(b);

        for (int i = 31; i >= 0; i--) {
            if (b <= (a >> i)) {
                ans = getSum(ans, 1 << i);
                a = sub(a, b << i);
            }
        }
        return flag == true ? ans : getNegtive(ans);
    }

    int getNegtive(int i) {
        return getSum(~i, 1);
    }

    int getSign(int i) {
        return (i >> 31);
    }

    int getPositive(int i) {

        if ((i >> 31) != 0) {//不能用>0判断，负数移位后为-1，因其高位补零。
            return getNegtive(i);
        } else {
            return i;
        }
    }


}
