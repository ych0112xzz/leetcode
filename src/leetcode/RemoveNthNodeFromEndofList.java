package leetcode;

/**
 * Created by ych0112xzz on 2016/7/22.
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(5);
        l1.next.next.next=new ListNode(10);
        l1.next.next.next.next=new ListNode(13);
        ListNode h = removeNthFromEnd(l1,1);
        while(h!=null){
            System.out.print(h.val);
            h=h.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        if (n > size || n < 0||size==1||size==0) {
            return null;
        }
//        if(n==size){
//            return head.next;
//        }
        int num = size - n;
        ListNode cur=new ListNode(0);
       // System.out.print(cur.next.val);
        ListNode result = cur;
        for (int i = 0; i < num; i++) {
//            int val = head.val;
//            cur.next = new ListNode(val);
            cur.next = head;//写成这样要处理n=1的异常，因为cur。next=head，而head项后还有
            cur = cur.next;
            head = head.next;
        }
//        if(n==1){
//            return result.next;
//        }

        //ListNode tem = head.next;
//        int val1 = head.next.next.val;
//        ListNode p = new ListNode(val1);

        cur.next=head.next;
//        cur = cur.next;
//        while(head!=null){
//            int val = head.val;
//            cur.next = new ListNode(val);
//            cur = cur.next;
//            head = head.next;
//        }
//        for (int i = 0; i < n - 2; i++) {
//            cur.next = head.next;
//        }

        return result.next;
    }

    public static int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
       // System.out.println(size);
        return size;
    }
}

