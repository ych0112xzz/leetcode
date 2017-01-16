package leetcode;

/**
 * Created by ych0112xzz on 2016/9/5.
 */
public class BalancedBinaryTree {

    public static void main(String[] args){
        TreeNode p=new TreeNode(7);
        p.left=new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left=new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left=new TreeNode(8);
        p.right.right = new TreeNode(12);
        p.right.right.right = new TreeNode(17);
       // p.right.right.right.right = new TreeNode(20);
        boolean result = isBalanced(p);
        System.out.println(result);

    }



    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftDepth=depthOfBinaryTree(root.left);
        int rightDepth = depthOfBinaryTree(root.right);
        if(Math.abs(leftDepth-rightDepth)>1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }



    }

    public static int depthOfBinaryTree(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(depthOfBinaryTree(root.left),depthOfBinaryTree(root.right))+1;
    }
}
