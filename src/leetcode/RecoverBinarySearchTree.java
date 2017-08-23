package leetcode;

/**
 * Created by ych0112xzz on 2017/5/12.
 */
public class RecoverBinarySearchTree {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (first == null && prev.val >= root.val) {
            first = prev;
        }
        if (first != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}
