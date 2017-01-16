package leetcode;

/**
 * Created by ych0112xzz on 2016/10/17.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man,,$ a plan, a canal: Panama";
        System.out.println(new ValidPalindrome().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0||s.length()==1) {
            return true;
        }
        s = s.replaceAll("[\\pP\\pS\\pZ]+", "").toLowerCase();
        System.out.println(s);
        char[] data = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (data[start] != data[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        // String tmp = new StringBuilder(s).reverse().toString();
        return true;
    }
}
