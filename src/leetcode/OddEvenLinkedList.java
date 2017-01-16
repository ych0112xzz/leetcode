package leetcode;

/**
 * Created by ych0112xzz on 2016/10/25.
 */
public class OddEvenLinkedList {

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        //ListNode l2=l1.next;
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        ListNode result = new OddEvenLinkedList().oddEvenList(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode result = odd;
        ListNode evenStart = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;

            even = even.next;

        }

        odd.next = evenStart;
        return result;
    }
}
