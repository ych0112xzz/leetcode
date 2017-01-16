package leetcode;

/**
 * Created by ych0112xzz on 2017/1/9.
 */
public class AddandSearchWord {

    public static void main(String[] args) {
        AddandSearchWord trie = new AddandSearchWord();
        trie.addWord("someString");
        trie.addWord("some");
//        trie.addWord("abc");
//        trie.addWord("abc");
//        System.out.println(trie.search("ab"));
//        trie.addWord("ab");
//        System.out.println(trie.search("ab"));
//        System.out.println(trie.search("abc"));
//        System.out.println(trie.search("key"));
        System.out.println(trie.search("s..estr.n."));

    }

    class TrieNode{//实际上不需要val
        char val;
        TrieNode[] childs = new TrieNode[26];
        boolean isLeaf;

        public TrieNode(char val) {
            this.val = val;
        }
    }

    TrieNode root;
    public AddandSearchWord(){
        root = new TrieNode(' ');
    }

    public void addWord(String word) {
        TrieNode cur = root;
        char[] data = word.toLowerCase().toCharArray();
        for(int i=0;i<data.length;i++) {
            int index = data[i] - 'a';
            if (cur.childs[index] == null) {
                cur.childs[index] = new TrieNode(data[i]);
            }
            cur = cur.childs[index];
        }
        cur.isLeaf = true;
    }

    public boolean search(String word) {
        char[] data = word.toCharArray();
        return search(root, data,0);
    }

    /*
    * neat search
    * */

    private boolean search(TrieNode cur, char[] data, int start) {
        if(start==data.length){
            return cur.isLeaf;
        }
        if (data[start] != '.') {
            return cur.childs[data[start] - 'a'] != null && search(cur.childs[data[start] - 'a'], data, start + 1);
        }else{
            for(int i=0;i<cur.childs.length;i++) {
                if (cur.childs[i] != null) {
                    if (search(cur.childs[i], data, start + 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /*private boolean search(TrieNode cur, char[] data, int start) {
        if (start >= data.length||cur==null) {
            return false;
        }

        boolean result = false;
        if (data[start] == '.') {
            for (int i = 0; i < cur.childs.length; i++) {
                if(cur.childs[i]==null){
                    continue;
                }
                if (start + 1 >= data.length && cur.childs[i].isLeaf) {
                    return true;
                } else {
                    boolean tmp=search(cur.childs[i], data, start + 1);
                    result |= tmp;
                }
            }
            return result;
        } else {
            int index = data[start] - 'a';
            if (cur.childs[index] == null) {
                return false;
            }
            if (start + 1 >= data.length && cur.childs[index].isLeaf) {
                return true;
            }else{
                return search(cur.childs[index], data, start + 1);
            }
        }
    }*/
}
