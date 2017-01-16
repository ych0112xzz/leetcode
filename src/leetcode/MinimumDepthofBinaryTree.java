package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ych0112xzz on 2016/12/8.
 */
public class MinimumDepthofBinaryTree {

    /*
    * DFS
    * */
   /* public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right)+1;
        }
        if (root.right == null) {
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
    }*/

    /*
    * BFS
    * */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            Queue<TreeNode> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return result;
                }
                if (cur.left != null) {
                    tmp.add(cur.left);
                }
                if (cur.right != null) {
                    tmp.add(cur.right);
                }
            }
            result++;
            queue = tmp;
        }
    }
}
