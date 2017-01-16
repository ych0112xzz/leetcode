package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/12/21.
 */
public class BinaryTreeRightSideView {

    /*
    * DFS
    * */
    /*public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Integer> left = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        for (int i = right.size(); i < left.size(); i++) {
            right.add(left.get(i));
        }
        result = right;
        ((LinkedList) result).addFirst(root.val);
        return result;
    }*/

    /*
    * DFS2
    * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    /*
    * BFS(先序遍历反过来或者层序遍历取最右边元素)
    * */
    /*public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur = root;
        int height=0;
        int tmp = height;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                tmp++;
                if (tmp > height) {
                    height = tmp;
                    result.add(cur.val);
                }
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.peek();
            if (cur.left != null&&cur.left!=pre) {
                cur = cur.left;
                continue;
            }
            pre = cur;
            stack.pop();
            tmp--;
            cur = null;
        }
        return result;
    }*/
}
