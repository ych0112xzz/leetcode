package leetcode;

/**
 * Created by ych0112xzz on 2016/7/22.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(5);
        l1.next.next.next=new ListNode(10);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(5);
        l2.next.next=new ListNode(7);
        ListNode h=mergeTwoLists(l1, l2);
        while(h!=null){
            System.out.print(h.val);
            h=h.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1==null){
//            return l2;
//        }
//        if(l2==null){
//            return l1;
//        }
        ListNode h = new ListNode(0);
        ListNode cur = h;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 <= val2) {
                cur.next = new ListNode(val1);
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = new ListNode(val2);
                cur = cur.next;
                l2 = l2.next;
            }


        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }

        return h.next;
    }
}
