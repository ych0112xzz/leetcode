package interview.campus.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ych0112xzz on 2017/8/12.
 */
public class Main {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        combine(n,k);
//        System.out.println(res.size());
        System.out.println(count);
        // System.out.println("hello");
    }



    public static void combine(int n, int k) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 1;
        IntegerCom(n, k, i, list);

        // return result;
    }

    public static void IntegerCom(int n, int k, int i, ArrayList<Integer> list) {
        if (list.size() >= k) {
//            ArrayList<Integer> list1 = new ArrayList<Integer>(list);//注意对象的引用
//            result.add(list1);
            count++;
            if(count==1000000007){
                count=0;
            }
            return;
        } else {

            for (int j = 1; j<=n;j++) {
                if(list.size()==0){
                    list.add(j);
                }else{
                    int tmp=list.get(list.size()-1);
                    if(list.size()<=k-1&&(tmp<=j||tmp%j!=0)){
                        list.add(j);
                    }else{
                        continue;
                    }
                }
                IntegerCom(n, k, j, list);
                list.remove(list.size() - 1);

            }
        }
    }
}


   /* public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 1;
        IntegerCom(n, k, i, result, list);

        return result;
    }

    public static void IntegerCom(int n, int k, int i, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if (list.size() >= k) {
            ArrayList<Integer> list1 = new ArrayList<Integer>(list);//注意对象的引用
            result.add(list1);
            return;
        } else {

            for (int j = i; j<=n;j++) {
                if(((list.size()<=k-1)&&(list.get(list.size()-1)<=j||list.get(list.size()-1)%j!=0))) {
                    list.add(j);
                    IntegerCom(n, k, j + 1, result, list);
                    list.remove(list.size() - 1);

                }else{
                    return;
                }
            }
        }
    }*/
//}
