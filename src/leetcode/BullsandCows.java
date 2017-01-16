package leetcode;

/**
 * Created by ych0112xzz on 2016/10/12.
 */
public class BullsandCows {

    public static void main(String[] args){
        String secret = "1";
        String guess = "0";
        System.out.println(new BullsandCows().getHint(secret,guess));

    }

    public String getHint(String secret, String guess) {
        char a[] = secret.toCharArray();
        char[] b = guess.toCharArray();
        int[] count1 = new int[10];
        int[] count2 = new int[10];
        int bulls = 0;
        int cows = 0;
       /* for (int i = 0; i < a.length; i++) {
            if(a[i]==b[i]){
                bulls++;
            }else {
                count1[a[i] - '0']++;
                count2[b[i] - '0']++;
            }
        }

        for(int i=0;i<10;i++){
            System.out.println(count1[i]);
            System.out.println(count2[i]);
            int tmp = count1[i] > count2[i] ? count2[i] : count1[i];
            if(tmp>0) {
                cows += tmp;
            }
        }*/

        for(int i=0;i<a.length;i++){
            if(a[i]==b[i]){
                bulls++;
            }else{
                if(count1[a[i]-'0']++<0){
                    cows++;
                }if(count1[b[i]-'0']-->0){
                    cows++;
                }
            }
        }
        return bulls+"A"+cows+"B";
    }
}
