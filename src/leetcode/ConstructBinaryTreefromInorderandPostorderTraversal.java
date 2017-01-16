package leetcode;


import java.util.HashMap;
import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/12/20.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    /*HashMap<Integer, Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        for(int i=0;i<inorder.length;i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, len - 1, 0,len - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int start, int end, int pStart,int pEnd) {
        if (pStart>pEnd||start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd]);
        int i = hashMap.get(postorder[pEnd]);
        root.left = buildTree(inorder, postorder, start, i - 1,pStart,pStart+i-start-1);
        root.right = buildTree(inorder, postorder, i + 1, end, pStart+i-start,pEnd-1);
        return root;
    }*/


    /*
    * 循环
    * */
    /*public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[len - 1]);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 0; i < len; i++) {
            hashMap.put(inorder[i], i);
        }
        for (int i = len - 2; i >= 0; i--) {
            TreeNode node = stack.peek();
            int preIndex = hashMap.get(node.val);
            int index = hashMap.get(postorder[i]);
            TreeNode cur = new TreeNode(postorder[i]);
            if (index > preIndex) {
                node.right = cur;
            }else{
                while (index < preIndex) {
                    node = stack.pop();
                    preIndex = stack.isEmpty() ? Integer.MIN_VALUE : hashMap.get(stack.peek().val);
                }
                node.left = cur;
            }
            stack.push(cur);
        }
        return root;
    }*/

    /*
    * 另一种循环(也可用在ConstructBinaryTreefromPreorderandInorderTraversal)
    * */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[len - 1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //在ConstructBinaryTreefromPreorderandInorderTraversal中，i初始值1，j初始值0，--变为++
        int i=len-2;
        int j = len - 1;
        while (i >= 0) {
            TreeNode node = new TreeNode(postorder[i]);
            TreeNode cur = stack.peek();
            if (cur.val != inorder[j]) {
                stack.push(node);
                cur.right = node;
                i--;
            }else{
                while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    cur = stack.pop();
                    j--;
                }
                cur.left = node;
                stack.push(node);
                i--;
            }
        }
        return root;
    }
}
