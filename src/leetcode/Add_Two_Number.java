package leetcode;

/**
 * Created by ych0112xzz on 2016/7/21.
 */
public class Add_Two_Number {

    public static void main(String[] args){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(5);
        l1.next.next=new ListNode(4);
        ListNode l2=new ListNode(7);
        l2.next=new ListNode(5);
        l2.next.next=new ListNode(6);
        ListNode h=addTwoNumbers(l1, l2);
        while(h!=null){
            System.out.print(h.val);
            h=h.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode h = new ListNode(0);
        ListNode cur = h;
        int plus = 0;
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + plus;
            plus = value / 10;
            int sum = value % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;

        }
        if (l1 != null) {
            if (plus != 0) {
                cur.next = addTwoNumbers(l1, new ListNode(plus));
            } else {
                cur.next = l1;
            }
        } else if (l2 != null) {
            if (plus != 0) {
                cur.next = addTwoNumbers(l2, new ListNode(plus));
            } else {
                cur.next = l2;
            }

        }else if(plus!=0){
            cur.next = new ListNode(plus);
        }
        return h.next;
    }
}
