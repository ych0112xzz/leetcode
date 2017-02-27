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
        ListNode result = head;

        if (head == null) {
            return null;
        }
        ListNode h1 = head;
//        if (h1.next == null) {
//            return result;
//        }
        ListNode h2 = head.next;
        ListNode pre = null;
        int i = 0;
        while (head != null) {
            h1 = head;
            if (h1.next == null) {
                return result;
            }
            h2 = h1.next;
            if (i == 0) {
                result = h2;
            }

            ListNode h3 = h2.next;
            h2.next = h1;
            if (pre != null) {
                pre.next = h2;
            }
            h1.next = h3;
            pre = h1;
            head = h3;
            i++;


        }
        return result;
    }
}
