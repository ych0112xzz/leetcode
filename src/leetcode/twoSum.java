package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class twoSum {
	
	public static void main(String[] args){
		long startTime=System.nanoTime(); 
		//long startTime=System.currentTimeMillis(); 
		int[] nums={1,2,3,4,5,6,7,8,9};
		int target = 10;
		ArrayList<int[]> results=new ArrayList<>(); 
	    results=findTwoSum(nums,target);
		if(results==null){
			System.out.println("NO DATA!!!");
		}else{
//			for(int i=0; i<results.size();i++){
//				int[] result = new int[2];
//				result=results.get(i);
//				System.out.println(result[0]+"\t"+result[1]);
//			}
			
			for(int[] result:results){
				System.out.println(result[0]+"\t"+result[1]);
			}
		
		}
		
		long endTime=System.nanoTime(); //��ȡ����ʱ��  
		System.out.println("运行时间： "+(endTime-startTime)+"ns");
	}

	public static ArrayList<int[]> findTwoSum(int[] nums, int target) {
		Arrays.sort(nums);
		int begin = 0;
		int end = nums.length - 1;
		int beginNum = nums[begin];
		int endNum = nums[end];
		int[] result = new int[2];
		ArrayList<int[]> results=new ArrayList<>(); 
		boolean hasResult = false;
		while (begin < end) {
			if (beginNum + endNum > target) {
				end = end - 1;
				endNum = nums[end];
			} else if (beginNum + endNum < target) {
				begin = begin + 1;
				beginNum = nums[begin];
			} else {
				result[0] = begin;
				result[1] = end;
				if(nums[end-1]==endNum){
					end=end-1;
					endNum = nums[end];
				}else{
					begin=begin+1;
					beginNum = nums[begin];
				}
				result=getOriIndex(result,nums);
				results.add(result);
			    result = new int[2];
				hasResult = true;
				
			}
		}
		if (hasResult) {
			return results;
		} else {
			return null;
		}
	}
	
	public static int[] getOriIndex(int[] result,int[] nums){
		for(int i = 0;i<nums.length;i++){
			if(nums[i]==result[0]){
				result[0]=nums[i];
			}else if(nums[i]==result[1]){
				result[1]=nums[i];
			}
		}
		return result;
		
	}
	
	
}
