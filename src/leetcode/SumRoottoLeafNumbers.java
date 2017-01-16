package leetcode;

import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/12/20.
 */
public class SumRoottoLeafNumbers {


    /*
    * dfs
    * */
    /*public int sumNumbers(TreeNode root) {
        int sum = 0;
        return sumNumbers(root, sum);
    }

    private int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val + sum * 10;
        }
       *//* if (root.left == null && root.right != null) {
            return sumNumbers(root.right, root.val + sum * 10);
        }
        if (root.left != null && root.right == null) {
            return sumNumbers(root.left, root.val + sum * 10);
        }*//*
        return sumNumbers(root.left, root.val + sum * 10) + sumNumbers(root.right, root.val + sum * 10);
    }*/

    public int sumNumbers(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int sum = 0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                sum = sum * 10 + cur.val;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur != pre) {
                cur = cur.right;
                continue;
            }
            if (cur.right == null && cur.left == null) {
                result += sum;
            }
            sum = (sum - cur.val) / 10;
            pre = cur;
            stack.pop();
            cur = null;
        }
        return result;
    }
}
