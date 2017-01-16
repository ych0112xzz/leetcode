package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/10/13.
 */
public class IsSubsequence {

    public static void main(String[] args) {
        String s = "";
        String t = "";
        System.out.println(new IsSubsequence().isSubsequence(s, t));
    }

    /*public boolean isSubsequence(String s, String t) {
        *//*
        * 正则
        * *//*
        *//*char[] data = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i =0;i< data.length;i++){
            sb.append(".*");
            sb.append(data[i]);
        }
        sb.append(".*");
        String tmp = sb.toString();
        //System.out.println(tmp);
        return t.matches(tmp);*//*
        if(s.length()==0){
            return true;
        }
        boolean result = false;
        char[] datas = s.toCharArray();
       // char[] datat = t.toCharArray();
        int index = 0;
        for(int i =0;i<t.length();i++){
            if(t.charAt(i)==datas[index]){
                index++;
                if(index>=s.length()){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }*/



    /*
    * 动态规划
    * */
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        if (t == null || t.length() == 0) return false;
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            int index = t.indexOf(s.charAt(j), i);
            if (index>=0) {
                dp[j] = true;
                i = index + 1;
            }else{
                break;
            }

        }
        return dp[dp.length-1];
    }
}
