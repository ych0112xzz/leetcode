package leetcode;

/**
 * Created by ych0112xzz on 2017/3/4.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int dp[]=new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int tmp= (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int pos1=i+j;
                int pos2=i+j+1;
                int sum=tmp+dp[pos2];
                dp[pos1] +=sum/10;
                dp[pos2] =sum%10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int p : dp) {
            if(!(sb.length() == 0 && p == 0)) sb.append(p);
        }

        return sb.length() == 0 ? "0" : sb.toString();

    }
}
