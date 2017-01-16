package leetcode;

/**
 * Created by ych0112xzz on 2016/9/2.
 */
public class SameTree {

    public static void main(String[] args){
        TreeNode p=new TreeNode(7);
        p.left=new TreeNode(4);
        p.right = new TreeNode(10);
        p.left.left=new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right.left=new TreeNode(8);
        p.right.right = new TreeNode(12);

        //TreeNode q=null;
        TreeNode q=new TreeNode(7);
        q.left=new TreeNode(4);
        q.right = new TreeNode(10);
        q.left.left=new TreeNode(2);
        q.left.right = new TreeNode(5);
        q.right.left=new TreeNode(8);
       // q.right.right = new TreeNode(12);

        boolean result = isSameTree(p, q);
        System.out.println(result);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }

}
