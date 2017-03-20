package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ych0112xzz on 2017/2/28.
 */
public class SymmetricTree {

    /*
    递归
     */
    /*public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null||right==null){
            return left==right;
        }
        if(left.val!=right.val){
            return false;
        }
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }*/

    /*
    循环
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();
            if(left==null&&right==null) continue;
            if(left==null ^ right==null) return false;
            if(left.val!=right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
