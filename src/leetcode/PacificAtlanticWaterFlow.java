package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ych0112xzz on 2016/12/6.
 */
public class PacificAtlanticWaterFlow {
    /*
    * BFS
    * */
    /*int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[]{i, 0});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
            atlanticQueue.offer(new int[]{i, n - 1});
        }
        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
            pacificQueue.offer(new int[]{0, j});
            atlanticQueue.offer(new int[]{m - 1, j});
        }
        bfs(matrix, pacificQueue, pacific);
        bfs(matrix, atlanticQueue, atlantic);
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private void bfs(int[][] matrix, Queue<int[]> pacificQueue, boolean[][] pacific) {
        int m = matrix.length;
        int n = matrix[0].length;
        while (!pacificQueue.isEmpty()) {
            int cur[] = pacificQueue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || pacific[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                pacific[x][y] = true;
                pacificQueue.offer(new int[]{x, y});
            }
        }
    }*/


    /*
    * dfs
    * */
   /* int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific,Integer.MIN_VALUE, i,0);
            dfs(matrix,atlantic,Integer.MIN_VALUE,i,n-1);

        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, pacific,Integer.MIN_VALUE, 0,j);
            dfs(matrix,atlantic,Integer.MIN_VALUE,m-1,j);
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result;
    }

    private void dfs(int[][] matrix, boolean[][] pacific, int minValue, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || pacific[x][y] || matrix[x][y] < minValue) {
            return;
        }
        pacific[x][y] = true;
        for(int d[]:dir){
            dfs(matrix, pacific, matrix[x][y], x + d[0], y + d[1]);
        }
    }*/

    /*
    * dfs第二种方法
    * */
   /* int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }
        for(int i=0;i<m;i++){
            dfs(matrix,pacific,i,0);
            dfs(matrix,atlantic,i,n-1);
        }
        for(int j=0;j<n;j++){
            dfs(matrix,pacific,0,j);
            dfs(matrix,atlantic,m-1,j);
        }


        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result;
    }

    private void dfs(int[][] matrix, boolean[][] pacific,  int x, int y) {
        pacific[x][y] = true;
        int m=matrix.length;
        int n = matrix[0].length;
        for(int d[]:dir){
            int x1 = x + d[0];
            int y1 = y + d[1];
            if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || pacific[x1][y1] || matrix[x1][y1] < matrix[x][y]) {
                continue;
            }
            dfs(matrix, pacific, x1, y1);
        }
    }*/

    /*
    * 用一个Queue，位运算
    * 00: cannot reach any ocean
    * 01: can reach pacific ocean
    * 10: can reach atlantic ocean
    * 11: can reach two oceans
    * */
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        int[][] state = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            state[i][0] |= 1;
            if (i == m - 1 || n == 1) state[i][0] |= 2;
            if (state[i][0] == 3) res.add(new int[]{i, 0});
            q.offer(new int[]{i, 0});
            if (n > 1) {
                state[i][n - 1] |= 2;
                if (i == 0) state[i][n - 1] |= 1;
                if (state[i][n - 1] == 3) res.add(new int[]{i, n - 1});
                q.offer(new int[]{i, n - 1});
            }
        }
        for (int j = 1; j < n - 1; j++) {
            state[0][j] |= 1;
            if (m == 1) state[0][j] |= 2;
            if (state[0][j] == 3) res.add(new int[]{0, j});
            q.offer(new int[]{0, j});
            if (m > 1) {
                state[m - 1][j] |= 2;
                if (state[m - 1][j] == 3) res.add(new int[]{m - 1, j});
                q.offer(new int[]{m - 1, j});
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : dirs) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if (row < 0 || col < 0 || row == m || col == n || matrix[row][col] < matrix[cell[0]][cell[1]] || ((state[cell[0]][cell[1]] | state[row][col]) == state[row][col])) continue;
                state[row][col] |= state[cell[0]][cell[1]];
                if (state[row][col] == 3) res.add(new int[]{row, col});
                q.offer(new int[]{row, col});
            }
        }
        return res;
    }


}
