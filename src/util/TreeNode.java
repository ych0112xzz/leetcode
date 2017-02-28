package util;

import java.util.LinkedList;

/**
 * Created by ych0112xzz on 2016/12/27.
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int x) {
        this.val = x;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(7);
        p.left = new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left = new TreeNode(8);
        p.right.right = new TreeNode(12);
        printTree(p);
    }

    /*
    打印树
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty Tree!");
        }
        int level = 20;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = level; i >= 0; i--) {
                System.out.print(" ");
            }
            while (size-- > 0) {
                TreeNode cur = list.poll();
                System.out.print(cur.val);
                if (size != 0) {
                    System.out.print("    ");
                }
                if (cur.left != null) {
                    list.offer(cur.left);
                }
                if (cur.right != null) {
                    list.offer(cur.right);
                }
            }
            for (int i = level; i >= 0; i--) {
                System.out.print(" ");
            }
            level -= 2;
            System.out.println();
        }
    }
}
