package leetcode;

/**
 * Created by ych0112xzz on 2017/4/24.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos=m+n;
        if(pos>nums1.length){
            return;
        }
        int index1=m-1,index2=n-1;
        pos--;
        while(index1>=0&&index2>=0){
            if(nums1[index1]<=nums2[index2]){
                nums1[pos--]=nums2[index2--];
            }else{
                nums1[pos--]=nums1[index1--];
            }
        }
        while(index2>=0){
            nums1[pos--]=nums2[index2--];
        }
    }
}
