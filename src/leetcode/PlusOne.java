package leetcode;

/**
 * Created by ych0112xzz on 2017/4/20.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int plus=0;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
