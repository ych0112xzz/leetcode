package leetcode;

/**
 * Created by ych0112xzz on 2017/5/11.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode fast=res;
        ListNode slow = res;
        int len = 0;
        while(fast.next!=null){
            fast = fast.next;
            len++;
        }

        for(int i=0;i<len-k%len;i++) {
            slow = slow.next;
        }
        fast.next = res.next;
        res.next = slow.next;
        slow.next = null;
        return res;
    }
}
