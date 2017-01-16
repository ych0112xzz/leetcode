package leetcode;

/**
 * Created by ych0112xzz on 2016/11/21.
 */
public class WiggleSubsequence {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
    }

    /*public int wiggleMaxLength(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int result = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]>0){
                result++;
                while(i<nums.length-1&&nums[i+1]>=nums[i]){
                    i++;
                }
            }else if(nums[i]-nums[i-1]<0){
                result++;
                while(i<nums.length-1&&nums[i+1]<=nums[i]){
                    i++;
                }
            }
        }
        return result;
    }*/


    /*
    * dp
    * */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
//to maintain two dp arrays, one is for the case when the last two nums are in increasing order, the other is for the case when the last two nums are in decreasing number
        int[] dp_up = new int[nums.length];
        int[] dp_down = new int[nums.length];
        dp_up[0] = 1;
        dp_down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
//if nums[i]>nums[i-1], it means the last two nums are in increasing order;
// then we should connect the current to the case when the last two nums are in decreasing number
            if (nums[i] > nums[i - 1]) {
                dp_up[i] = dp_down[i - 1] + 1;
                dp_down[i] = dp_down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                dp_up[i] = dp_up[i - 1];
                dp_down[i] = dp_up[i - 1] + 1;
            } else {
                dp_up[i] = dp_up[i - 1];
                dp_down[i] = dp_down[i - 1];
            }

        }
        return Math.max(dp_up[nums.length - 1], dp_down[nums.length - 1]);
    }
}
