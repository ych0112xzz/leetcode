package leetcode;


import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by ych0112xzz on 2016/9/21.
 */
public class LRUCache1 extends LinkedHashMap<Integer,Integer> {

    int capacity;
   // LinkedHashMap<Integer, Integer> hashMap;
    //Deque<HashMap<Integer,Integer>> list = new LinkedList<>();
    //HashMap<Integer, Integer> hashMap = new HashMap<>();

    public LRUCache1(int capacity) {
        super(capacity, (float) 0.75, true);//true表示访问顺序，false表示插入顺序
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

    public static void main(String[] args){
        LRUCache1 lru = new LRUCache1(2);
        lru.set(2,2);
        lru.set(1,1);
        lru.get(2);
        lru.set(3,3);
        int result = lru.get(1);
        System.out.println(result);
    }

}
