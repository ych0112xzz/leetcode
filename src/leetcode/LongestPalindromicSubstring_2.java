package leetcode;

import java.util.logging.Logger;

/**
 * Created by ych0112xzz on 2016/7/25.
 */
public class LongestPalindromicSubstring_2 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        // String s = "aba";
        String word = longestPalindrome(s);
        long endTime = System.currentTimeMillis();
        //System.out.println(word);
        Logger.getLogger(word);
        System.out.println("RUN Time:" + (endTime - startTime) + "ms");
    }

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

    public static String getPalindromeString(String s, int i, int j) {
        while (j < s.length() && i >= 0 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;

        }

        return s.substring(i + 1, j);
    }
}
