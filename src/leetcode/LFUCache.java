package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ych0112xzz on 2017/4/14.
 */
public class LFUCache {
    int capacity;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    Deque<Integer> deque=new LinkedList<>();
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        return 0;
    }

    public void put(int key, int value) {
        return;
    }

}
