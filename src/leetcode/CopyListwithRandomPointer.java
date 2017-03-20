package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/9/21.
 */
public class CopyListwithRandomPointer {

    public static void main(String[] args) {
        RandomListNode root = new RandomListNode(1);
        root.next = new RandomListNode(2);

        RandomListNode l1 = root.next;
        root.next.next = new RandomListNode(3);
        RandomListNode l2 = root.next.next;
        root.next.next.next = new RandomListNode(4);
        RandomListNode l3 = root.next.next.next;
        root.next.next.next.next = new RandomListNode(5);
        RandomListNode l4 = root.next.next.next.next;
        // root.next.next.next.next.next = new RandomListNode(6);

        root.random = l4;
        l1.random = null;
        l2.random = root;
        l3.random = l3;
        l4.random = root;
        RandomListNode result = new CopyListwithRandomPointer().copyRandomList(root);
        while(result!=null){
            System.out.println(result.label);
            if(result.random!=null) {
                System.out.println(result.random.label);
            }
            System.out.println();
            result = result.next;
        }


    }

    /*
    此方法ac，但不满足要求，为每个节点的random都new了一个节点
     */
    /*public static RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode result = new RandomListNode(0);
        RandomListNode rt = result;
        while (head != null) {
            RandomListNode tmp = new RandomListNode(head.label);

                result.next = tmp;


            RandomListNode tmpRan;
            if(head.random==null){

                result.next.random = null;
            }else{
                tmpRan = new RandomListNode(head.random.label);
                    result.next.random = tmpRan;


            }
            head = head.next;
            result = result.next;
        }
        return rt.next;
    }*/

   /* public static RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        RandomListNode init = head;
        RandomListNode cur = new RandomListNode(0);
        RandomListNode result = cur;
        while(head!=null){
            cur.next = new RandomListNode(head.label);
            hashMap.put(head, cur.next);
            head = head.next;
            cur = cur.next;
        }
        head = init;
        cur = result;
        while(head!=null){
            RandomListNode tmp = head.random;
            cur.next.random = hashMap.get(tmp);
            head=head.next;
            cur = cur.next;
        }
        return result.next;
    }*/


    /*
    O(n)且省空间
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode pHead=head;
        if(pHead==null){
            return null;
        }
        cloneNode(pHead);
        connectNode(pHead);
        return reConnectNode(pHead);
    }

    public void cloneNode(RandomListNode head){
        while(head!=null){
            RandomListNode cur=new RandomListNode(head.label);
            cur.next=head.next;
            head.next=cur;
            head=cur.next;
        }
    }

    public void connectNode(RandomListNode head){
        while(head!=null){
            if(head.random!=null){
                head.next.random =head.random.next;
            }
            head=head.next.next;
        }
    }

    /*
    类似求奇数偶数节点
     */

    public RandomListNode reConnectNode(RandomListNode head){
        //为了防止异常，将head放到cur后
        RandomListNode result=head.next;
        RandomListNode cur=result;
        head.next=cur.next;
        head=head.next;
        while(head!=null){
            cur.next=head.next;
            cur=cur.next;
            head.next=cur.next;
            head=head.next;
        }

        return result;
    }

}
