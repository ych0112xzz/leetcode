package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ych0112xzz on 2017/4/12.
 */
public class KthSmallestElementinaBST {
    public static void main(String[] args){
        //TreeNode p=null;
        TreeNode p=new TreeNode(7);
        p.left=new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left=new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left=new TreeNode(8);
        p.right.right = new TreeNode(12);


        System.out.println(kthSmallest(p,3));
    }


    //inoder思想
   /* public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        int index=0;
        int result = 0;
        while (!deque.isEmpty() || cur != null) {
            while (cur != null) {
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            index++;
            if (index == k) {
                return cur.val;
            }
            cur = cur.right;

        }
        return result;
    }*/

    public static  int kthSmallest(TreeNode root, int k) {
        if(root==null||k>nodeCount(root)){
            return 0;
        }
        int left = nodeCount(root.left);  // this value can be saved in the root node
        if(left + 1 == k) {
            return root.val;
        } else if (left + 1 < k) {
            return kthSmallest(root.right, k - left - 1);
        } else {
            return kthSmallest(root.left, k);
        }
    }

    private static int nodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }
}
