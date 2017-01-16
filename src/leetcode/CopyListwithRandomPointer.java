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
        RandomListNode result = copyRandomList(root);
        while(result!=null){
            System.out.println(result.label);
            if(result.random!=null) {
                System.out.println(result.random.label);
            }
            System.out.println();
            result = result.next;
        }


    }

//    public static RandomListNode copyRandomList(RandomListNode head) {
//        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();
//        List<RandomListNode> list = new ArrayList<>();
//        RandomListNode result = new RandomListNode(0);
//        RandomListNode rt = result;
//        while (head != null) {
//            RandomListNode tmp = new RandomListNode(head.label);
//            if (!(list.contains(tmp))) {
//                result.next = tmp;
//                list.add(tmp);
//            }
//            RandomListNode tmpRan;
//            if(head.random==null){
//               // tmpRan=null;
//                result.next.random = null;
//            }else{
//                tmpRan = new RandomListNode(head.random.label);
//                if (!(list.contains(tmpRan))) {
//                    result.next.random = new RandomListNode(head.random.label);
//                    list.add(tmpRan);
//                }
//            }
//            head = head.next;
//            result = result.next;
//        }
//        return rt.next;
//    }

    public static RandomListNode copyRandomList(RandomListNode head) {
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
    }

}
