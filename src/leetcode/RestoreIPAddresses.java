package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/12/29.
 */
public class RestoreIPAddresses {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(new RestoreIPAddresses().restoreIpAddresses(s));
    }


    /*
    * 枚举所有可能
    * */
    /*public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4) {
            return result;
        }
        for(int i=0;i<s.length()-3;i++) {
            for(int j=i+1;j<s.length()-2;j++) {
                for(int k=j+1;k<s.length()-1;k++) {
                    String s1 = s.substring(0, i+1);
                    String s2 = s.substring(i+1, j+1);
                    String s3 = s.substring(j + 1, k + 1);
                    String s4 = s.substring(k + 1, s.length());
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        if ((s.startsWith("0")&&s.length()!=1) ||s.length()>=4||Integer.valueOf(s)>255) {
            return false;
        }

        return true;
    }*/

    /*
    * DFS
    * */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(result, s, 0, "", 0);
        return result;
    }

    private void restoreIpAddresses(List<String> result, String s, int index, String cur, int count) {
        if (count > 4) {
            return;
        }
        if (count == 4 && index == s.length()) {
            result.add(cur);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (index + i  > s.length()) {
                break;
            }
            String tmp = s.substring(index, index + i);
            if ((tmp.startsWith("0")&&tmp.length()!=1) ||tmp.length()>=4||Integer.valueOf(tmp)>255){
                continue;
            }
            tmp = (count == 3 ? cur+tmp:cur + tmp + ".");
            restoreIpAddresses(result,s,index+i, tmp, count + 1);
        }
    }

}
