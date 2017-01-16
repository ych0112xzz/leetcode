package leetcode;

/**
 * Created by ych0112xzz on 2016/11/22.
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "0100378323984042514314235634654778678967805768756867598760236";
        int k = 19;
        System.out.println(new RemoveKDigits().removeKdigits(num, k));
    }

   /* public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        StringBuilder sb1 = new StringBuilder();
        String result = "";
        int index = 0;
        for (int i = 1; i < sb.length(); i++) {
            int j = i - 1;
            if (sb.charAt(i) - sb.charAt(j) < 0) {
                while (j >= 0) {
                    if (sb.charAt(i) - sb.charAt(j) < 0) {
                        sb.replace(j, j + 1, " ");
                        index++;
                        if (index == k) {
                            break;
                        }
                    }
                    j--;
                }
            }
            if (index >= k) {
                break;
            }
        }

        result = sb.toString().replace(" ", "");
        //System.out.println(index + "\t" + result);
        while (index < k) {
            result = result.substring(0, result.length() - 1);
            index++;
        }
        boolean isStart = true;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '0' && isStart) {
                continue;
            } else {
                isStart = false;
                sb1.append(result.charAt(i));
            }
        }
        return sb1.toString().length() == 0 ? "0" : sb1.toString();
    }*/

    public String removeKdigits(String num, int k) {
        char[] data=num.toCharArray();
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (int i = 1; i < data.length; i++) {
            if(data[i]-data[i-1]<0){
                int j=i-1;
                while(j>=0){
                    if(data[i]-data[j]<0){
                        data[j] = ' ';
                        index++;
                        if (index == k) {
                            break;
                        }
                    }
                    j--;
                }
            }
            if (index >= k) {
                break;
            }
        }
        int n = data.length-1;
        while (index < k) {
            data[n--] = ' ';
            index++;
        }
        boolean isStart=true;
        for (int i = 0; i < data.length; i++) {
            if ((data[i] == '0' && isStart) ||data[i]==' '){
                continue;
            } else {
                isStart = false;
                result.append(data[i]);
            }
        }
        return result.length()==0?"0":result.toString();
    }
}
