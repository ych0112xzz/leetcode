package leetcode;

/**
 * Created by ych0112xzz on 2016/11/15.
 */
public class SortColors {

    public static void main(String args[]) {
        int nums[] = {0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 1, 2, 0, 2, 1, 2, 0, 1, 1, 0, 2, 1, 0, 0, 0, 1, 1, 1, 2, 0, 0, 2, 2, 1, 1, 2};
        new SortColors().sortColors(nums);
        for (int val : nums) {
            System.out.print(val);
        }
    }

   /* public void sortColors(int[] nums) {
        int oneIndex = -1;
        int twoIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (oneIndex >= 0 && twoIndex >= 0) {
                    nums[oneIndex++] = 0;
                    nums[twoIndex++] = 1;
                    nums[i] = 2;
                } else if (oneIndex >= 0) {
                    nums[oneIndex++] = 0;
                    nums[i] = 1;
                } else if (twoIndex >= 0) {
                    nums[twoIndex++] = 0;
                    nums[i] = 2;
                }
                //System.out.println(nums[oneIndex]+"\t"+nums[twoIndex]);
            } else if (nums[i] == 1) {

                if (twoIndex >= 0) {
                    nums[twoIndex++] = 1;
                    nums[i] = 2;
                    if (oneIndex < 0) {
                        oneIndex = twoIndex - 1;
                    }
                } else if (oneIndex < 0) {
                    oneIndex = i;
                }

                // System.out.println(nums[oneIndex]+"\t"+nums[twoIndex]);
            } else {
                if (twoIndex < 0) {
                    twoIndex = i;
                    System.out.println(twoIndex);
                }

                // System.out.println(nums[oneIndex]+"\t"+nums[twoIndex]);
            }

        }
    }*/

    /*
    * 精巧解法，但效率低
    * */
    /*public void sortColors(int[] nums) {
        int k = 3;
        // k pointers pointing at next position to set
        int[] pointers = new int[k];
        for (int n : nums) {
            for (int i = k - 1; i >= n; i--) {
                nums[pointers[i]++] = i;//poiter这维持着最后一个数字，上面维持着每个数字的第一个索引
            }
        }
        // k = 3,
        // pointers: 0  0  0, nums = [1 2 0 2 1 2 0]
        // pointers: 0  1  1, nums = [1,2 0 2 1 2 0], n = 1, i = 2, 1
        // pointers: 0  1  2, nums = [1 2,0 2 1 2 0], n = 2, i = 2
        // pointers: 1  2  3, nums = [0 1 2,2 1 2 0], n = 0, i = 2, 1, 0
        // pointers: 1  2  4, nums = [0 1 2 2,1 2 0], n = 2, i = 2
        // pointers: 1  3  5, nums = [0 1 1 2 2,2 0], n = 1, i = 2, 1
        // pointers: 1  3  6, nums = [0 1 1 2 2 2,0], n = 2, i = 2
        // pointers: 2  4  7, nums = [0 0 1 1 2 2 2], n = 2, i = 2
    }*/

    public void sortColors(int[] nums) {
        int start=0;
        int end = nums.length - 1;
        for(int i=0;i<=end;i++) {
            if (nums[i] == 0) {
                swap(nums, i, start++);
            } else if (nums[i] == 1) {
                swap(nums,i--,end--);
            }
        }
    }



    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
