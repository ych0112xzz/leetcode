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

    public static String longestPalindrome(String s) {
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
    }
}
