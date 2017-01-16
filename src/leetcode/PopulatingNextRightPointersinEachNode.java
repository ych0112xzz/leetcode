package leetcode;

/**
 * Created by ych0112xzz on 2016/12/20.
 */
public class PopulatingNextRightPointersinEachNode {

    /*
    * DFS
    * */
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;

        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
    /*public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connect(root.left);
        connect(root.right);
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        while (left != null && right != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }*/


    /*
    * O(1)space
    * */
    /*public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while (head != null) {
            TreeLinkNode cur = head;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.next != null&&cur.next.left!=null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            head = head.left;
        }
    }*/
}
