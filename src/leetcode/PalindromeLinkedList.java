package leetcode;

import java.util.List;

/**
 * Created by ych0112xzz on 2016/7/25.
 */
public class PalindromeLinkedList {
    public  static void main(String[] args){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(5);
       // l1.next.next.next=new ListNode(5);
        l1.next.next.next=new ListNode(4);
        l1.next.next.next.next=new ListNode(2);
//        ListNode h=getMidNode(l1);
//        ListNode h1 = reverseListNode(h);//此操作会修改h的值，注意对对象的引用
////        while(h!=null){
////            System.out.print(h.val+"-->");
////            h=h.next;
////        }
////        System.out.println("\n");
//        while(h1!=null){
//            System.out.print(h1.val+"-->");
//            h1=h1.next;
//        }
        boolean is = isPalindrome(l1);
        System.out.print(is);
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode mNode = getMidNode(head);
        mNode = reverseListNode(mNode);
        boolean is =true;
        while(head!=null&&mNode!=null){
            if(mNode.val!=head.val){
                is = false;
                break;
            }else{
                head=head.next;
                mNode = mNode.next;
            }

        }

        return is;
    }

    public static ListNode getMidNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverseListNode(ListNode head){

        ListNode prev=null;
        ListNode cur=prev;
       // ListNode result = pre;
        while(head!=null){
            prev=head;
            head = head.next;
            prev.next=cur;
            cur=prev;

//            ListNode t = head.next;
//
//            head.next = prev;
//            prev = head;
//
//            head = t;
        }
        return prev;
    }
}
