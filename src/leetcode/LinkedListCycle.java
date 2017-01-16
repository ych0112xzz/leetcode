package leetcode;

/**
 * Created by ych0112xzz on 2016/9/29.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            if(slow==null){
                return false;
            }
            fast = fast.next.next;
            if(fast==null){
                return false;
            }
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

}
