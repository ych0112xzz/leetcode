package leetcode;

/**
 * Created by ych0112xzz on 2016/9/27.
 */
public class GuessNumberHigherorLower extends GuessGame {

    public static void main(String[] args) {
        GuessNumberHigherorLower guess = new GuessNumberHigherorLower(2147483647);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(guess.guessNumber(2147483647));
    }

    public GuessNumberHigherorLower(int n) {
        super(n);
    }

    public int guessNumber(int n) {
        if(guess(2147483647)==0){
            return 2147483647;
        }
        int start = 1;
        int end = n;
        int result = (n+1) / 2;
        while (start < end) {
            if (guess(result) == -1) {
                end = result;
                result = start+(end-start)/2;//(int)((end + start) / 2)这样书写容易产生int溢出;
                System.out.println(result);
            } else if (guess(result) == 1) {
                start = result + 1;
                result = start+(end-start)/2;//(int)((end + start) / 2);
                System.out.println(result);
            } else {
                return result;
            }
        }
        return n;
    }


}
