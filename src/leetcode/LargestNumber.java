package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ych0112xzz on 2016/7/27.
 */
public class LargestNumber {

    public static void main(String[] args) {
        long start =System.nanoTime();
        int[] nums = {3, 30, 34, 5, 9};
        String result = largestNumber(nums);
        System.out.println(result);
        String s = "33032";
        String p = "330";
        long end=System.nanoTime();
         System.out.println(end-start);
    }

    public static String largestNumber(int[] nums) {
        //String result;
        StringBuilder sb = new StringBuilder();
        String[] data = new String[nums.length];
        // boolean isZero=false;
        for(int i=0;i<nums.length;i++) {
            data[i] = String.valueOf(nums[i]);
        }
//            if(compareTo(start,data[i]))
//
//     }
       // Arrays.sort();
        Arrays.sort(data, new Cmp());
//        for(int i=0;i<nums.length;i++){
//            data[i] = String.valueOf(nums[i]);
//        }
//        Arrays.sort(data);
        for (int i = data.length - 1; i >= 0; i--) {
            sb.append(String.valueOf(data[i]));
        }
        if (sb.toString().startsWith("0")) {
            return "0";
        } else {
            return sb.toString();
        }
    }

//    public static boolean compareTo(String s, String p) {
//        int i = 0;
//        String temp1=s+p;
//        String temp2=p+s;
//        if(temp1.compareTo(temp2)>=0){
//            return true;
//        }
////        while (i < s.length() && i < p.length()) {
////            if (s.charAt(i) > p.charAt(i)) {
////                return true;
////            } else if (s.charAt(i) < p.charAt(i)) {
////                return false;
////            } else {
////                i++;
////            }
////        }
////        if (i >= s.length()) {
////            return compareTo(s, p.substring(i, p.length()));
////        }
////        if (i >= p.length()) {
////            return compareTo(s.substring(i, s.length()), p);
////        }
//        return false;
//    }

    //排序方法需改进
//    public static int[] bubbleSort(int[] a) {
//
//        int temp = 0;
//        for (int i = 0; i < a.length - 1; i++) {
//            for (int j = 0; j < a.length - 1 - i; j++) {
//                if (compareTo(String.valueOf(a[j]),String.valueOf(a[j+1]))) {
//                    temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                }
//            }
//        }
//
//        return a;
//    }
   static class Cmp implements Comparator<String> {

        @Override
        public int compare(String s, String p) {
            String temp1 = s + p;
            String temp2 = p + s;
            return temp1.compareTo(temp2);

        }

    }


}
