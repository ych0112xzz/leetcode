package util;

import java.util.HashMap;

/**
 * Created by ych0112xzz on 2017/1/9.
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("I");
        trie.insert("Love");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("xiaoliang");
        trie.insert("xiaoliang");
        trie.insert("man");
        trie.insert("handsome");
        trie.insert("love");
        trie.insert("chinaha");
        trie.insert("her");
        trie.insert("know");
        HashMap<String, Integer> map = trie.getAllwords();

        for (String key : map.keySet()) {
            System.out.println(key + " 出现: " + map.get(key) + "次");
        }


        map = trie.getWordsForPrefix("chin");

        System.out.println("\n\n包含chin（包括本身）前缀的单词及出现次数：");
        for (String key : map.keySet()) {
            System.out.println(key + " 出现: " + map.get(key) + "次");
        }

        if (trie.search("xiaoming") == false) {
            System.out.println("\n\n字典树中不存在：xiaoming ");
        }
    }

    private class TrieNode {
        TrieNode[] childrens = new TrieNode[26];
        int frequency;//该字串的重复数目,频数
        int prefix_num;//以该子串为前缀的单词数
        char val;//可以没有，数组下标可以知道val值
        boolean isLeaf;

        public TrieNode(char val) {
            this.val = val;
            isLeaf = false;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode cur = root;
        char[] data = word.toLowerCase().toCharArray();
        for (int i = 0; i < data.length; i++) {
            int index = data[i] - 'a';
            if (cur.childrens[index] == null) {
                cur.childrens[index] = new TrieNode(data[i]);
            }
            cur = cur.childrens[index];
            cur.prefix_num++;
        }
        cur.isLeaf = true;
        cur.frequency++;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        char[] data = word.toLowerCase().toCharArray();
        for (int i = 0; i < data.length; i++) {
            int index = data[i] - 'a';
            if (cur.childrens[index] == null) {
                return false;
            }
            cur = cur.childrens[index];
        }
        return cur.isLeaf;
    }


    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        char[] data = prefix.toLowerCase().toCharArray();
        for (int i = 0; i < data.length; i++) {
            int index = data[i] - 'a';
            if (cur.childrens[index] == null) {
                return false;
            }
            cur = cur.childrens[index];
        }
        return true;
    }

    /*
    * 得到所有单词及出现次数
    * */
    public HashMap<String, Integer> getAllwords() {
        return helper(root, "");
    }

    private HashMap<String, Integer> helper(TrieNode cur, String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (cur != null) {
            if (cur.isLeaf == true) {
                hashMap.put(s, cur.frequency);
            }
        }
        for (int i = 0; i < cur.childrens.length; i++) {
            if (cur.childrens[i] != null) {
                String tmp = s + (char) (i + 'a');
                hashMap.putAll(helper(cur.childrens[i], tmp));
            }
        }
        return hashMap;
    }


    /*
    * 得到以某字串为前缀的字串集，包括字串本身！
    * */
    public HashMap<String, Integer> getWordsForPrefix(String prefix) {
        return getWordsForPrefix(root, prefix);
    }

    private HashMap<String, Integer> getWordsForPrefix(TrieNode cur, String prefix) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        char[] data = prefix.toLowerCase().toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (cur.childrens[data[i] - 'a'] == null) {
                return hashMap;
            }
            cur = cur.childrens[data[i] - 'a'];
        }
        return helper(cur, prefix);
    }

}
