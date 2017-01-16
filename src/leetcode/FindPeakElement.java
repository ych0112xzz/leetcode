package leetcode;

/**
 * Created by ych0112xzz on 2016/9/21.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,6};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int mid = 0;
        while(start<end){
            mid = (start + end) / 2;
            if(nums[mid]<nums[mid+1]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }

//    public static int findPeakElement(int[] nums) {
//        if(nums.length==0){
//            return 0;
//        }
//        int start=0;
//        int end = nums.length - 1;
//        while(start+1<end){
//            int mid = (start + end) / 2;
//            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
//                return mid;
//            }else if(nums[mid]<nums[mid-1]){
//                end=mid;
//            }else{
//                start=mid;
//            }
//        }
//        if(nums[start]>nums[end]){
//            return start;
//        }else{
//            return end;
//        }
//
//    }

//    public static int findPeakElement(int[] nums) {
//        if (nums.length == 0 || nums.length == 1) {
//            return 0;
//        }
//        int size = nums.length;
//        //int mid = size / 2;
//        int start = 0;
//        int end = size;
//        return findPeakElement(start, end, nums);
//
//    }

    private static int findPeakElement(int start, int end, int[] nums) {
        int result = 0;

        if (start == end) {
            return -1;
        }

        int mid = (end + start) / 2;
        int pre = Integer.MIN_VALUE;
        int next = Integer.MIN_VALUE;
        if (mid + 1 < nums.length) {
            next = nums[mid + 1];
        }
        if(mid-1>=0){
            pre = nums[mid - 1];
        }
        if (nums[mid] > next && nums[mid] > pre) {
            result = mid;
        } else {
           result = findPeakElement(start, mid, nums)> -1 ? findPeakElement(start, mid, nums) : findPeakElement(mid+1, end, nums);
        }
        return result;
    }
}
