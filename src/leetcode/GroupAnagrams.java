package leetcode;

import java.util.*;

/**
 * Created by ych0112xzz on 2016/9/8.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
           // boolean isKey = false;
//            byte[] b = strs[i].getBytes();
            char[] data = strs[i].toCharArray();
            Arrays.sort(data);
            String tmp = new String(data);
            //System.out.println(tmp);


            //String tmp = strs[i].substring(j, strs[i].length()) + strs[i].substring(0, j);
            if (hashmap.containsKey(tmp)) {
                List<String> list = hashmap.get(tmp);
                list.add(strs[i]);
                hashmap.put(tmp, list);
               // isKey = true;

            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashmap.put(tmp, list);
            }

        }
       // return new ArrayList<>(hashmap.values());
        //System.out.println(hashmap.keySet());
        // System.out.println(hashmap.entrySet());
        List<List<String>> listValue = new ArrayList<>();
        Iterator it = hashmap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            listValue.add(hashmap.get(key));
        }
//        return listValue;
        return new ArrayList<>(hashmap.values());
    }
}
