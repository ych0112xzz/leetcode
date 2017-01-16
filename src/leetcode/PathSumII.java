package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ych0112xzz on 2016/12/14.
 */
public class PathSumII {

    public static void main(String[] args) {
        //TreeNode p=null;
        TreeNode p = new TreeNode(7);
        p.left = new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.left.right.right = new TreeNode(9);
        p.right.left = new TreeNode(8);
        p.right.right = new TreeNode(12);
        p.right.right.right = new TreeNode(17);
        p.right.right.right.right = new TreeNode(20);
        System.out.println(new PathSumII().pathSum(p, 25));
    }

   /* public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        HashMap<TreeNode, TreeNode> hashMap = new HashMap<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        hashMap.put(root, null);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.poll();
                if (cur.left == null && cur.right == null && cur.val == sum) {
                    TreeNode treeNode = cur;
                    LinkedList<Integer> tmp = new LinkedList<>();
                    TreeNode value = hashMap.get(treeNode);
                    while (value != null) {
                        tmp.addFirst(treeNode.val - value.val);
                        treeNode = value;
                        value = hashMap.get(treeNode);
                    }
                    tmp.addFirst(treeNode.val);
                    result.add(tmp);
                }
                if(cur.left!=null){
                    deque.offer(cur.left);
                    cur.left.val += cur.val;
                    hashMap.put(cur.left, cur);
                }
                if(cur.right!=null){
                    deque.offer(cur.right);
                    cur.right.val += cur.val;
                    hashMap.put(cur.right, cur);
                }
            }
        }
        return result;
    }*/


    /*
    * DFS
    * */
   /* public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSum(root, sum, result, list);
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(list));
        }else{
            pathSum(root.left, sum - root.val, result, list);
            pathSum(root.right, sum - root.val, result, list);
        }
        list.remove(list.size() - 1);
    }*/


    /*BFS+stack*/
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int tmp = 0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                tmp += cur.val;
                list.add(cur.val);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            }
            if (cur.left == null && cur.right == null && tmp == sum) {
                result.add(new LinkedList<Integer>(list));
            }
            pre = cur;
            stack.pop();
            list.remove(list.size() - 1);
            tmp -= cur.val;
            cur = null;
        }
        return result;
    }
}
