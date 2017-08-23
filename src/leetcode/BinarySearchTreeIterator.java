package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ych0112xzz on 2017/4/12.
 */
public class BinarySearchTreeIterator {
    /*ArrayList<Integer> result;
    int size;
    int index;
    public BinarySearchTreeIterator(TreeNode root) {
        result = inorder(root);
        size = result.size();
        index = 0;
    }

    *//** @return whether we have a next smallest number *//*
    public boolean hasNext() {
        return index < size;
    }

    */
    /**
     * @return the next smallest number
     *//*
    public int next() {
        return result.get(index++);
    }

    public static ArrayList<Integer> inorder(TreeNode root) {
        TreeNode cur = root;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }*/

    Stack<TreeNode> stack = new Stack<>();
    public BinarySearchTreeIterator(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return node.val;
    }
}
