package leetcode;

/**
 * Created by ych0112xzz on 2016/7/22.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        String word = new LongestPalindromicSubstring().longestPalindrome(s);
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


    /*
    以某字符为中心向两边扩展（区分奇数和偶数）
     */
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





    public static int longestPalindrome2(String s) {
        int result = 0;
        char data[] = init(s);
        result=manacher(data);
        return result;
    }



    private static int manacher(char[] data) {
        int result = -1;
        // rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
        int rad[]=new int[data.length];
        // right表示已知的回文中，最右的边界的坐标
        int right=-1;
        // id表示已知的回文中，拥有最右边界的回文的中点坐标
        int id = -1;
        // 2.计算所有的rad
        // 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。
        for(int i=0;i<data.length;i++) {
            int r=1;
            if (r <= right) {
                r = Math.min(rad[id] + id - i, rad[2 * id - i]);
            }
            while (i - r >= 0 && i + r < data.length && data[i - r] == data[i + r]) {
                r++;
            }
            rad[i] = r;
            if (i + r - 1 > right) {
                right = i + r - 1;
                id = i;
            }
            result = Math.max(result, r);
        }
        return result;
    }

    private static char[] init(String s) {
        char[] data = new char[s.length() * 2 + 1];
        for(int j=0;j<s.length();j++) {
            data[2 * j] = '#';
            data[2 * j + 1] = s.charAt(j);
        }
        data[data.length - 1] = '#';
        return data;
    }




    /*
    列举回文串的起点或者终点来解最长回文串问题，无需讨论串长度的奇偶性
     */
    public static int longestPalindrome3(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];//dp[i][j] 表示s[i...j]是否是回文串
        int result = 0;
        for(int i=0;i<n;i++) {
            int j = i;
            while (j >= 0) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 1 || dp[j + 1][i - 1])) {
                    dp[j][i]=true;
                }
                result = Math.max(result, i - j + 1);
            }
            j--;
        }
        return result;
    }
}
