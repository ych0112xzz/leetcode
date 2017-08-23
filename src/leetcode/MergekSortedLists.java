package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ych0112xzz on 2017/5/3.
 */
public class MergekSortedLists {

    /*
    递归
     */
   /* public ListNode mergeKLists(ListNode[] lists) {
        int start=0;
        int end = lists.length-1;
        ListNode res=mergeKLists(lists, start, end);
        return res;
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        ListNode res=null;
        if (start > end) {
            return null;
        }
        if(start==end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left=mergeKLists(lists, start, mid);
        ListNode right=mergeKLists(lists, mid + 1, end);
        res = mergeTwoLists(left, right);
        return res;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h=new ListNode(0);
        ListNode cur=h;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1!=null){
            cur.next=l1;
        }else{
            cur.next=l2;
        }
        return h.next;
    }*/


    /*
    用优先队列实现
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        if (lists.length == 0) {
            return res.next;
        }
        ListNode cur = res;
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode node : lists) {
            //注意null判断
            if (node != null) {
                minHeap.offer(node);
            }

        }

        while (!minHeap.isEmpty()) {
            ListNode tmp = minHeap.poll();
            cur.next=tmp;
            cur = cur.next;
            if (tmp.next != null) {
                minHeap.offer(tmp.next);
            }
        }
        return res.next;
    }
}
