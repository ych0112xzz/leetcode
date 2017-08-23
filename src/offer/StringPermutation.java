package offer;

import java.util.ArrayList;

/**
 * Created by ych0112xzz on 2017/5/16.
 */
public class StringPermutation {


    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> list = new StringPermutation().Permutation(s);
        System.out.println(list);
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result=new ArrayList<>();
        if(str==null||str.length()==0){
            return result;
        }
        char data[]=str.toCharArray();
        permutate(result,0,data.length-1,data);
        return result;
    }
    public void permutate(ArrayList<String> result, int start,int end,char[] data){
        if(start==end){
            result.add(new String(data));
            return;
        }
        for(int i=start;i<=end;i++){
            if(isSwap(data,start,i)){
                swap(data,start,i);
                permutate(result,start+1,end,data);
                swap(data,start,i);
            }
        }
    }

    public void swap(char[] data,int start,int end){
        char tmp=data[start];
        data[start]=data[end];
        data[end]=tmp;
    }

    public boolean isSwap(char[] data,int start,int end){
        for(int i=start;i<end;i++){
            if(data[i]==data[end]){
                return false;
            }
        }
        return true;
    }
}
