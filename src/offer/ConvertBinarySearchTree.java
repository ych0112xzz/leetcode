package offer;

import util.TreeNode;

import java.util.Stack;

/**
 * Created by ych0112xzz on 2017/3/16.
 */
public class ConvertBinarySearchTree {

    /*
    递归
     */
    /*public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
        TreeNode left=Convert(pRootOfTree.left);
        TreeNode p=left;
        while(p!=null&&p.right!=null){
            p=p.right;
        }
        if(left!=null){
            p.right=pRootOfTree;
            pRootOfTree.left=p;
        }
        TreeNode right= Convert(pRootOfTree.right);
        if(right!=null){
            pRootOfTree.right=right;
            right.left=pRootOfTree;
        }
        return left==null?pRootOfTree:left;
    }*/


    /*
    循环
     */

    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode root=pRootOfTree;
        if(pRootOfTree==null){
            return null;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode result=null;
        TreeNode pre =null;
        boolean isFirst=true;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if(isFirst){
                pre =cur;
                result=cur;
                isFirst=false;
            }else{
                pre.right=cur;
                cur.left=pre;
                pre=cur;
            }
            cur=cur.right;
        }
        return result;

    }
}
