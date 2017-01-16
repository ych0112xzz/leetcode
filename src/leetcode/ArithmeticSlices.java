package leetcode;

/**
 * Created by ych0112xzz on 2016/11/3.
 */
public class ArithmeticSlices {



   /* public int numberOfArithmeticSlices(int[] A) {

        int n = A.length;
        if(n==0||n==1||n==2){
            return 0;
        }
        int result = 0;
        int number = 2;
        //int tmpValue = A[0];
        int diff = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(A[i]-A[i-1]!=diff){
                diff = A[i] - A[i - 1];
                result += calNumber(number);
                number = 2;
            }else{
                number++;
            }
        }
        result += calNumber(number);
        return result;
    }


    public int calNumber(int n){
        if(n<=2){
            return 0;
        }
        return (n - 2) * (n - 1) / 2;
    }*/

    /*
    * 较为精巧的方法
    * */
    /*public int numberOfArithmeticSlices(int[] A) {
        int ret  = 0, i, j;
        for(i=1;i<A.length;i=j) {
            for(j=i+1; j<A.length && A[j] - A[j-1] == A[i] - A[i-1];++j);
            ret += (j-i)*(j-i-1)/2;
        }
        return ret;
    }*/

    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }




}
