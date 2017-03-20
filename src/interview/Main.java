package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ych0112xzz on 2017/3/18.
 */
public class Main {
    public static void main(String[] args){
        boolean result=false;
        Scanner sc = new Scanner(System.in);
       // Stack<String> stack = new Stack<>();
        String s = "";

            s = sc.nextLine();

        String data[] = s.split(",");
        int len = data.length;
        for (int i=0;i<len/2;i++) {
            if(!data[i].equals(data[len-i-1])){
               // System.out.println(data[i]);
                result = true;
                break;
            }
            //stack.push(str);
        }
       /* for (String str : data) {
            if (!(str.equals(stack.pop()))) {
                result = true;
                break;
            }
        }*/
        if (result) {
            System.out.println("0");
        }else{
            System.out.println("1");
        }
    }

    /*public static void main(String[] args){
        boolean result=false;
        Scanner sc = new Scanner(System.in);
         Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue =new LinkedList<>();

        while(sc.hasNext()){
            stack.push(sc.nextInt());
            queue.offer(sc.nextInt());
        }
        while (!stack.isEmpty()) {
            if (stack.pop().intValue()!=queue.poll().intValue()) {
                result = false;
                break;

            }
        }
        if (result) {
            System.out.println("0");
        }else{
            System.out.println("1");
        }

    }*/

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int offset = sc.nextInt();
        int n = sc.nextInt();
        int l1 = sc.nextInt();
        int l2 = sc.nextInt();
        int start1 = offset;
        if (offset >= l1) {
            int start2 = offset - l1;
            System.out.print(l1 + " " + l1+" ");
            if (start2 >= l2) {
                System.out.println(l2 + " " + l2);
            } else {
                int end2 = n + start2;
                if (end2 >= l2) {
                    System.out.println(start2 + " " + l2);
                } else {
                    System.out.println(start2 + " " + end2);
                }
            }
        } else {
            int end1 = n + start1;
            if (end1 >= l1) {
                System.out.print(start1 + " " + l1+" ");
                int end2 = end1 - l1;
                if (end2 >= l2) {
                    System.out.println(0 + " " + l2);
                }else{
                    System.out.println(0 + " " + end2);
                }
            }else{
                System.out.print(start1 + " " + end1+" ");
                System.out.println(0 + " " + 0);
            }

        }

    }*/

   /* public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix=new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public static int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] >= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }*/

}
