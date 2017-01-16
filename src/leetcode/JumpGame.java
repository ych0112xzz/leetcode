package leetcode;

/**
 * Created by ych0112xzz on 2016/10/11.
 */
public class JumpGame {

    public static void main(String[] args) {
        int nums[] = {2, 1, 2, 1};
        System.out.println(new JumpGame().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        boolean result = false;
        int index = 0;
        int init = nums[0];
        int end = index + init;

        for(int i=index+1;i<=end;i++){
            end = end > (nums[i] + i) ? end : (nums[i] + i);
            if(end>=nums.length-1){
                result = true;
                break;
            }
        }


        return result;
    }


/*
* 回溯
* */
   /* public boolean canJump(int[] nums) {
        int l=nums.length-1;
        for (int i=nums.length-2; i>0;i--) {
            if(i+nums[i]>=l) l=i;
        }
        return nums[0]>=l;
    }*/
/*
* 递归
* */
    /*public boolean canJump(int[] nums) {

        return canJ(nums, nums.length - 1);
    }

    public boolean canJ(int[] nums, int n) {
        if (n == 0) {
            return true;
        }
        boolean pre = canJ(nums, n - 1);
        if(pre==false){
            return false;
        }
        boolean tmp = false;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > n - i - 1) {
                tmp = true;
                break;
            }
        }
        return tmp;
    }*/
}
