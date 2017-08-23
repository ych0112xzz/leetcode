package leetcode;

import java.util.*;

/**
 * Created by ych0112xzz on 2016/9/21.
 */
public class LRUCache extends LinkedHashMap<Integer,Integer>{
    int capacity;

    public LRUCache(int capacity) {
        super(capacity, (float) 0.75, true);
        this.capacity = capacity;

        //  hashMap = new LinkedHashMap<Integer,Integer>(capacity,(float)0.75,true);
    }
    public int get(int key){
        return super.get(key)== null ? -1 : super.get(key);
    }

    public void set(int key ,int value){
        super.put(key, value);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest){
        return super.size() > capacity;
    }



    /*int capacity;
    Deque<Integer> list = new LinkedList<>();
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    public LRUCache(int capacity){
        this.capacity = capacity;
    }



    private int get(int key) {
        if (hashMap.containsKey(key)) {
            list.remove(new Integer(key));
            list.addFirst(key);
            return hashMap.get(key);
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {

        if (hashMap.containsKey(key)) {
            list.remove(new Integer(key));
            list.addFirst(key);
            hashMap.put(key, value);
        } else if (hashMap.size() < capacity) {
            list.addFirst(key);
            hashMap.put(key, value);
        } else {
            int tmp = list.removeLast();
            hashMap.remove(tmp);
            list.addFirst(key);
            hashMap.put(key, value);
        }

    }*/

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.set(2,2);
        lru.set(1,1);
        lru.get(2);
        lru.set(3,3);
        int result = lru.get(1);
        System.out.println(result);
    }
}

