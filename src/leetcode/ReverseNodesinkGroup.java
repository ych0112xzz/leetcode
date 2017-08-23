package leetcode;

/**
 * Created by ych0112xzz on 2017/5/3.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = length(head);
        ListNode res = new ListNode(0);
        ListNode cur = head;
        res.next = head;
        ListNode pre = res;
        int index = 0;
        while (index + k <= len) {
            ListNode node = cur;
            ListNode next = cur.next;
            while ((index+1) % k != 0) {
                index++;
                ListNode tmp = next;
                next = tmp.next;
                tmp.next=cur;
                cur = tmp;
            }
            node.next = next;
            pre.next = cur;
            pre=node;
            cur = next;
            index++;
        }
        return res.next;
    }

    public int length(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}
