package leetcode;

/**
 * Created by ych0112xzz on 2016/7/28.
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        reorderList(l1);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }

    public static void reorderList(ListNode head) {
        //ListNode head1=head;
        ListNode midListNode = getMidListNode(head);
        //ListNode c = midListNode;

        ListNode revListNode = reverseListNode(midListNode);//revListNode为6》5》4，head变为1234，midListNode变为4因为反向以后4的next被赋为null
        ListNode cur = head;
//        ListNode c=head;
//        while(c!=null){
//            System.out.println(c.val);
//            c=c.next;
//        }

        while (revListNode != null) {
            ListNode t = revListNode.next;
            ListNode p = cur.next;
            //cur.next=revListNode;
            if (t == null || revListNode == cur) {

                break;
            }
            cur.next = revListNode;
            revListNode.next = p;
            revListNode = t;
            cur = p;
        }

    }

    public static ListNode getMidListNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
//        ListNode cur = slow;
//        while(cur!=null){
//            System.out.println(cur.val);
//            cur=cur.next;
//        }
        return slow;
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = pre;
        while (head != null) {
            pre = head;
            head = head.next;
            pre.next = cur;
            cur = pre;
        }
//        ListNode c = pre;
//        while(c!=null){
//            System.out.println(c.val);
//            c=c.next;
//        }
        return pre;
    }
}
