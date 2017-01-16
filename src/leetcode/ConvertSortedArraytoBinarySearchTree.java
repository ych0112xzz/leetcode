package leetcode;

/**
 * Created by ych0112xzz on 2016/9/6.
 */
public class ConvertSortedArraytoBinarySearchTree {

    public static void main(String[] args){
        int[] nums = {3,5,8};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root.right.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root;
        if(nums.length==0){
            return null;
        }
        if(nums.length==1){
            return new TreeNode(nums[0]);
        }
        int mid = nums.length / 2;
        root = new TreeNode(nums[mid]);
        int[] tmp1 = new int[mid];
        int[] tmp2 = new int[nums.length - 1 - mid];
        for(int i=0;i<nums.length;i++){
            if(i<mid){
                tmp1[i] = nums[i];
                System.out.println(tmp1[i]);
            }
            if(i>mid){
                tmp2[i-mid-1] = nums[i];
                System.out.println(i);
                //System.out.println(tmp2[i]);
            }
        }

        root.left = sortedArrayToBST(tmp1);
        root.right = sortedArrayToBST(tmp2);


        return root;
    }
}
