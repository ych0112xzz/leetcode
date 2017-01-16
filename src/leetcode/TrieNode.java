package leetcode;

/**
 * Created by ych0112xzz on 2016/10/18.
 */
public class TrieNode {
    char val;
    TrieNode[] childNode;
    boolean isLeaf = false;

    public TrieNode() {
        this.childNode = new TrieNode[26];
    }

    // Initialize your data structure here.
    public TrieNode(char val) {
        this();
        this.val = val;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("somestring");
        trie.insert("some");
        trie.insert("abc");
        trie.insert("abc");
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("key"));
        System.out.println(trie.search("somestring"));
        System.out.println(trie.startsWith("somestrin"));
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('A');
        // System.out.println(root.childNode[18]);
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insert(root, word);

    }

    public void insert(TrieNode root, String word) {
        if (word.length() == 0) {
            return;
        }
        int i = word.charAt(0) - 'a';
        if (root.childNode[i] == null) {
            root.childNode[i] = new TrieNode(word.charAt(0));
           // root.childNode[i].val = word.charAt(0);
            // System.out.println(root.childNode[i].val);
        }
        String nextWord = word.substring(1);
        if (nextWord.length() == 0) {
            root.childNode[i].isLeaf = true;
        }

        // System.out.println(nextWord);
        insert(root.childNode[i], nextWord);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(root, word.toCharArray(),0);
    }

    /*
    * 递归+数组
    * */
    public boolean search(TrieNode cur, char[] data, int start) {
        if (start == data.length) {
            return cur.isLeaf;
        }
        return cur.childNode[data[start] - 'a'] != null && search(cur.childNode[data[start] - 'a'], data, start + 1);

    }

    /*
    * 递归+substring
    * */
    /*public boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return false;
        }
        int i = word.charAt(0) - 'a';
        if (root.childNode[i] == null) {
            return false;
        }
        String nextWord = word.substring(1);
        //System.out.println(root.childNode[i].childNode);
        if (nextWord.length() == 0 && root.childNode[i].isLeaf) {
            return true;
        } else if (nextWord.length() == 0) {
            return false;
        } else {
            return search(root.childNode[i], nextWord);
        }

    }*/

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {

        return startsWith(root, prefix.toCharArray(),0);
    }

    private boolean startsWith(TrieNode cur, char[] data, int start) {
        if (start == data.length) {
            return true;
        }
        return cur.childNode[data[start] - 'a'] != null && startsWith(cur.childNode[data[start] - 'a'], data, start + 1);

    }



    /*public boolean startsWith(TrieNode root, String prefix) {
        if (prefix.length() == 0) {
            return false;
        }
        int i = prefix.charAt(0) - 'a';
        if (root.childNode[i] == null) {
            return false;
        }
        String nextWord = prefix.substring(1);
        if (nextWord.length() == 0) {
            return true;
        } else {
            return startsWith(root.childNode[i], nextWord);
        }
    }*/
}
