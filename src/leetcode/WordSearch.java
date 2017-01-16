package leetcode;

import java.util.LinkedList;

/**
 * Created by ych0112xzz on 2016/9/9.
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] data = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        System.out.println(new WordSearch().exist(data, word));
    }


/*
*省略四个if
* */
    /*public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }*/

   /* private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }*/

    /*
    * 四个if
    * */

   /*int index = 1;
   public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }

        //StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char tmp = board[i][j];
                    //word=word.substring(1);
                    // System.out.println(word.length());

                    board[i][j] = '0';
                    boolean found = exist(board, word, i, j);
                    if (found) {
                        return found;
                    } else {
                        board[i][j] = tmp;
                        //word = tmp +word;
                    }

                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word, int i, int j) {

        if (word.length() == index) {

            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[i].length) return false;

        if (i - 1 >= 0 && board[i - 1][j] == word.charAt(index)) {
            char tmp = board[i - 1][j];
            board[i - 1][j] = '0';
            index++;
            boolean found = exist(board, word, i - 1, j);
            if (found) {
                return true;
            } else {
                board[i - 1][j] = tmp;
                index--;
                // word = tmp + word;
            }
        }
        if (i + 1 < board.length && board[i + 1][j] == word.charAt(index)) {
            char tmp = board[i + 1][j];
            //word=word.substring(1);
            board[i + 1][j] = '0';
            index++;
            boolean found = exist(board, word, i + 1, j);
            if (found) {
                return true;
            } else {
                board[i + 1][j] = tmp;
                index--;
                // word = tmp + word;
            }
        }
        if (j - 1 >= 0 && board[i][j - 1] == word.charAt(index)) {
            char tmp = board[i][j - 1];
            //word=word.substring(1);
            board[i][j - 1] = '0';
            index++;
            boolean found = exist(board, word, i, j - 1);
            if (found) {
                return true;
            } else {
                board[i][j - 1] = tmp;
                index--;
                // word = tmp + word;
            }
        }
        if (j + 1 < board[i].length && board[i][j + 1] == word.charAt(index)) {
            char tmp = board[i][j + 1];
            // word=word.substring(1);
            board[i][j + 1] = '0';
            index++;
            boolean found = exist(board, word, i, j + 1);
            if (found) {
                return true;
            } else {
                board[i][j + 1] = tmp;
                index--;
                // word = tmp + word;
            }
        }
        return false;
    }*/


    /*
    * TLE
    * */
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {

        char[] data = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        if (word.length() == 0 || m * n < word.length()) {
            return false;
        }
        LinkedList<int[]> deque = new LinkedList<>();
        LinkedList<LinkedList<Integer>> path=new LinkedList<>();
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == data[index]) {
                    deque.offer(new int[]{i, j});
                    LinkedList<Integer> tmp = new LinkedList<>();
                    tmp.add(i * n + j);
                    path.offer(tmp);
                }
            }
        }
        index++;
        while (true) {
            int size = deque.size();
            if (size == 0) {
                return false;
            }
            if (index == word.length()) {
                return true;
            }
            while (size-- > 0) {
                int[] tmp = deque.poll();
                LinkedList<Integer> list = path.poll();
                for (int d[] : dir) {
                    LinkedList<Integer> pathTmp = new LinkedList<>(list);
                    int x1 = tmp[0] + d[0];
                    int y1 = tmp[1] + d[1];
                    if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || board[x1][y1] != data[index]||pathTmp.contains(x1*n+y1)) {
                        continue;
                    }
                    deque.offer(new int[]{x1, y1});
                    pathTmp.add(x1 * n + y1);
                    path.offer(pathTmp);
                }
            }
            index++;
        }
    }

}
