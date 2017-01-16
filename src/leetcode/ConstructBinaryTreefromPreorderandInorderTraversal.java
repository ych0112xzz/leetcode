package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/12/15.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {


    /*
    * DFS
    * */
    /*public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return buildTree(preorder, inorder,0, 0, len-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preIndex, int start, int end) {
        if (preIndex > preorder.length - 1 || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int index=0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[preIndex]) {
                index = i;
                break;
            }
        }
        root.left = buildTree(preorder, inorder, preIndex + 1, start,index - 1);
        root.right = buildTree(preorder, inorder, preIndex + index - start + 1, index + 1, end);
        return root;
    }*/

    /*
    * 循环
    * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<len;i++) {
            hashMap.put(inorder[i], i);
        }
        stack.push(root);
        for(int i=1;i<len;i++) {
            TreeNode node = stack.peek();
            int preIndex = hashMap.get(node.val);
            int index = hashMap.get(preorder[i]);
            TreeNode cur = new TreeNode(preorder[i]);
            if (index < preIndex) {
                node.left = cur;
            }else{
                while (index > preIndex) {
                    node=stack.pop();
                    preIndex = stack.isEmpty() ? Integer.MAX_VALUE : hashMap.get(stack.peek().val);
                }
                node.right = cur;
            }
            stack.push(cur);
        }
        return root;
    }

}
