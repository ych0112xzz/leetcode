package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ych0112xzz on 2016/12/6.
 */
public class SurroundedRegions {


    /*
    * BFS
    * */
   /* Queue<Queue<Integer>> result = new LinkedList<>();

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }
        while (!result.isEmpty()) {
            Queue<Integer> tmp = result.poll();
            while (!tmp.isEmpty()) {
                int num = tmp.poll();
                board[num / n][num % n] = 'O';
            }

        }

    }


    private void bfs(char[][] board, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tmpQueue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        queue.offer(i * n + j);
        boolean isEdge = false;
        tmpQueue.offer(i * n + j);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            i = num / n;
            j = num % n;
            if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                isEdge = true;
            } else {
                board[i][j] = 'X';
            }
            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                if (i == 1) {
                    isEdge = true;
                }
                queue.offer((i - 1) * n + j);
                tmpQueue.offer((i - 1) * n + j);
                board[i - 1][j] = 'X';
            }
            if (i + 1 <= m - 1 && board[i + 1][j] == 'O') {
                if (i == m - 2) {
                    isEdge = true;
                }
                queue.offer((i + 1) * n + j);
                tmpQueue.offer((i + 1) * n + j);
                board[i + 1][j] = 'X';
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                if (j == 1) {
                    isEdge = true;
                }
                queue.offer(i * n + j - 1);
                tmpQueue.offer(i * n + j - 1);
                board[i][j - 1] = 'X';
            }
            if (j + 1 <= n - 1 && board[i][j + 1] == 'O') {
                if (j == n - 2) {
                    isEdge = true;
                }
                queue.offer(i * n + j + 1);
                tmpQueue.offer(i * n + j + 1);
                board[i][j + 1] = 'X';
            }
        }
        if (isEdge) {
            result.offer(tmpQueue);
        }

    }*/

    /*
    * BFS
    * */
 /*   public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        int n = board[0].length;
        *//*
        * 将所有边缘的一起入队
        * *//*
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.offer(j);
                board[0][j] = '+';
            }
            if (board[m - 1][j] == 'O') {
                queue.offer((m-1)*n+j);
                board[m - 1][j] = '+';
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                queue.offer(i * n);
                board[i][0] = '+';
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(i * n + n - 1);
                board[i][n - 1] = '+';
            }
        }
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int i = num / n;
            int j = num % n;
            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                queue.offer((i - 1) * n + j);
                board[i - 1][j] = '+';
            }
            if (i + 1 <= m - 1 && board[i + 1][j] == 'O') {
                queue.offer((i + 1) * n + j);
                board[i + 1][j] = '+';
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                queue.offer(i * n + j - 1);
                board[i][j - 1] = '+';
            }
            if (j + 1 <= n - 1 && board[i][j + 1] == 'O') {
                queue.offer(i * n + j + 1);
                board[i][j + 1] = '+';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j=0;j<n;j++) {
                if (board[i][j]== 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }*/

    /*
    * DFS
    * */
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        for(int i=0;i<m;i++) {
            if (board[i][0]== 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
               dfs(board,m-1,j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j=0;j<n;j++) {
                if (board[i][j]== 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    /*
    * 下面的overflow，原因是可能第一个数处理时边缘全是0，导致栈溢出
    * */
   /* private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        board[i][j] = '+';
        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);
        }
        if (i + 1 < m && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);
        }
        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }
        if (j + 1 < n && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }
    }*/
    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        board[i][j] = '+';
        if (i - 1 > 0 && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);
        }
        if (i + 1 < m-1 && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);
        }
        if (j - 1 > 0 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }
        if (j + 1 < n-1 && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }
    }
}
