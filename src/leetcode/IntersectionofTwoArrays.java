package leetcode;

import java.util.*;

/**
 * Created by ych0112xzz on 2016/11/16.
 */
public class IntersectionofTwoArrays {
    /*
    * two pointers
    * */
    /*public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0){
            return nums1;
        }
        if(nums2.length==0){
            return nums2;
        }
        List<Integer> result = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int tmp = (nums1[0] < nums2[0] ? nums1[0] : nums2[0]) - 1;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (tmp != nums1[i]) {
                    result.add(nums1[i]);
                    tmp = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
       *//* Integer[] a = new Integer[result.size()];
        result.toArray(a);*//*
        int[] rt = new int[result.size()];
        for (int k=0;k<result.size();k++) {
            rt[k] = result.get(k);
        }
        return rt;

    }*/


    /*
    * hashset
    * */
   /* public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0){
            return nums1;
        }
        if(nums2.length==0){
            return nums2;
        }
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> result = new HashSet<>();
      //  List<Integer> result = new ArrayList<>();
        for(int val:nums1){
            hashSet.add(val);
        }
        for (int val : nums2) {
            if(hashSet.contains(val)){
                result.add(val);
            }
        }
        int i = 0;
        int[] rt = new int[result.size()];
        for(Iterator it = result.iterator();it.hasNext();i++) {
            rt[i] = (int)it.next();
        }
        return rt;
    }*/

    /*
    * jdk1.8
    * */
    /*public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(e -> set.contains(e)).toArray();
    }*/




}
