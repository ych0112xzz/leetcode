package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by ych0112xzz on 2017/4/12.
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args){
        //TreeNode p=null;
        TreeNode p=new TreeNode(7);
        p.left=new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left=new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left=new TreeNode(8);
        p.right.right = new TreeNode(12);

       /*LinkedList<Integer> result = postOrder(p);
        System.out.println(result);*/
    }

    /*
    dfs
     */
   /* int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxDown(root);
        return result;
    }

    /更新result；返回以root节点为父节点的最大sum
    public int maxDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxDown(root.left));
        int right = Math.max(0, maxDown(root.right));
        result = Math.max(result, left + right + root.val);
        return Math.max(left, right) + root.val;
    }*/

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int result = Integer.MIN_VALUE;
        LinkedList<TreeNode> list = postOrder(root);
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        hashMap.put(null, 0);
        for (TreeNode tmp : list) {
            int left = Math.max(hashMap.get(tmp.left), 0);
            int right = Math.max(hashMap.get(tmp.right), 0);
            hashMap.put(tmp, Math.max(left, right) + tmp.val);
            result = Math.max(result, left + right + tmp.val);

        }
        return result;
    }

    public static LinkedList<TreeNode> postOrder(TreeNode root) {
        LinkedList<TreeNode> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()||cur!=null) {
            if (cur != null) {
                stack.push(cur);
                result.addFirst(cur);
                cur = cur.right;
            }else{
                cur = stack.pop();
                cur = cur.left;
            }
        }
        return result;
    }


}
