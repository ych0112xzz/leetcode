package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ych0112xzz on 2016/7/22.
 */
public class StringtoIntegeratoi {
    public static void main(String[] args) {
        String str = "-2";
        int result = myAtoi(str);
        System.out.println(result);
    }

    public static int myAtoi(String str) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        System.out.println(MAX + "\t" + MIN);
        int result = 0;
        if (str.trim().length() == 0) {
            return 0;
        }

        Pattern p = Pattern.compile("(^([-|+]?)\\d+)(\\w)*");
        Matcher m = p.matcher(str.trim());

        if (!(m.find())) {
            return 0;
        } else {

            String data = m.group(1);
            if (data.length() > 11) {//判断是否超出integer范围
                if (m.group(2).equals("-")) {
                    return MIN;
                }else{
                    return MAX;
                }
            }
            long value = Long.parseLong(data);
            if (value > MAX) {
                return MAX;
            } else if (value < MIN) {
                return MIN;
            } else {
                result = (int) value;
            }
        }

        return result;
    }
}
