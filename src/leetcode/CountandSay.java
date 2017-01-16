package leetcode;

/**
 * Created by ych0112xzz on 2016/7/26.
 */
public class CountandSay {
    public static void main(String[] args) {
        int n = 2;
        String result = countAndSay(5);
        System.out.println(result);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        int length = 0;
        char temp = '0';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (temp != s.charAt(i)) {
                if (i > 0) {
                    sb.append(String.valueOf(length) + String.valueOf(temp));
                }
                temp = s.charAt(i);
                length = 1;
            } else {
                length++;
            }
        }
        sb.append(String.valueOf(length) + String.valueOf(temp));
        return sb.toString();
    }
}
