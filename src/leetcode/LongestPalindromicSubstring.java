package leetcode;

/**
 * Created by ych0112xzz on 2016/7/22.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        String word = longestPalindrome(s);
        System.out.println(word);
        long endTime=System.currentTimeMillis();
        System.out.println("RUN Time:"+(endTime-startTime)+"ms");
    }

    /*
    暴力解法
     */
   /* public static String longestPalindrome(String s) {
        //int start=0;
        //int end=s.length()-1;
        String result;
        int len = 0;
        String word = null;
        for (int start = 0; start < s.length(); start++) {
            for (int end = s.length(); end > start; end--) {
                result = s.substring(start, end);
                if (isPalindromeString(result)) {
                    int lenTem = result.length();
                    if (len < lenTem) {
                        word = result;
                        len = lenTem;
                    }
                }

            }
        }

        return word;
    }

    public static boolean isPalindromeString(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if (s.equals(sb.toString())) {
            return true;
        }

        return false;
    }*/

    public static String longestPalindrome(String s) {
        int length = s.length();
        String result = "";
        int len = 0;
        for (int i = 0; i < length; i++) {
            String temp = getPalindromeString(s, i, i);//回文字符长度串是奇数
            if (temp.length() > result.length()) {
                result = temp;
            }
            temp = getPalindromeString(s, i, i + 1);//回文字符长度串是偶数
            if (temp.length() > result.length()) {
                result = temp;
            }

        }


        return result;
    }

    //以某字符为中心向两边展开
    public static String getPalindromeString(String s, int i, int j) {
        while (j < s.length() && i >= 0 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
