package leetcode;

/**
 * Created by ych0112xzz on 2016/9/13.
 */
public class ReverseBits {

    public static void main(String[] args){
        int n= 43261596;
        int result = reverseBits(n);
       System.out.println(result);
       // System.out.println(Integer.MAX_VALUE);
       // System.out.println(Integer.valueOf("1111111111111111111111111111111",2));
    }

    /*public static int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        String result="";
        result=Integer.toBinaryString(n);
        sb.append(result);
        int size = result.length();
        for(int i=0;i<4-size;i++){
            sb.insert(0,"0");
        }
        result=sb.reverse().toString();
        return (int)Math.pow(2,31)-1+(int)Math.pow(2,31)-1;
        //return Integer.parseInt(result,2);
    }*/

   /* public static long reverseBits(long n) {
        StringBuilder data = new StringBuilder(Long.toBinaryString(n));
        //System.out.println(data);
        String s = data.toString();
        //data.reverse();
        //System.out.println(data);
        long result = 0l;
        for(int i=0;i<s.length();i++){
           // System.out.println(s.charAt(i));
            if(s.charAt(i)!='0') {
                result += (long) (1 << (i + 32 - s.length()));
            }
        }

        return result;
    }*/

    public static int reverseBits(int n){
        int result = 0;
        for(int i=0;i<32;i++){
            result=result << 1;
            result = result | (n & 1);
            n=n >> 1;
        }

        return result;
    }

}
