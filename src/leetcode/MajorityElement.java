package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ych0112xzz on 2016/10/11.
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 3, 3, 3};
        System.out.println(new MajorityElement().majorityElement(nums));
    }

   /* public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], 1);
            }else{
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            }
            if(hashMap.get(nums[i])>nums.length/2){
                result = nums[i];
                break;
            }
        }
        return result;
////        Arrays.sort(nums);
//        return nums[nums.length / 2];
    }*/

    public int majorityElement(int[] num) {

        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }
}
