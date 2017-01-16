package leetcode;

import java.util.HashMap;

public class twoSumV2 {
	
	public static void main(String[] args){
		long startTime=System.nanoTime(); 
		//long startTime=System.currentTimeMillis(); 
		int[] nums={1,2,3,4,5,6,7,8,9};
		int target = 17;
		int[] result=calTwoSum(nums,target);
		System.out.println(result[0]+"\t"+result[1]);
		long endTime=System.nanoTime(); //��ȡ����ʱ��  
		System.out.println("运行时间： "+(endTime-startTime)+"ns");
	}

	public static int[] calTwoSum(int[] nums,int target){
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			hashMap.put(target-nums[i],i);
		}
		
		for(int i=0;i<nums.length;i++){
			Integer index=hashMap.get(nums[i]);
			if((index!=null)&&(index!=i)){
				return new int[]{i, index};
			}
		}
		return null;
		
	}
}
