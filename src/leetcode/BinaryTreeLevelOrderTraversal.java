package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/9/2.
 */
public class BinaryTreeLevelOrderTraversal {
    //static List result;


    public static void main(String[] args){
        //TreeNode p=null;
        TreeNode p=new TreeNode(7);
        p.left=new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left=new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left=new TreeNode(8);
        p.right.right = new TreeNode(12);

        List<List<Integer>> result = levelOrder(p);
        System.out.println(result);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, result, 0);
        return result;

    }

    private static void levelOrder(TreeNode root, List<List<Integer>> result, int i) {
        if (root == null) {
            return;
        }
        if (result.size() <= i) {
            result.add(new ArrayList<Integer>());
        }
        result.get(i).add(root.val);
        levelOrder(root.left, result, i + 1);
        levelOrder(root.right, result, i + 1);
    }

    /*public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        ArrayList<TreeNode> aList=new ArrayList<>();
        int lever=0;

        if(root==null){
            return result;
        }

//        if(root.left!=null){
//            aList.add(root.left);
//        }
//        if(root.right!=null){
//            aList.add(root.right);
//        }
        aList.add(root);
        list.add(root.val);
        System.out.println(root.val);
        result.add(list);
        list=new ArrayList();

        while(aList!=null){
            boolean isOver=true;
            lever++;
            ArrayList tmp=new ArrayList();
            for(int i=0;i<aList.size();i++){
                if(aList.get(i).left!=null){
                    isOver=false;
                    tmp.add(aList.get(i).left);
                    list.add(aList.get(i).left.val);
                }
                if(aList.get(i).right!=null){
                    isOver=false;
                    tmp.add(aList.get(i).right);
                    list.add(aList.get(i).right.val);
                }

            }
            if(isOver){
                break;
            }
            result.add(list);
            list=new ArrayList();
            //aList=new ArrayList();
            aList=tmp;
        }

        //Collections.reverse(result);
        return result;
    }*/
}
