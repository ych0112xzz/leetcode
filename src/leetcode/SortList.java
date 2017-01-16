package leetcode;

/**
 * Created by ych0112xzz on 2016/10/18.
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = new SortList().sortList(head);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }

    }

    public ListNode sortList(ListNode head) {
        if (head == null||head.next==null) {
            return head;
        }

        /*
        * 不用第二个sortList函数
        * */
       /* ListNode result = new ListNode(0);
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null&&fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;//这很关键，否则会引用prev后面的数
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);*/

        return sortList(head, null);
    }

    public ListNode sortList(ListNode start, ListNode end) {
        ListNode result = new ListNode(0);
        ListNode slow = start;
        ListNode fast = start;

        if (start.next != end) {
            while (fast != end && fast.next != end) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode l1 = sortList(start, slow);
            ListNode l2 = sortList(slow, end);
            result.next = merge(l1, l2);
        }else{
            result.next=start;
            start.next = null;//不加会形成死循环，result将start后面的引用都保留下来了
        }
        return result.next;
    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode result = new ListNode(0);
        ListNode rt = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
          //  result.next = null;//不加会形成死循环，将2的next值赋为2，出不了循环
        }
        result.next = l1 != null ? l1 : l2;
        return rt.next;
    }
}

