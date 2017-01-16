package test;

import test.TreeNode;

/**
 * Created by ych0112xzz on 2016/9/13.
 */
public class MiniSUm {
    public static void main(String[] args){
        TreeNode p=new TreeNode(7);
        p.left=new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left=new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.left.left.left = new TreeNode(10);
        p.left.left.right = new TreeNode(9);
        p.left.right.left = new TreeNode(1);
        p.right.left=new TreeNode(8);
        p.right.right = new TreeNode(12);
        p.right.right.right = new TreeNode(17);
        p.right.right.right.right = new TreeNode(20);
        int depth=minSum(p);
        System.out.println(depth);
    }

    public static int minSum(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return minSum(root.right)+root.val;
        }
        if(root.right==null){
            return minSum(root.left)+root.val;
        }
        return Math.min(minSum(root.right),minSum(root.left)) + root.val;

    }
}
