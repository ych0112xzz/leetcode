package leetcode;

/**
 * Created by ych0112xzz on 2016/9/13.
 */
public class IntegertoRoman {


    public static void main(String[] args){
        int num = 102;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int thou = num / 1000;
        for (int i = 0; i < thou; i++) {
            result.append("M");
        }
        num = num % 1000;
        int hund = num/100;
        num=num%100;
        if(hund==9){
            result.append("CM");
        }else if(hund>=5){
            result.append("D");
            for(int i=0;i<hund-5;i++){
                result.append("C");
            }
        }else if(hund==4){
            result.append("CD");
        }else{
            for(int i =0;i<hund;i++){
                result.append("C");
            }
        }
        int ten = num/10;
        num = num % 10;
        if(ten==9){
            result.append("XC");
        }else if(ten>=5){
            result.append("L");
            for(int i=0;i<ten-5;i++){
                result.append("X");
            }
        }else if(ten==4){
            result.append("XL");
        }else{
            for(int i=0;i<ten;i++){
                result.append("X");
            }
        }
        if(num==9){
            result.append("IX");
        }else if(num>=5){
            result.append("V");
            for(int i=0;i<num-5;i++){
                result.append("I");
            }
        }else if(num==4){
            result.append("IV");
        }else{
            for(int i=0;i<num;i++){
                result.append("I");
            }
        }

        return result.toString();
    }
}
