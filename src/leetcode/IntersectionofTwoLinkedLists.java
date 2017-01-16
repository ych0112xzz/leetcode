package leetcode;

import java.util.HashSet;

/**
 * Created by ych0112xzz on 2016/10/18.
 */
public class IntersectionofTwoLinkedLists {

   /* public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode slowA = headA;
        ListNode slowB = headB;
        ListNode tmp = null;
        while(slowA!=null&&slowB!=null){
            slowA = slowA.next;
            slowB = slowB.next;
        }
        if(slowA!=null){
            tmp = headA;
            while(slowA!=null){
                tmp = tmp.next;
                slowA = slowA.next;
            }
            slowB = headB;
            while(slowB!=tmp){
                tmp = tmp.next;
                slowB = slowB.next;
            }
            return tmp;
        }else{
            tmp = headB;
            while(slowB!=null){
                tmp = tmp.next;
                slowB = slowB.next;
            }
            slowA = headA;
            while(slowA!=tmp){
                tmp = tmp.next;
                slowA = slowA.next;
            }
            return tmp;
        }
    }*/

    /*
    * the two iterations will both run for listA.length + listB.length
    * and will reach the intersection point at the same time after switching the pointer.
    * */
  /*  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }*/

    /*
    * hashset
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        HashSet<ListNode> hashSet = new HashSet<>();
        while(headA!=null){
            hashSet.add(headA);
            headA = headA.next;
        }
        while(!hashSet.contains(headB)&&headB!=null){
            headB = headB.next;
        }
        return headB;
    }

}
