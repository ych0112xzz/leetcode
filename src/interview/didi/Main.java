package interview.didi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by ych0112xzz on 2017/5/7.
 */
public class Main {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String digits = sc.nextLine();
        List<String> list = new ArrayList<>();
        list = letterCombinations(digits);
        String[] data = s.split(" ");
        if (data.length == 0) {
            System.out.println("");
        }
        String result = "";
        int a = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            String tmp = "";
            String cur = list.get(i);
            for (int j = 0; j < data.length; j++) {
                String s1 = getMaxSubstring(cur, data[j]);

                if (s1.length() > count) {
                    count = s1.length();
                    tmp = data[j];
                } else if (s1.length() == count) {
                    if ( data[j].length() < tmp.length()) {
                        tmp=data[j];
                    }
                }
            }
            System.out.println(tmp + count);
            if (count > a) {
                result = tmp;
                a = count;
            } else if (count == a) {
                if (result.length() > tmp.length()) {
                    result = tmp;
                } else if (result.length() == tmp.length()) {
                    if (s.indexOf(result) > s.indexOf(tmp)) {
                        result = tmp;
                    }
                }
            }
        }

        System.out.println(result);


    }

    public static String getMaxSubstring(String s1, String s2) {
        String max = (s1.length() > s2.length()) ? s1 : s2;
        String min = (s1.equals(max)) ? s2 : s1;
        for (int i = 0; i < min.length(); i++) {
            for (int j = 0, k = min.length() - i; k != min.length() + 1; j++, k++) {
                String s = min.substring(j, k);
                if (max.contains(s))
                    return s;
            }
        }
        return "";
    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> deque = new LinkedList<>();
        if (digits.length() == 0) {
            return deque;
        }
        deque.offer("");
        char[] data = digits.toCharArray();
        for (int i = 0; i < data.length; i++) {
            int size = deque.size();
            while (size-- > 0) {
                String prefix = deque.poll();
                String tmp = KEYS[data[i] - '0'];
                for (int j = 0; j < tmp.length(); j++) {
                    deque.offer(prefix + tmp.charAt(j));
                }
            }
        }
        return deque;
    }
}

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int m = Integer.parseInt(s.split(" ")[0]);
        int n = Integer.parseInt(s.split(" ")[1]);
        char data[][] = new char[m][n];
        for(int i=0;i<m;i++) {
            String tmp = sc.nextLine();
            for(int j=0;j<n;j++) {
                data[i][j] = tmp.charAt(j);
            }
        }
        System.out.println(numIslands(data));

    }

    public static int numIslands(char[][] grid) {
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

    private static void bfs(char[][] grid, int i, int j) {
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
    }
    *//*public static int numIslands(char[][] grid) {
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

    private static void dfs(char[][] grid, int i, int j) {
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

    }*//*
}*/
