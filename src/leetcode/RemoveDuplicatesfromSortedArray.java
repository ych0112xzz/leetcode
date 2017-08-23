package leetcode;

/**
 * Created by ych0112xzz on 2017/4/20.
 */
public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int nums[] = {1,1,2,3,4,5,5,5,5,5};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result=1;
        for(int i=1;i<nums.length;i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            nums[result++] = nums[i];
        }
        return result;
    }
}
