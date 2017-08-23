package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ych0112xzz on 2017/5/3.
 */
public class SubstringwithConcatenationofAllWords {

    public static void main(String[] args) {
        String s="barfoofoobarthefoobarman";
        String words[]={"foo", "bar","the"};
        List<Integer> res = new SubstringwithConcatenationofAllWords().findSubstring(s, words);
        System.out.println(res);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            if (dict.containsKey(word)) {
                dict.put(word, dict.get(word) + 1);
            }else{
                dict.put(word, 1);
            }
        }

        for(int i=0;i<wordLen;i++) {
            int count=0;
            int index=i;
            HashMap<String, Integer> curDict = new HashMap<>();
            for(int j=i;j<=s.length()-wordLen;j +=wordLen) {
                String word = s.substring(j, j + wordLen);
                if (!dict.containsKey(word)) {
                    count = 0;
                    index =j+ wordLen;
                    curDict.clear();

                }else{
                    if (!curDict.containsKey(word)) {
                        curDict.put(word, 1);
                    }else{
                        curDict.put(word,curDict.get(word) + 1);
                    }
                    if (curDict.get(word) <= dict.get(word)) {
                        count++;
                    }else{
                        count++;
                        while (curDict.get(word) > dict.get(word)) {
                            String tmp = s.substring(index, index + wordLen);
                            curDict.put(tmp, curDict.get(tmp) - 1);
                            if (curDict.get(tmp) == 0) {
                                curDict.remove(tmp);
                            }
                            index += wordLen;
                            count--;
                        }
                    }
                    if (count == words.length) {
                        res.add(index);
                        String tmp = s.substring(index, index + wordLen);
                        curDict.put(tmp, curDict.get(tmp) - 1);
                        if (curDict.get(tmp) == 0) {
                            curDict.remove(tmp);
                        }
                        index += wordLen;
                        count--;
                    }
                }
            }
        }
        return res;
    }
}
