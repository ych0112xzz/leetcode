package leetcode;

/**
 * Created by ych0112xzz on 2016/12/6.
 */
public class NumberofIslands {

    /*
    * BFS
    * */
   /* public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int num = i * n + j;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            i = cur / n;
            j = cur % n;
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = '0';
                queue.offer((i - 1) * n + j);
            }
            if (i + 1 < m && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                queue.offer((i + 1) * n + j);
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                queue.offer(i * n + j - 1);
            }
            if (j + 1 < n && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                queue.offer(i * n + j + 1);
            }
        }
    }*/

    /*
    * DFS
    * */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (i + 1 < m && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (j + 1 < n && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }

    }
}
