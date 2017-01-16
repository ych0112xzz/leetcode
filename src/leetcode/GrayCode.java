package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/10/21.
 */
public class GrayCode {

    public static void main(String[] args){
        int n = 3;
        ArrayList<Integer> list =  new GrayCode().grayCode(n);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }



    /*
    * 位运算
    * */
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }


    /*
    * 循环
    * */
    /*public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        int size = list.size();
        for(int index=0;index<n;index++){
            for(int i=size-1;i>=0;i--){
                list.add((list.get(i)+(1<<index)));
            }
            size = list.size();
        }


        return list;
    }*/


    /*
    * 递归
    * */
    /*public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if(n==0){
            list.add(0);
            return list;
        }
        ArrayList<Integer> preList = grayCode(n - 1);
        list=preList;
        for(int i=preList.size()-1;i>=0;i--){
            list.add((int) (preList.get(i)+Math.pow(2,n-1)));
        }

        return list;
    }*/

}
