package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ych0112xzz on 2016/9/14.
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(7);
        p.left = new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left = new TreeNode(8);
        p.right.right = new TreeNode(12);
        p.right.right.right = new TreeNode(17);
        p.right.right.right.right = new TreeNode(20);
        TreeNode root = invertTree(p);
        System.out.println(root.left.left.left.left.val);
    }

    /*public static TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tmp=root.left;
        TreeNode left = root.right;
        TreeNode right=tmp;
        root.left=invertTree(left);
        root.right = invertTree(right);
        return root;
    }*/

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                cur = deque.poll();
                if (cur.left != null || cur.right != null) {
                    TreeNode tmp = cur.left;
                    cur.left = cur.right;
                    cur.right = tmp;
                    if (cur.left != null) {
                        deque.offer(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offer(cur.right);
                    }
                }
            }
        }
        return root;
    }

}
