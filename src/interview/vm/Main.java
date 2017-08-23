package interview.vm;

import java.util.Scanner;

/**
 * Created by ych0112xzz on 2017/3/29.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int y = cal(x);
       // System.out.println(solve(y));
        System.out.println(y);
    }


    public static int cal(int x) {
        int start=0;
        int end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (solve(mid) < x) {
                start=mid+1;
            } else if (solve(mid) > x) {
                end = mid-1;
            }else{

                while(solve(mid)==x){

                    mid--;

                }
                return mid+1;
            }
        }
        return -1;
    }

    public static int solve(int n) {
        int sum = 0;
        while(n / 5 != 0)
        {
            sum += (n / 5);
            n /= 5;
        }
        return sum;
    }
}
