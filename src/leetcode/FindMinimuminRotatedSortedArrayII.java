package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/11/30.
 */
public class FindMinimuminRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,1,2,2};
        System.out.println(new FindMinimuminRotatedSortedArrayII().findMin(nums));

    }

    /*
    * O(nlogn)
    * */
    /*public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }*/

    /*
    * O(n)
    * */
    /*public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int value:nums){
            min = min <= value ? min : value;
        }
        return min;
    }*/

    /*
    * O(logn),用result的好处在于避免了end和start的之变换造成的问题
    * */
   /* public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int result = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                result = Math.min(nums[mid],result);
                if (nums[mid] > nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else if (nums[mid] < nums[start]) {
                result = Math.min(nums[mid],result);
                end = mid;
            }else{
                result = Math.min(nums[mid],result);
                start++;
            }
        }
        return result;
    }*/
   /* public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < nums[right]) right = mid;
            else if(nums[mid] > nums[right]) left = mid + 1;
            else right--;
        }
        return nums[left];
    }*/

    /*
    * 递归
    * */
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }
    private int findMin(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        return Math.min(findMin(nums, start, mid), findMin(nums, mid + 1, end));
    }
}
