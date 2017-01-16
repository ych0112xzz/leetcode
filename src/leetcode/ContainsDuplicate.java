package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ych0112xzz on 2016/10/21.
 */
public class ContainsDuplicate {

    /*public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(hashSet.contains(nums[i])){
                return true;
            }else{
                hashSet.add(nums[i]);
            }
        }
        return false;
    }*/



    /*
    * jdk1.8b
    * */
    /*public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(nums).filter(i -> !set.add(i)).findAny().isPresent();
    }*/
}
