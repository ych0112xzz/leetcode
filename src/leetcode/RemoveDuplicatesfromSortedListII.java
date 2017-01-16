package leetcode;

/**
 * Created by ych0112xzz on 2016/10/17.
 */
public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next = new ListNode(5);
        ListNode result = new RemoveDuplicatesfromSortedListII().deleteDuplicates(head);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        if(head.next==null){
            return head;
        }
        ListNode start = new ListNode(0);
        ListNode result = start;
        ListNode tmp = start;
        start.next = head;
        head = head.next;
        start = start.next;
        boolean isEqual=false;
        while(head!=null){
            if(head.val==start.val){
                isEqual = true;
                head=head.next;
                if(head==null){
                    tmp.next = head;
                    break;
                }
            }else if(isEqual){
                tmp.next=head;
                start = head;
                head = head.next;

                isEqual = false;
                if(head==null){
                    tmp.next.next = head;
                }
            } else{
                tmp.next = start;
                start = head;
                head = head.next;
                tmp = tmp.next;
                if(head==null){
                    tmp.next = start;
                }
            }
        }

        return result.next;
    }
}
