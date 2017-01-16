package leetcode;

/**
 * Created by ych0112xzz on 2016/9/9.
 */
public class AddBinary {
    public static void main(String[] args){
        String a="101";
        String b = "1";
        //int
//        Byte c = Byte.valueOf(a);
//        Byte d = Byte.valueOf(b);

        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a, String b) {
        String result="";
        int plus=0;
        if(a.length()==0&&b.length()==0){
            return result;
        }
        int aindex=a.length()-1;
        int bindex=b.length()-1;
        while(aindex>=0&&bindex>=0){
            int tmp=Integer.valueOf(a.charAt(aindex))+Integer.valueOf(b.charAt(bindex))-'0'-'0'+plus;
            if(tmp>=2){
                plus=1;
                tmp -=2;
            }else{
                plus=0;
            }
            result =tmp+result;
            System.out.println(result);
            aindex--;
            bindex--;
        }
        if(aindex>=0) {
            while (aindex >= 0) {
                int tmp = Integer.valueOf(a.charAt(aindex))-'0' + plus;
                if (tmp >= 2) {
                    plus = 1;
                    tmp -= 2;
                } else {
                    plus = 0;
                }
                result = tmp+result;
                System.out.println(result);
                aindex--;
            }
        }
        if(bindex>=0) {
            while (bindex >= 0) {
                int tmp = Integer.valueOf(b.charAt(bindex))-'0' + plus;
                if (tmp >= 2) {
                    plus = 1;
                    tmp -= 2;
                } else {
                    plus = 0;
                }
                result = tmp+result;
                bindex--;
            }
        }
        if(plus==1) {
            result = String.valueOf(plus) + result;
        }

        return  result;
    }
}
