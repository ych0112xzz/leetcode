package leetcode;

/**
 * Created by ych0112xzz on 2016/9/1.
 */
public class RemoveElement {

    public static void main(String[] args) {
        int nums[] = {3,3};
        int result = removeElement(nums, 3);
        System.out.println(result);


    }

    public static int removeElement(int[] nums, int val) {
       // int start = 0;
        int result = 0;
        int end = nums.length - 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[result++]=nums[i];
            }
        }
//        for (int i = 0; i < nums.length&&i<=end;i++) {
//            if (nums[i] == val) {
//                while (end>i&&nums[end] == val) {
//                    end--;
//                }
//                if(end!=i) {
//                    int tmp = nums[i];
//                    nums[i] = nums[end];
//                    nums[end] = tmp;
//                    result++;
//                }
//               // end--;
//            } else {
//                result++;
//            }
//        }
        return result;
    }

}
