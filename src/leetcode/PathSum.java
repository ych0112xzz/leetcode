package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ych0112xzz on 2016/10/13.
 */
public class PathSum {

    public static void main(String[] args){
        //TreeNode p=null;
        TreeNode p=new TreeNode(7);
        p.left=new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left=new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left=new TreeNode(8);
        p.right.right = new TreeNode(12);
        p.right.right.right = new TreeNode(17);
        p.right.right.right.right = new TreeNode(20);
        System.out.println(new PathSum().hasPathSum(p,25));
    }

    /*public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null&&root.val==sum){
            return true;
        }
        *//*if(root.right==null){
            return hasPathSum(root.left, sum - root.val);
        }
        if(root.left==null){
            return hasPathSum(root.right, sum - root.val);
        }*//*
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right, sum - root.val);
    }*/

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.poll();
                if (cur.left == null && cur.right == null && cur.val == sum) {
                    return true;
                }
                if (cur.left != null) {
                    deque.offer(cur.left);
                    cur.left.val += cur.val;
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                    cur.right.val += cur.val;
                }
            }
        }
        return false;
    }
}
