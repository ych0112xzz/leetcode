package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by ych0112xzz on 2016/9/29.
 */
public class FindtheDuplicateNumber {
    /*
    * 哈希表，空间为O(n)
    *
    * */
   /* public int findDuplicate(int[] nums) {
        HashSet<Integer> hashMap = new HashSet<>();
        //int result=0;
        for(int i=0;i<nums.length;i++){
            if(hashMap.contains(nums[i])){
                return nums[i];
            }else{
                hashMap.add(nums[i]);
            }
        }

        return 0;
    }*/

    /*
    * 排序
    * */
    /*public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        for(int i=1;i<nums.length;i++){
           if(nums[i]==pre){
               return pre;
           }else{
               pre = nums[i];
           }
        }
        return 0;
    }*/

    /*
    * 二分法
    * */
    /*public int findDuplicate(int[] nums) {
        int min = 0, max = nums.length - 1;
        while(min <= max){
            // 找到中间那个数
            int mid = min + (max - min) / 2;
            int cnt = 0;
            // 计算总数组中有多少个数小于等于中间数
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    cnt++;
                }
            }
            // 如果小于等于中间数的数量大于中间数，说明前半部分必有重复
            if(cnt > mid){
                max = mid - 1;
                // 否则后半部分必有重复
            } else {
                min = mid + 1;
            }
        }
        return min;
    }*/

    /*
    * 映射找环法
    * */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        fast = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

