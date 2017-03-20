package leetcode;

/**
 * Created by ych0112xzz on 2017/3/13.
 */
public class SearchinRotatedSortedArray {
    /*public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                //表示target在右半区间，mid在左半区间
                if(nums[mid]>=nums[start]&&nums[start]>target){
                    start=mid+1;
                }else{//表示target和mid在同区间
                    end=mid-1;
                }
            }else{
                if(nums[mid]<=nums[end]&&nums[end]<target){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }*/
}
