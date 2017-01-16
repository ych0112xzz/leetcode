package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by ych0112xzz on 2016/9/23.
 */

public class RandomizedSet {

    HashMap<Integer,Integer> hashMap;

    Random random ;
    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.hashMap = new HashMap<>();
        this.random = new Random();
    }

    public static void main(String[] args){
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if(hashMap.containsKey(val)){

            return false;
        }else{
            hashMap.put(val,1);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if(hashMap.containsKey(val)){
            hashMap.remove(val);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if(hashMap.isEmpty()){
            return 0;
        }
       // Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>(hashMap.keySet());
        int index = random.nextInt(hashMap.size());
        int result = list.get(index);
        return result;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
