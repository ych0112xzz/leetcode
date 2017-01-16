package leetcode;

/**
 * Created by ych0112xzz on 2016/10/19.
 */
public class InsertionSortList {

    public static void main(String[] args) {
        System.out.print(Integer.MAX_VALUE);
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);
        ListNode result = new InsertionSortList().insertionSortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head;
        ListNode result = new ListNode(Integer.MIN_VALUE);
        result.next = head;
        ListNode cur = head.next;
        ListNode prev = head;
        ListNode tmpPrev = result;
        while (cur != null) {
            ListNode p = cur.next;
            while (tmp != cur) {
                if (cur.val >= tmp.val) {
                    tmpPrev = tmp;
                    tmp = tmp.next;
                } else {
                    tmpPrev.next = cur;
                    cur.next = tmp;
                    prev.next = p;
                    break;
                }
            }
            tmpPrev = result;

            if (tmp == cur) {
                prev = cur;
            }
            tmp = result.next;
            cur = p;
        }


        return result.next;
    }
}
