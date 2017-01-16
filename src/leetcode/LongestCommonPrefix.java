package leetcode;

/**
 * @author yangcheng E-mail:ych0112xzz@bupt.edu.cn
 */

public class LongestCommonPrefix {
	
	public static void main(String[] args){
		//String[] strs={"abcdf","abcdf","abfcdz","abcd0"};
		String[] strs={"c","c"};
		String preFix=longestPrefix(strs);
		System.out.println(preFix);
	}

	public static String longestPrefix(String[] strs) {
		String prefix = "";
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int p = 0;
		here:
		while (true) {
			if (p > strs[0].length()) {
				break;
			}
			String subFix = strs[0].substring(0, p);//不用substring可以charatҲ
			//System.out.println(subFix);
			for (String str : strs) {
				if ((str.length()<p)||(!str.substring(0, p).equals(subFix)) ) {
					break here;
				}
			}
			p++;
			
		}
		if(p==0){
			return "";
		}
		prefix = strs[0].substring(0, p-1);
		return prefix;
	}
}
