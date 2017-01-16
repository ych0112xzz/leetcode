package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/9/5.
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args){
        TreeNode p=new TreeNode(7);
        p.left=new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left=new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left=new TreeNode(6);
        p.right.right = new TreeNode(12);
        p.right.right.right = new TreeNode(17);
        // p.right.right.right.right = new TreeNode(20);
        boolean result = isValidBST(p);
        System.out.println(Integer.MAX_VALUE + "\t" + Integer.MIN_VALUE);
        System.out.println(result);

    }

   /* public static boolean isValidBST(TreeNode root) {
        List<Integer> list= new ArrayList();
        boolean result = false;
        if(root==null){
            return true;
        }
        list = inorderTraversal(root);
        for(int i=0;i< list.size()-1;i++){
            if(list.get(i) >= list.get(i + 1)){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        if(root.left!=null){
            List<Integer> tmp = inorderTraversal(root.left);
            result.addAll(tmp);
        }
        result.add(root.val);
        if(root.right!=null){
            List<Integer> tmp = inorderTraversal(root.right);
            result.addAll(tmp);
        }

        return result;
    }*/

    /*DFS*/
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }

    private static boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);
    }
}
