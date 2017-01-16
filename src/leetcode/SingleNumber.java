package leetcode;

import java.util.HashMap;

/**
 * Created by ych0112xzz on 2016/9/8.
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {1};
        int result = singleNumber(nums);
        System.out.println(result);
    }

    public static int singleNumber(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        int tmp = nums[0];
        for(int i=1;i<nums.length;i++){
            tmp ^= nums[i];
        }


        return tmp;
//        HashMap<Integer, Integer> hashmap = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(hashmap.containsKey(nums[i])){
//                hashmap.remove(nums[i]);
////               int value= hashmap.get(nums[i]);
////               hashmap.put(nums[i], value + 1);
//            }else{
//                hashmap.put(nums[i], 1);
//            }
//
//        }
//        return (int) hashmap.keySet().toArray()[0];
    }
}
