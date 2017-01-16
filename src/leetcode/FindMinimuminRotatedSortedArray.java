package leetcode;

/**
 * Created by ych0112xzz on 2016/11/29.
 */
public class FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(new FindMinimuminRotatedSortedArray().findMin(nums));
    }

    public int findMin(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int result = -1;
        int start=0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
           // System.out.println(start + "\t" + mid + "\t" + end);
            /*if(nums[mid]<nums[start]){
                end=mid;
            }else {
                if(nums[mid]<nums[end]){
                    end = mid;
                }else{
                    start = mid + 1;
                }
            }*/
            if(nums[mid]<nums[end]){
                end = mid;
            }else{
                start = mid + 1;
            }

        }
        return nums[end];
    }
}
