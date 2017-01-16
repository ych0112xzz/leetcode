package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/9/5.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args){
        //TreeNode p=null;
        TreeNode p=new TreeNode(7);
        p.left=new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left=new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left=new TreeNode(8);
        p.right.right = new TreeNode(12);
        p.right.right.right = new TreeNode(17);
        p.right.right.right.right = new TreeNode(20);
        List<List<Integer>> result = zigzagLevelOrder(p);
        System.out.println(result);
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagLevelOrder(root, result, 0);
        return result;
    }

    private static void zigzagLevelOrder(TreeNode root, List<List<Integer>> result, int i) {
        if (root == null) {
            return;
        }
        if (i >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        if (i % 2 == 0) {
            result.get(i).add(root.val);
        }else{
            ((LinkedList) result.get(i)).addFirst(root.val);
        }
        zigzagLevelOrder(root.left, result, i + 1);
        zigzagLevelOrder(root.right, result, i + 1);
    }

    /*public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> treeNodeStack = new LinkedList<>();
        boolean isRight = true;
        int leverNum=0;
        if(root==null){
            return result;
        }
        list.add(root.val);
        result.add(list);
        leverNum=1;
        treeNodeStack.push(root);
        list = new ArrayList<>();
        int number = 0;
        while(leverNum>0) {
            if (isRight) {

                while (leverNum > 0) {

                    TreeNode tmp = treeNodeStack.pop();
                    if (tmp.right != null) {
                        treeNodeStack.push(tmp.right);
                        list.add(tmp.right.val);
                        number++;
                    }
                    if (tmp.left != null) {
                        treeNodeStack.push(tmp.left);
                        list.add(tmp.left.val);
                        number++;
                    }
                    leverNum--;
                }

                leverNum = number;
                //System.out.println(leverNum);
                number=0;
                isRight = false;
            } else {
                //int number = 0;

                while (leverNum > 0) {
                    System.out.println(leverNum);
                    TreeNode tmp = treeNodeStack.pop();
                    if (tmp.left != null) {
                        treeNodeStack.push(tmp.left);
                        list.add(tmp.left.val);
                        number +=1;
                    }
                    if (tmp.right != null) {
                        treeNodeStack.push(tmp.right);
                        list.add(tmp.right.val);
                        number++;
                    }
                    System.out.println(number);
                    leverNum--;
                }
                leverNum = number;
                //System.out.println(leverNum);
                number=0;
                isRight = true;
            }
            result.add(list);
            list = new ArrayList<>();
        }
        return result;
    }*/
}
