package leetcode;

import java.util.*;

/**
 * Created by ych0112xzz on 2016/12/8.
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        List cur = result;
        cur = null;
        System.out.println(cur + "\t" + result);
    }

    /*
    * dfs
    * */
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }*/

    /*
    * dfs2
    * */
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        dfs(root.left,result);
        dfs(root.right, result);
        result.add(root.val);
    }*/


    /*
    * 迭代
    * */
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.peek();
                if (cur.right == null||cur.right==tmp) {
                    result.add(cur.val);
                    tmp = cur;
                    stack.pop();
                    cur=null;
                } else {
                    cur = cur.right;
                }
            }
        }
        return result;
    }*/

    /*
    * 循环，preOrder反过来
    * */
   /* public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }*/


    /*
    * 第三方类
    * */
    class TreeNodeStack {
        TreeNode node;
        int count;

        TreeNodeStack(TreeNode node) {
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNodeStack> stack = new ArrayDeque<TreeNodeStack>();
        stack.add(new TreeNodeStack(root));
        while (stack.size() > 0) {
            TreeNodeStack s = stack.peekLast();
            s.count++;
            if (s.node == null) {
                stack.pollLast();
            }
            else if(s.count==1){
                stack.add(new TreeNodeStack(s.node.left));
            }
            else if(s.count==2){
                stack.add(new TreeNodeStack(s.node.right));
            }
            else if (s.count == 3) {
                stack.pollLast();
                result.add(s.node.val);
            }
        }
        return result;
    }
}
