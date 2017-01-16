package leetcode;

/**
 * Created by ych0112xzz on 2016/9/21.
 */
public class RemoveLinkedListElements {

    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        ListNode result=removeElements(l1,6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode removeElements(ListNode head,int val){
        ListNode result = new ListNode(0);
        ListNode cur = head;
        ListNode tmp = result;
        while(cur!=null){
            if(cur.val==val){
                cur = cur.next;
            }else{
                result.next=cur;
                result = result.next;
                cur = cur.next;
            }
        }
        result.next = null;
        return tmp.next;
    }

}
