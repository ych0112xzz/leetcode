package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ych0112xzz on 2016/9/20.
 */
public class WordBreak {

    public static void main(String[] args){
        String s ="goalspecial";
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("go");
        //wordDict.add("goal");
        wordDict.add("goals");
        wordDict.add("special");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {
        int index =0;
        if(wordDict.contains(s)){
            return true;
        }
        System.out.println(wordDict.toString());
        if(s.length()>wordDict.toString().length()){
            return false;
        }
        int size = s.length();
        boolean tmp = false;
        for(;index<size;index++){
            String a = s.substring(0, index);
            String b = s.substring(index, size);
//            System.out.println(a);
//            System.out.println(b);
            if(wordDict.contains(a)){
                tmp= wordBreak(b,wordDict);
                if(tmp){
                    return true;
                }
            }
        }
        return false;
    }
}
