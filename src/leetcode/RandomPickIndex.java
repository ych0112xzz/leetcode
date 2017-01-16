package leetcode;

import java.util.Random;

/**
 * Created by ych0112xzz on 2016/9/22.
 */
public class RandomPickIndex {
    int[] nums;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;

    }

    public int pick(int target) {
        int result=-1;
        int cnt = 0;
        Random random = new Random();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                cnt++;
                if(random.nextInt(cnt)==0){
                    result = i;
                }
            }
        }

        return result;
    }
}
