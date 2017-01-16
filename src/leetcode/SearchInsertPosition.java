package leetcode;

/**
 * Created by ych0112xzz on 2016/10/11.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid = start + (end - start) / 2;
        while(start<end){
            if(nums[mid]<target){
                start=mid+1;
            }else if(nums[mid]>target){
                end = mid;
            }else{
                return mid;
            }
            mid = start + (end - start) / 2;
        }

        return start;
    }

}
