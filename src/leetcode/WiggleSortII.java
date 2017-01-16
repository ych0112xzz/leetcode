package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/11/16.
 */
public class WiggleSortII {
    public static void main(String[] args) {
        int[] nums = {1,5,1,1,6,4,7};
        new WiggleSortII().wiggleSort(nums);
        for(int val:nums){
            System.out.println(val);
        }
    }

    /*
    * O(nlogn)
    * */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int j = 0;
        for(int i=nums.length-1;i>=nums.length-nums.length/2;i--){
            result[j++] = nums[i - nums.length / 2];
            System.out.println(i+"\t"+(j-1) + "\t" + result[j - 1]);
            result[j++] = nums[i];
            System.out.println(i+"\t"+(j-1) + "\t" + result[j - 1]);
        }
        //System.out.println((j) + "\t" + nums[0]);
        if(nums.length%2==1){
            result[j] = nums[0];
            System.out.println(0+"\t"+(j) + "\t" + result[j ]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = result[i];
        }
    }
}
