package leetcode;

/**
 * Created by ych0112xzz on 2016/9/12.
 */
public class SwapNodesinPairs {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(5);
//        l1.next.next.next = new ListNode(10);
//        l1.next.next.next.next = new ListNode(11);
        ListNode result = swapPairs(l1);
        // System.out.println(result);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode res=new ListNode(0);
        ListNode cur=res;
        cur.next=head;
        ListNode left=head,right=head;
        while(left!=null&&left.next!=null){
            right=left.next;
            ListNode tmp=right.next;
            cur.next=right;
            left.next=right.next;
            right.next=left;
            cur=left;
            left=tmp;
        }
        return res.next;
    }

}
