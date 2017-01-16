package leetcode;

/**
 * Created by ych0112xzz on 2016/7/25.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int x = -2147483648;
        boolean is = isPalindrome(x);
        System.out.println(is);
    }

    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int num = reverseInteger(x);
        if (x == num) {
            return true;
        }

        return false;
    }


    public static int reverseInteger(int x) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        System.out.println(MAX + "\t" + MIN);
        if (x == 0 || x == MIN) {
            return 0;
        } else {
            int num = Math.abs(x);
            int result = 0;
            while (num > 0) {
                if (result > (MAX - num % 10) / 10) {//10result+num%10>MAX判断溢出
                    return 0;
                }
                int res = num % 10;
                int data = num / 10;
                result = result * 10 + res;
                num = data;
            }
            if (x < 0) {
                return result * (-1);
            } else {
                return result;
            }
        }
    }
}
