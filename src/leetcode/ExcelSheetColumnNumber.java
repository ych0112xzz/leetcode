package leetcode;

/**
 * Created by ych0112xzz on 2016/11/25.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args){
        String s = "ABFDTSR";
        System.out.println(new ExcelSheetColumnNumber().titleToNumber(s));
    }
    public int titleToNumber(String s) {
        int result = 0;
        char data[] = s.toCharArray();
        for (int i = 0; i < data.length; i++) {
            /*result = (result + (data[i] - 64) * (int) Math.pow(26, data.length - 1 - i));*/
            result = result * 26 + data[i] - 'A' + 1;
        }

        return result;
    }
}
