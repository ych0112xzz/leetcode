package leetcode;

/**
 * Created by ych0112xzz on 2016/9/21.
 */
public class DeleteNodeinaLinkedList {

    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2=l1.next;
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);

        deleteNode(l2);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }

    public static void deleteNode(ListNode node) {


            node.val = node.next.val;
            node.next = node.next.next;


//        while(node.next.next!=null){
//            node.val = node.next.val;
////            if(node.next.next==null){
////                node.next = null;
////                break;
////            }
//            node = node.next;
//        }
//        node.val = node.next.val;
//        node.next = null;
    }
}
