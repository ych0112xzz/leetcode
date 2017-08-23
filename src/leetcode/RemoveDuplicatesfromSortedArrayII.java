package leetcode;

/**
 * Created by ych0112xzz on 2017/5/11.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int res = 1;
        int count = 0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]==nums[i-1]){
                if (count == 0) {
                    count = 2;
                    nums[res++] = nums[i];
                }else{
                    continue;
                }
            }else{
                count = 0;
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
