package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangcheng E-mail:ych0112xzz@bupt.edu.cn
 */

public class ThreeSum {

	public static void main(String[] args) {
		int nums[]={-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result=new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++){
			if(i==0||(i>0&&nums[i]!=nums[i-1])){
				int lo=i+1;
				int hi=nums.length-1;
				int sum=0-nums[i];
				while(lo<hi){
					if(nums[lo]+nums[hi]==sum){
						List<Integer> list=new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[lo]);
						list.add(nums[hi]);
						result.add(list);
						while(hi>lo&&nums[hi]==nums[hi-1]){
							hi--;
						}
						while(hi>lo&&nums[lo]==nums[lo+1]){
							lo++;
						}
						lo++;
						hi--;
					}else if(nums[lo]+nums[hi]>sum){
						hi--;
					}else{
						lo++;
					}
				}
			}
		}
		return result;
	}
}
