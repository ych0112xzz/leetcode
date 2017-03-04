package leetcode;

/**
 * @author yangcheng E-mail:ych0112xzz@bupt.edu.cn
 */

public class LengthOfLastWord {
	
	public static void main(String[] args){
		String s="      ";
		int len = lengthOfLastWord(s);
		System.out.println(len);
	}
	
	/*public static int lengthOfLastWord(String s){
		if(!s.matches("[a-zA-Z\\s]+")){
			return 0;
		}
		if(s.matches("\\s+")){
			return 0;
		}
		String[] ann = s.split(" ");
		String word = ann[ann.length-1];
		System.out.println(word);
		return word.length();
	}*/

	public static int lengthOfLastWord(String s) {
		s=s.trim();
		int last=s.lastIndexOf(' ')+1;
		return s.length()-last;
	}
}
