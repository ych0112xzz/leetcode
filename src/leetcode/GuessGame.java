package leetcode;

/**
 * Created by ych0112xzz on 2016/9/27.
 */
public class GuessGame {

    int n;

    public GuessGame(int n){
        this.n = n;
    }

    public int guess(int num){
        if(n>num){
            return 1;
        }else if(n==num){
            return 0;
        }
        return -1;
    }
}
