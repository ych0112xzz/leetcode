package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ych0112xzz on 2016/7/22.
 */
public class StringtoIntegeratoi {
    public static void main(String[] args) {
        String str = "-2";
        int result = new StringtoIntegeratoi().myAtoi(str);
        System.out.println(result);
    }

    /*public static int myAtoi(String str) {
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
    }*/

    public int myAtoi(String str) {
        if(str.length()==0){
            return 0;
        }
        char[] data=str.toCharArray();
        int index=0;
        //去除前面空格
        while(data[index]==' '&&index<data.length){
            index++;
        }
        int sign=1;
        if(data[index]=='+'||data[index]=='-'){
            sign=data[index]=='+'?1:-1;
            index++;
        }

        int total=0;
        while(index<data.length){
            int i=data[index]-'0';
            if(i<0||i>9){
                break;
            }
            if(Integer.MAX_VALUE/10<total||(Integer.MAX_VALUE-i)/10<total){
                return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }else{
                total=total*10+i;
            }
            index++;
        }
        return total*sign;
    }
}
