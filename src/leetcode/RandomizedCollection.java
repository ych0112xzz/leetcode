package leetcode;

import java.util.*;

/**
 * Created by ych0112xzz on 2016/9/27.
 */
public class RandomizedCollection {
    LinkedList<Integer> result;
    ArrayList<Integer> nums;
    HashMap<Integer, TreeSet<Integer>> hashMap;
    Random random = new Random();
    public RandomizedCollection() {
        this.hashMap = new HashMap<>();
        this.result = new LinkedList<>();
        this.nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean rt = true;
        if(result.contains(val)){
            rt = false;
        }
        result.add(val);
        nums.add(val);
        if (rt) {
            hashMap.put(val, new TreeSet<Integer>());

        }
        hashMap.get(val).add(nums.size()-1);
        return rt;
    }

    public boolean remove(int val){
        if(!result.contains(val)){
            return false;
        }
        int index = hashMap.get(val).last();
        if(index<nums.size()-1){
            int tmp = nums.get(nums.size() - 1);
            nums.set(index, tmp);
            hashMap.get(tmp).remove(nums.size() - 1);
            hashMap.get(tmp).add(index);
        }

        result.remove(new Integer(val));
        nums.remove(nums.size() - 1);
        if(hashMap.get(val).isEmpty()){
            hashMap.remove(val);
        }else {
            hashMap.get(val).remove(index);
        }


        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

}
//
//    public static void main(String[] args) {
//        RandomizedCollection collection = new RandomizedCollection();
//        System.out.println(collection.insert(1));
//        System.out.println(collection.insert(1));
//        System.out.println(collection.insert(2));
//        System.out.println(collection.getRandom());
//        System.out.println(collection.remove(1));
//        System.out.println(collection.getRandom());
//    }
//
//    LinkedList<Integer> result;
//    ArrayList<Integer> list;
//    HashMap<Integer, ArrayList<Integer>> hashMap;
//    Random random = new Random();
//
//    /**
//     * Initialize your data structure here.
//     */
//    public RandomizedCollection() {
//        this.hashMap = new HashMap<>();
//        this.result = new LinkedList<>();
//        this.list = new ArrayList<>();
//    }
//
//    /**
//     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
//     */
//    public boolean insert(int val) {
//        boolean rt = true;
//        if (result.contains(val)) {
//            rt = false;
//        }
//        result.add(val);
//        list.add(val);
//        ArrayList<Integer> tmp = new ArrayList<>();
//        if (!rt) {
//            tmp = hashMap.get(val);
//
//        }
//        tmp.add(list.size() - 1);
//        hashMap.put(val, tmp);
//
//
//        return rt;
//    }
//
//
//    /**
//     * Removes a value from the collection. Returns true if the collection contained the specified element.
//     */
//    public boolean remove(int val) {
//        if (result.contains(val)) {
//            ArrayList<Integer> valList = hashMap.get(val);
//            Collections.sort(valList);
//            int index = valList.get(valList.size() - 1); //出现index大于list.size()的情况，从而导致bug
//
//            valList.remove(valList.size() - 1);
//            if (index < list.size() - 1) {
//                int tmp = list.get(list.size() - 1);
//                list.set(index, tmp);
//              //  list.set(list.size() - 1, val);
//                ArrayList<Integer> tmpList = new ArrayList<>();
//                if (result.contains(tmp)) {
//                    tmpList = hashMap.get(tmp);
//                    Collections.sort(tmpList);
//                    tmpList.remove(tmpList.size()-1);//
//                }
//                tmpList.add(index);
//                hashMap.put(tmp, tmpList);
//            }
//            result.remove(new Integer(val));
//            list.remove(list.size() - 1);
//            if (hashMap.get(val).isEmpty()) {
//                hashMap.remove(val);
//            } else {
//                hashMap.put(val, valList);
//            }
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * Get a random element from the collection.
//     */
//    public int getRandom() {
//        return list.get(random.nextInt(list.size()));
//    }
//}
//
///**
// * Your RandomizedCollection object will be instantiated and called as such:
// * RandomizedCollection obj = new RandomizedCollection();
// * boolean param_1 = obj.insert(val);
// * boolean param_2 = obj.remove(val);
// * int param_3 = obj.getRandom();
// */
