package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ych0112xzz on 2017/4/25.
 */
public class LRUCache {
    final Map<Integer, ListNode> cacheMap = new HashMap<>();
    final DoublyLinkedList cacheList = new DoublyLinkedList();
    final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        ListNode node = cacheMap.get(key);
        cacheList.moveToFront(node);
        return node.val;
    }

    public void put(int key,int value){
        ListNode node;
        if (cacheMap.containsKey(key)) {
            node = cacheMap.get(key);
            node.val=value;
            cacheList.moveToFront(node);
            return;
        }
        if (cacheMap.size() >= capacity) {
            ListNode tmp = cacheList.removeLast();
            cacheMap.remove(tmp.key);
        }
        node = new ListNode(key, value);
        cacheMap.put(key, node);
        cacheList.addFirst(node);
    }


    class  ListNode{
        int key;
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int key,int value){
            this.key=key;
            this.val = value;
        }
    }

    class DoublyLinkedList{
        ListNode head=null;
        ListNode tail = null;

        public void addFirst(ListNode node) {
            if(head==null){
                head=node;
                tail=node;
                return;
            }else{
                head.prev=node;
                node.next=head;
                node.prev=null;
                head=node;
            }
        }

        public ListNode removeLast(){
            ListNode node =tail;
            if(tail.prev!=null){
                tail.prev.next=null;
                tail=tail.prev;
            }else{
                tail=null;
                head = null;
            }
            return node;
        }

        public void moveToFront(ListNode node) {
            if (node.prev == null) {
                return;
            }
            node.prev.next = node.next;
            if (node.next == null) {
                tail = node.prev;
            }else{
                node.next.prev = node.prev;
            }
            head.prev=node;
            node.next = head;
            node.prev = null;
            head = node;
        }
    }
}
