package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ych0112xzz on 2016/10/21.
 */
public class ContainsDuplicateII {


    /*
    * 用hashMap
    * */
    /*public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                int index = hashMap.get(nums[i]);
                if(i-index<=k){
                    return true;
                }else{
                    hashMap.put(nums[i], i);
                }
            }else{
                hashMap.put(nums[i], i);
            }
        }
        return false;
    }*/

    /*
    * 用HashSet
    * */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }


}
