package leetcode;

import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/11/1.
 */
public class LowestCommonAncestorofaBinaryTree {

    public static void main(String[] args) {
        //TreeNode p=null;
        TreeNode p = new TreeNode(7);
        p.left = new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.left.right.right = new TreeNode(9);
        p.right.left = new TreeNode(8);
        p.right.right = new TreeNode(12);
        p.left.right.left = new TreeNode(3);
        p.left.right.right = new TreeNode(6);
        TreeNode p1 = p.left;
        TreeNode p2 = p.left.right.right;
       /* p.right.right.right = new TreeNode(17);
        p.right.right.right.right = new TreeNode(20);*/
        System.out.println(new LowestCommonAncestorofaBinaryTree().lowestCommonAncestor(p,p1,p2).val);
    }
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode lNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);
        if(lNode!=null&&rNode!=null){
            return root;
        }
        if(lNode!=null){
            return lNode;
        }
        return rNode;
    }*/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;
        TreeNode first = null;
        TreeNode cur = root;
        if (root == null) {
            return root;
        }
        boolean isFather = false;
        boolean isFind = false;
        TreeNode father=root;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                if (cur == p || cur == q) {
                    if(isFather&&isFind){
                        return first;
                    } else if (isFind) {
                        return father;
                    }
                    first = cur;
                    isFather = true;
                    isFind = true;
                    father = cur;
                }
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.left == father || cur.right == father) {
                isFather = false;
                father=cur;
            }
            if (cur.right != null&&cur.right!=pre) {
                cur = cur.right;
                continue;
            }
            pre =cur;
            stack.pop();
            cur = null;
        }
        return result;
    }
}
