package leetcode;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/10/11.
 */
public class FlattenBinaryTreetoLinkedList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);
        List<Integer> list1 = list;
        list.add(2);
        System.out.println(list1);

    }

   /* public void flatten(TreeNode root) {
        if(root.left!=null){
            TreeNode l = root.left;
            flatten(l);
            root.right = l;
        }if(root.right!=null){
            TreeNode r = root.right;
            flatten(r);
            root.right=r;
        }
    }*/

    /*
    * 先序遍历
    * */
   /* public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = preOrder(root);
        TreeNode head = root;
        head = root;
        for (int i = 1; i < list.size(); i++) {
            head.right = list.get(i);
            head.left = null;
            head = head.right;
        }


    }

    public ArrayList<TreeNode> preOrder(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode tmp = root;
        if (tmp == null) {
            return list;
        }
        TreeNode head = new TreeNode(tmp.val);
        list.add(head);
        if (tmp.left != null) {
            list.addAll(preOrder(tmp.left));
        }
        if (tmp.right != null) {
            list.addAll(preOrder(tmp.right));
        }
        return list;
    }*/

    /*
    * stack+先序遍历
    * */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur != root) {
                head.right = cur;
                head.left = null;
                head = head.right;
            }

        }
    }

    /*
    * 递归
    * */
    /*public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        TreeNode left = root.left;
        if (left != null) {
            root.right = left;
            root.left = null;
            while (left.right != null) {
                left=left.right;
            }
            left.right = tmp;
        }

    }*/
}
