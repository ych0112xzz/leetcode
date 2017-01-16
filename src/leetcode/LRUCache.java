package leetcode;

import java.util.*;

/**
 * Created by ych0112xzz on 2016/9/21.
 */
public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;
    Deque<Integer> list = new LinkedList<>();
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                if (cache.size() > capacity) {
                    return true;
                }
                return false;
            }
        };
        //
    }
    public int get(int key) {
        if(cache.containsKey(key)) {
            int value = cache.get(key);
            moveToFront(key);
            return value;
        }
        return -1;
    }

    void moveToFront(int key) {

        int val = cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }

    public void set(int key, int value) {
        cache.put(key, value);
        moveToFront(key);
    }

//    private int get(int key) {
//        if (hashMap.containsKey(key)) {
//            list.remove(new Integer(key));
//            list.addFirst(key);
//            return hashMap.get(key);
//        } else {
//            return -1;
//        }
//    }
//
//    public void set(int key, int value) {
//
//        if (hashMap.containsKey(key)) {
//            list.remove(new Integer(key));
//            list.addFirst(key);
//            hashMap.put(key, value);
//        } else if (hashMap.size() < capacity) {
//            list.addFirst(key);
//            hashMap.put(key, value);
//        } else {
//            int tmp = list.removeLast();
//            hashMap.remove(tmp);
//            list.addFirst(key);
//            hashMap.put(key, value);
//        }
//
//    }

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
