package leetcode;

/**
 * Created by ych0112xzz on 2016/9/19.
 */
public class BulbSwitcher {

    public static void main(String[] args){
       int n=8;
        System.out.println(bulbSwitch(n));
    }

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
//        if(n==0){
//            return 0;
//        }
//        if(n==1){
//            return 1;
//        }
//        return Math.sqrt(n)-(int)Math.sqrt(n)==0? bulbSwitch((n-1)/2)+1:bulbSwitch((n-1)/2);
//        if(Math.sqrt(n)-(int)Math.sqrt(n)==0){
//            return bulbSwitch(n-1)+1;
//        }else{
//            return bulbSwitch(n-1);
//        }
//
//        return n;
    }
}
