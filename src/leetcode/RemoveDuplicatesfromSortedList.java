package leetcode;

/**
 * Created by ych0112xzz on 2016/9/13.
 */
public class RemoveDuplicatesfromSortedList {

    public static void main(String[] args){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(5);
        l1.next.next.next=new ListNode(10);
        l1.next.next.next.next=new ListNode(13);
        ListNode h = deleteDuplicates(l1);
        while(h!=null){
            System.out.print(h.val);
            h=h.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pre=head;
        ListNode tmp = head;
        if(head==null||head.next==null){
            return head;
        }
        tmp=head.next;
        while(tmp!=null) {
            if (tmp.val == pre.val) {
                tmp = tmp.next;
                pre.next = tmp;
            } else {
                pre = tmp;
                tmp = tmp.next;
            }
        }
        return head;
    }
}
