package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ych0112xzz on 2016/11/10.
 */
public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        int n = 3;
        UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
        List<TreeNode> result = u.generateTrees(n);
        for (int i = 0; i < result.size(); i++) {
            u.printTree(result.get(i));

            System.out.println("********");


        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n==0){
            return result;
        }
        List<TreeNode> dp[] = new ArrayList[n + 1];
        List list = new ArrayList();
        list.add(null);
        dp[0] = list;
        for(int i=1;i<n+1;i++){
            dp[i] = new ArrayList<TreeNode>();
            for(int j=0;j<i;j++){
                List lNode = dp[j];
                List rNode = dp[i - 1 - j];
                for(int l=0;l<lNode.size();l++){
                    for(int r=0;r<rNode.size();r++){
                        TreeNode root = new TreeNode(j + 1);
                        root.left = (TreeNode) lNode.get(l);
                        root.right = nodeClone((TreeNode) rNode.get(r),j+1);
                        result.add(root);

                    }
                }
            }
            dp[i]=result;
            result = new ArrayList<>();
        }
        return dp[n];
    }


    public TreeNode nodeClone(TreeNode root,int j) {
        if(root==null){
            return root;
        }
        TreeNode result = new TreeNode(root.val+j);
        if(root.left!=null){
            result.left = nodeClone(root.left,j);
        }
        if(root.right!=null){
            result.right = nodeClone(root.right,j);
        }
        return result;
    }


    /*
    * 递归
    * */
    /*public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n==0){
            return result;
        }
        return generateTrees(1, n + 1);

    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start == end) {
            result.add(null);
            return result;
        }
        for (int i = start; i < end; i++) {
            List<TreeNode> left = generateTrees(start, i);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }*/

    public void printTree(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();

        int current;//当前层 还未打印的结点个数
        int next;//下一层结点个数

        queue.offer(root);
        current = 1;
        next = 0;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.printf("%-4d", currentNode.val);
            current--;

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
                next++;
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
                next++;
            }
            if (current == 0) {
                System.out.println();
                current = next;
                next = 0;
            }
        }
    }
}
