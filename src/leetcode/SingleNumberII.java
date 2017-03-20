package leetcode;

/**
 * Created by ych0112xzz on 2016/9/8.
 */
public class SingleNumberII {

    public static int singleNumber(int[] nums) {

        return 0;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        int depth = 0;
        return isBalance(root, depth);
    }

    public boolean isBalance(TreeNode root, int depth) {
        if (root == null) {
            depth = 0;
            return true;
        }

        int l = 0;
        int r = 0;
        if (isBalance(root.left, l) && isBalance(root.right, r)) {
            if (Math.abs(l - r) <= 1) {
                depth = Math.max(l, r) + 1;
                return true;
            } else {
                return false;
            }

        }
        return false;
    }
}
