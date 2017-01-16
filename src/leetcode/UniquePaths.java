package leetcode;

/**
 * Created by ych0112xzz on 2016/11/4.
 */
public class UniquePaths {


    public static void main(String[] args) {
        int m = 8;
        int n = 9;
        System.out.println(new UniquePaths().uniquePaths(m, n));
    }

    /*public int uniquePaths(int m, int n) {

        int data = (m - 1) + (n - 1);
        if (data == 0) {
            return 1;
        }
        if (data == 1) {
            return 1;
        }
        int superScript = (m - 1) > (n - 1) ? (n - 1) : (m - 1);
        int divisor = 1;
        int divided = 1;
        int result = 1;
        for (int i = 1; i <= superScript; i++) {
            divided = (data - i + 1);
            divisor = i;
            int tem = getnumber(result, divisor);
            divisor /= tem;
            result /= tem;
            result = divided / divisor * result;

            //System.out.println(result + "\t" + divided + "\t" + divisor);
        }
        return result;
    }

    public int getnumber(int up, int down)//求最大公约数
    {
        int min;
        int tem = 1;
        min = (up < down) ? up : down;
        for (int i = 1; i <= min; i++) {
            if (up % i == 0 && down % i == 0)
                tem = i;
        }
        return tem;
    }*/

    /*public int uniquePaths(int m, int n) {
    *//*
    Dynamic Programming
    Bottom-up approach
    If we use Num[n] to denote the number of paths and we fill this form from left to right, we will never rewrite a value before we make use of it.
    O(mn) time and O(n) space
    *//*
        if (m == 0 || n == 0) {
            return 0;
        }

        int[] Num = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    Num[j] = 1;
                } else {
                    Num[j] += Num[j - 1];
                }
            }
        }

        return Num[n - 1];
    }*/


    /*
    * 递归
    * */

    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
}
