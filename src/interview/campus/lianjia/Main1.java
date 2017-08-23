package interview.campus.lianjia;

import java.util.*;

/**
 * Created by ych0112xzz on 2017/8/19.
 */
public class Main1 {
    static class Help{
        int id;
        int grade;
        int up;
        Help(int id,int grade,int up){
            this.id = id;
            this.grade=grade;
            this.up = up;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String data[] = first.split(" ");
        int n = Integer.valueOf(data[0]);
        int r = Integer.valueOf(data[1]);
        int avg = Integer.valueOf(data[2]);
        int[] a = new int[n];
        int[] b = new int[n];
        Help[] helps = new Help[n];
        long sum=0L;
        for(int i=0;i<n;i++) {
            String line = sc.nextLine();
            String data1[] = line.split(" ");
            helps[i] = new Help(i, Integer.valueOf(data1[0]), Integer.valueOf(data1[1]));
            /*helps[i].id = i;
            helps[i].grade=Integer.valueOf(data1[0]);*/
            sum = sum + helps[i].grade;
            /*helps[i].up=Integer.valueOf(data1[1]);*/
           /* a[i] = Integer.valueOf(data1[0]);
            sum = sum + a[i];
            b[i] = Integer.valueOf(data1[1]);*/
        }

        Arrays.sort(helps, new Comparator<Help>() {
            @Override
            public int compare(Help o1, Help o2) {
                return o1.up-o2.up;
            }
        });

        long minus = Long.valueOf(n) * Long.valueOf(avg) - sum;
       // System.out.println(minus+"\t"+sum);
        long result = 0L;
        for(int i=0;i<n;i++) {
            if(minus<=0){
                break;
            }
            long tmp = r-helps[i].grade;
            long addMax = Math.min(tmp, minus);
            result = result+addMax * helps[i].up;
          //  System.out.println(result);
            minus = minus - addMax;

        }
        System.out.println(result);
    }


}
