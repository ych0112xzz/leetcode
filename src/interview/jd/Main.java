package interview.jd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ych0112xzz on 2017/4/7.
 */
public class Main {

    public static void main(String[] args) {


        Set<Integer> set = new TreeSet<>();
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        int[] num = String2Array(line);

        int max = Math.max(num[0], Math.max(num[1], num[2]));

        helper(num, set);

        String str = line;

        if (!str.equals(str.replace("2", "5"))) {
            String a = str.replace("2", "5");
            helper(String2Array(a), set);
            if (!str.equals(str.replace("6", "9"))) {
                String b = a.replace("6", "9");
                helper(String2Array(b), set);
            } else if (!str.equals(str.replace("9", "6"))) {
                String b = a.replace("9", "6");
                helper(String2Array(b), set);
            }
        } else if (!str.equals(str.replace("5", "2"))) {
            String a = str.replace("5", "2");
            helper(String2Array(a), set);
            if (!str.equals(str.replace("6", "9"))) {
                String b = a.replace("6", "9");
                helper(String2Array(b), set);
            } else if (!str.equals(str.replace("9", "6"))) {
                String b = a.replace("9", "6");
                helper(String2Array(b), set);
            }
        }
        int count = 0;
        int temp = 0;
        for (int i : set) {
            count++;
            if (count == max) {
                System.out.println(i);
                return;
            }
            temp = i;
        }

        System.out.println(temp);

    }

    public static void helper(int[] num, Set set) {
        Arrays.sort(num);
        set.add(num[0]);
        set.add(num[1]);
        set.add(num[2]);

        set.add(num[0] * 10 + num[1]);
        set.add(num[0] * 10 + num[2]);
        set.add(num[1] * 10 + num[0]);
        set.add(num[1] * 10 + num[2]);
        set.add(num[2] * 10 + num[0]);
        set.add(num[2] * 10 + num[1]);

        set.add(num[0] * 100 + num[1] * 10 + num[2]);
        set.add(num[0] * 100 + num[2] * 10 + num[1]);
        set.add(num[1] * 100 + num[0] * 10 + num[2]);
        set.add(num[1] * 100 + num[2] * 10 + num[0]);
        set.add(num[2] * 100 + num[0] * 10 + num[1]);
        set.add(num[2] * 100 + num[1] * 10 + num[0]);

    }

    public static int[] String2Array(String str) {
        int[] result = new int[3];
        String[] temp = str.split(",");
        for (int i = 0; i < temp.length; i++) {
            result[i] = Integer.parseInt(temp[i]);
        }
        return result;
    }
   /* public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String a = sc.nextLine();
        String b = sc.nextLine();
        String result=getYH(a, b, n);
        //System.out.println(result);
        System.out.println(getTen(result));

    }

    public static String getYH(String a, String b, int n) {
        String result = "";
        for(int i=0;i<n;i++) {
           // System.out.println(Integer.valueOf(a.charAt(i))^Integer.valueOf(b.charAt(i)));
            result +=(Integer.valueOf(a.charAt(i))^Integer.valueOf(b.charAt(i)));

        }
        return result;
    }

    public static long getTen(String s){
        long result = 0l;
        for (char c : s.toCharArray()) {
           // System.out.println(c-48);
            result =result*2+c-48;
        }
        return result;
    }*/






   /* public static void main(String[] args) {
        int x = 0;
        int sum = 0;
        for (int i = 100; i <= 999; i++) {
            int b = i / 100;
            int s = i % 100 / 10;
            int g = i % 10;

            if (i == Math.pow(b, 3) + Math.pow(s, 3) + Math.pow(g, 3)) {
                x++;
                sum += i;
                System.out.println("第" + x + "个水仙花数: " + i);
            }
        }
        System.out.println("水仙花数总和为: " + sum);
    }*/

}
