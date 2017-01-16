package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/9/2.
 */
public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        //TreeNode p=null;
        TreeNode p = new TreeNode(7);
        p.left = new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left = new TreeNode(8);
        p.right.right = new TreeNode(12);
        p.right.right.right = new TreeNode(17);
        p.right.right.right.right = new TreeNode(20);
        int depth = maxDepth(p);
        System.out.println(depth);
    }

    /*
    * bfs
    * */
   /* public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left !=null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result++;
        }
        return result;
    }*/

    /*
    * dfs
    * */
   /* public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;


    }*/
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        return 0;
    }

}
