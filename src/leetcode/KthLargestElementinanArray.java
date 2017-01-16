package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ych0112xzz on 2016/10/12.
 */
public class KthLargestElementinanArray {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(new KthLargestElementinanArray().findKthLargest(nums, 1));
    }


    /*
    * 使用count
    * */
   /* public int findKthLargest(int[] nums, int k){
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++){//求出最大最小值
            if(nums[i]>max) max=nums[i];
            else if(nums[i]<min) min=nums[i];
        }
        int[] counts=new int[max-min+1];
        for(int i=0;i<nums.length;i++){//
            counts[nums[i]-min]++;
        }
        int large=0;
        for(int i=counts.length-1;i>=0;i--){
            k-=counts[i];
            if(k<=0) {
                large = i+min;
                break;
            }
        }
        return large;
    }*/


    /*
    * 使用优先队列
    * */
   /* public int findKthLargest(int[] nums, int k){
        if(nums.length==1){
            return nums[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue(k);
        //System.out.println(maxHeap.size());
        maxHeap.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(maxHeap.size()<k){
                maxHeap.add(nums[i]);
            }else{
                int value = maxHeap.peek();
                if(nums[i]>value){
                    maxHeap.poll();
                    maxHeap.add(nums[i]);
                    System.out.println(maxHeap.size());
                }
            }
        }


        return maxHeap.peek();
    }*/


    /*
    * 排序
    * */
    /*public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }*/


    /*
    * quickselect
    * */
    /*public Integer findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length)
            return null;
        int len = nums.length;
        int index = len - k;
        return quickSelect(nums, 0, len - 1, index);
    }

    private int quickSelect(int[] nums, int left, int right, int index) {
        if (left == right)
            return nums[left];
        int mid = (left + right) / 2;
        int pivot = nums[mid];
        nums[mid] = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] > pivot) j--;
            if (i == j) break;
            nums[i] = nums[j];
            i++;
            while (i < j && nums[i] < pivot) i++;
            if (i == j) break;
            nums[j] = nums[i];
            j--;
        }
        nums[i] = pivot;
        if (i == index) return nums[index];
        if (i > index) return quickSelect(nums, left, i - 1, index);
        return quickSelect(nums, i + 1, right, index);
    }*/


    public int findKthLargest(int[] nums, int k) {
        if(nums==null||k>nums.length) {
            return 0;
        }
        int high = nums.length;
        int low = 0;
        int index = high - k;
        return quickSelect(nums,low,high-1,index);
    }

    private int quickSelect(int[] nums, int low, int high, int index) {
        if(low==high){
            return nums[low];
        }
        int mid = low + (high - low) / 2;
        int pivot = nums[mid];
        swap(nums,mid,high);
        int i=low;
        int j=high;
        while(i<j){
            /*while(i<j&&nums[i]<pivot) i++;
            while (i<j&&nums[--j]>pivot) continue;
            if(i<j){
                swap(nums,i,j);
            }*/
            if (nums[i++] > pivot) swap(nums, --i, --j);
        }
        swap(nums,i,high);
        if(i==index) return nums[index];
        if(i>index) return quickSelect(nums, low, i - 1, index);
        return quickSelect(nums,i+1, high, index);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
