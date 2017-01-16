package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/11/24.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j = 0;
        int result = 0;
        while(i<g.length&&j<s.length){
            if(s[j]>=g[i]){
                result++;
                j++;
                i++;
            }else{
                j++;
            }
        }
        return result;
    }
}
