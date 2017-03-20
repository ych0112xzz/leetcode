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


    /*public ListNode deleteDuplicates(ListNode head) {
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
    }*/
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
//        // 只有一个结点
//        if (head.next == null) {
//            return head;
//        }
        // 临时的头结点
        ListNode root = new ListNode(0);
        root.next = head;
        // 记录前驱结点
        ListNode prev = root;
        // 记录当前处理的结点
        ListNode node = head;
        while (node != null && node.next != null) {
            // 有重复结点，与node值相同的结点都要删除
            if (node.val == node.next.val) {
                // 找到下一个不同值的节点，注意其有可能也是重复节点
                while (node.next != null && node.next.val == node.val) {
                    node = node.next;
                }
                // 指向下一个节点，prev.next也可能是重复结点
                // 所以prev不要移动到下一个结点
                prev.next = node.next;
            }
            // 相邻两个值不同，说明node不可删除，要保留
            else {
                prev.next = node;
                prev = prev.next;
            }
            node = node.next;
        }
        return root.next;
    }
}
