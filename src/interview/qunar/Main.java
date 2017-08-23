package interview.qunar;

import interview.qunar.TreeNode;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedList;


/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
*/



public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String beginWord = sc.nextLine();
        String endWord = sc.nextLine();
        String word = sc.nextLine();
        String[] data = word.split(" ");
        HashSet<String> hashset = new HashSet<>();
        for (String s : data) {
            hashset.add(s);
        }
        System.out.println(ladderLength(beginWord, endWord, hashset));
    }

    public static int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        queue.add(null);
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        int level = 1;
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str != null) {
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String word = new String(chars);
                        if (word.equals(end)) return level + 1;
                        if (dict.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            } else {
                level++;

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return 0;
    }

   /* public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }*/
}
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] preOrder = new int[len];
        int[] inOrder=new int[len];
        for(int i=0;i<len;i++) {
            preOrder[i] = sc.nextInt();
        }
        for(int i=0;i<len;i++) {
            inOrder[i]=sc.nextInt();
        }

        TreeNode root = buildTree(preOrder, inOrder);
        ArrayList<ArrayList<Integer>> result =levelOrder(root);
        print(result);


    }
    public static void print(ArrayList<ArrayList<Integer>> result){
        String rt = "";
        for(int i=0;i<result.size();i++) {
            for(int j=0;j<result.get(i).size();j++) {
                rt += result.get(i).get(j)+" ";
            }
        }
        System.out.println(rt.trim());
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
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
            //以node为根节点，如果当前节点的在inorder中索引值小于node的索引值，则为node的左节点，
            int preIndex = hashMap.get(node.val);//node节点在inorder中的索引值
            int index = hashMap.get(preorder[i]);//pre[i]在inorder中的索引值
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

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        levelOrder(root, result, 0);
        return result;

    }

    private static void levelOrder(TreeNode root, ArrayList<ArrayList<Integer>> result, int i) {
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
}*/
