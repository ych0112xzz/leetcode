package leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by ych0112xzz on 2016/10/21.
 */
public class UglyNumberII {

    public static void main(String[] args) {
        int n = 1690;
        //  System.out.println(Integer.MAX_VALUE*2);
        System.out.println((-2147483648) * 2);
        System.out.println(new UglyNumberII().nthUglyNumber(n));
    }

    /*
    * 使用优先队列
    * */
    /*public int nthUglyNumber(int n){
        if(n==1){
            return 1;
        }
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        long tmp=1;
        priorityQueue.add(tmp);
        for(int i=0;i<n;i++){
            tmp = priorityQueue.poll();
            while(!priorityQueue.isEmpty()&&tmp==priorityQueue.peek()){
                priorityQueue.poll();
            }

            priorityQueue.add(tmp * 2);
            priorityQueue.add(tmp * 3);
            priorityQueue.add(tmp * 5);
        }
        return (int) tmp;
    }*/

    /*
    * 使用三个poiter
    * */
    public int nthUglyNumber(int n) {

        if( n == 0 || n == 1) {
            return n;
        }

        int pointer2 = 0;
        int pointer3 = 0;
        int pointer5 = 0;

        int[] result = new int[n];
        result[0] = 1;

        int i = 1, min =0;
        while ( i < n ) {
            min = Math.min(result[pointer2]*2,Math.min(result[pointer3]*3,result[pointer5]*5));

            if(min == result[pointer2]*2) {
                pointer2++;
            }
            if(min == result[pointer3]*3) {
                pointer3++;
            }
            if(min == result[pointer5]*5) {
                pointer5++;
            }
            result[i] = min;

            i++;

        }
        return result[n-1];
    }


   /* public int nthUglyNumber(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int order = 1;
        int index = Integer.MAX_VALUE;
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();
        LinkedList<Integer> list5 = new LinkedList<>();
        int result = 1;
        int tmp2 = result * 2;
        int tmp3 = result * 3;
        int tmp5 = result * 5;
        result = 2;
        list2.add(tmp2);
        list3.add(tmp3);
        list5.add(tmp5);
        while (order < n) {
            if (list2.isEmpty()) {
                tmp2 = Integer.MAX_VALUE;
            } else {
                tmp2 = list2.getFirst();
            }
            if (list3.isEmpty()) {
                tmp3 = Integer.MAX_VALUE;
            } else {
                tmp3 = list3.getFirst();
            }
            if (list5.isEmpty()) {
                tmp5 = Integer.MAX_VALUE;
            } else {
                tmp5 = list5.getFirst();
            }
            int tmp = findmin(tmp2, tmp3, tmp5);
            result = tmp;
            if (tmp == tmp2) {
                list2.removeFirst();
            } else if (tmp == tmp3) {
                list3.removeFirst();
            } else {
                list5.removeFirst();
            }
            if (!list2.contains(result * 2) && !list3.contains(result * 2) && !list5.contains(result * 2) && result <= index / 2) {
                list2.add(result * 2);
            }
            if (!list2.contains(result * 3) && !list3.contains(result * 3) && !list5.contains(result * 3) && result <= index / 3) {
                list3.add(result * 3);
            }
            if (!list2.contains(result * 5) && !list3.contains(result * 5) && !list5.contains(result * 5) && result <= index / 5) {
                list5.add(result * 5);
            }
            order++;
            if (order > 1680) {
                System.out.println(order + "\t" + result);
                System.out.println(list2);
                System.out.println(list3);
                System.out.println(list5);
            }
        }

        return result;
    }


    public int findmin(int tmp2, int tmp3, int tmp5) {
        int tmp = tmp2;
        if (tmp > tmp3) {
            tmp = tmp3;
        }
        if (tmp > tmp5) {
            tmp = tmp5;
        }
        return tmp;
    }*/
}