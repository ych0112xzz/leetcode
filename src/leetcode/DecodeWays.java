package leetcode;

/**
 * Created by ych0112xzz on 2016/11/7.
 */
public class DecodeWays {

    public static void main(String[] args) {
        String s = "1011034222200";
        System.out.println(new DecodeWays().numDecodings(s));

    }

    public int numDecodings(String s) {
        if (s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        result[1] = 1;
        char[] data = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            char prev = data[i - 1];
            char cur = data[i];
            char next = '1';
            String tmp = s.substring(i - 1, i + 1);
            if (i < data.length - 1) {
                next = data[i + 1];
            }
            if ((cur == '0' && prev == '0') || (cur == '0' && next == '0')) {
                return 0;
            }
            if (cur == '0'&&Integer.valueOf(tmp) <= 26) {
                result[i + 1] = result[i - 1];
            } else if(cur=='0'&&Integer.valueOf(tmp)>=26){
                return 0;
            }else if (Integer.valueOf(tmp) > 26||prev=='0') {
                result[i + 1] = result[i];
            }  else {
                result[i + 1] = result[i] + result[i - 1];
            }
        }
        return result[s.length()];
    }

    /*
    *
    * 使用正则表达式匹配
    * */
   /* public int numDecodings(String s) {
        if (s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        if(s.matches(".*0{2,}.*")||s.matches(".*[3-9]0.*")){
           // System.out.println("yes");
            return 0;
        }
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        result[1] = 1;
        char[] data = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            char prev = data[i - 1];
            char cur = data[i];
            String tmp = s.substring(i - 1, i + 1);
            if (cur == '0'&&Integer.valueOf(tmp) <= 26) {
                result[i + 1] = result[i - 1];
            }else if (Integer.valueOf(tmp) > 26||prev=='0') {
                result[i + 1] = result[i];
            } else {
                result[i + 1] = result[i] + result[i - 1];
            }
        }
        return result[s.length()];
    }*/

    /*
    * dp从后向前遍历
    * */
   /* public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;//memo[n-1]表示s只有一个字符

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }*/

}
