package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangcheng E-mail:ych0112xzz@bupt.edu.cn
 */

public class ReverseString {
	public static void main(String args[]){
		String word ="A man";
		String revWord=revString(word);
		System.out.println(revWord);
	}

	public static String revString(String word){
		String revWord="";
		StringBuilder sb = new StringBuilder();//StringBuffer,join
		for(int i=word.length();i>0;i--){
			//revWord +=String.valueOf(word.charAt(i-1));
			//sb.append(word.charAt(i-1));
			sb.append(word.substring(i-1, i));
			System.out.println(sb);
		}
		return sb.toString();
		
//	        List<String> list = new ArrayList<String>();
//	        
//	        for(int i=word.length();i>0;i--){
//	        	list.add(word.substring(i-1, i));
//	        }
//	        String.join("",list);
//	        //long te = System.currentTimeMillis();
//	        //logger.info("StringUtils.join cost {} ms", te - ts);
	    
	}
}
