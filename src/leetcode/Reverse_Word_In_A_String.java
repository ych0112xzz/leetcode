package leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Reverse_Word_In_A_String {
    public static void main(String[] args) {
        String word = " the";
        String result = revWord(word);
        System.out.println(result);

    }

//	public static String revWord(String s) {
//		String[] word = s.trim().split(" +");
//		// System.out.println(word.length);
//		String result = "";
//		for (int i = word.length - 1; i >= 0; i--) {
//			//System.out.println(word[i].length());
//
//			if (i > 0) {
//				result = result + word[i] + " ";
//			} else {
//				result = result + word[i];
//			}
//
//		}
//
//		return result;
//
//	}
//	public static String revWord(String s) {
//		String[] word = s.trim().split(" +");
//		ArrayUtils.reverse(word);
//		return StringUtils.join(word," " );
//		
//	}

    public static String revWord(String s) {
        List<String> word = Arrays.asList(s.trim().split(" +"));
        Collections.reverse(word);
        return StringUtils.join(word, "");
    }
}
