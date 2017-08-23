package interview.meitu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        mp['A'] = 0;
        mp['B'] = 1;
        mp['C'] = 2;
        mp['D'] = 3;
        mp['E'] = 4;
        mp['F'] = 5;
        mp['G'] = 6;
        mp['H'] = 7;

        n = in.nextInt();
        m = in.nextLong();
        clear(0);
        ct = 0;
        Arrays.fill(mm, 0);
        for (int i = 1; i <= n; i++)
            insert(in.next().toCharArray());
        build();
        get_mat();
        pow_mat(m);
        ans = 0;
        for (int i = 0; i <= ct; i++)
            ans = (ans + res[0][i]) % mod;
        System.out.println(ans);
    }


    static int n, ct;
    static long m, mod = 100007, ans;
    static int[] mp = new int[305];
    static int[] mm = new int[105];
    static int[] ff = new int[105];
    static int[][] ch = new int[105][8];
    static long[][] bb = new long[105][105];
    static long[][] xx = new long[105][105];
    static long[][] res = new long[105][105];
    static Queue<Integer> q = new LinkedList<Integer>();

    static void clear(int u) {
        ch[u][0] = ch[u][1] = ch[u][2] = ch[u][3] = ch[u][4] = ch[u][5] = ch[u][6] = ch[u][7] = 0;
    }

    static void insert(char[] s) {
        int u = 0, a;
        for (int i = 0; i < s.length; i++) {
            a = mp[s[i]];
            if (ch[u][a] == 0) {
                ch[u][a] = ++ct;
                clear(ct);
            }
            u = ch[u][a];
        }
        mm[u] = 1;
    }

    static void build() {
        q.clear();
        int u, v, r;
        for (int i = 0; i < 8; i++) {
            u = ch[0][i];
            if (u > 0) {
                q.add(u);
                ff[u] = 0;
            }
        }
        while (!q.isEmpty()) {
            r = q.poll();
            v = ff[r];
            if (mm[v] == 1) mm[r] = 1;
            for (int i = 0; i < 8; i++) {
                u = ch[r][i];
                if (u == 0) ch[r][i] = ch[v][i];
                else {
                    ff[u] = ch[v][i];
                    q.add(u);
                }
            }
        }
    }

    static void get_mat() {
        for (int i = 0; i <= ct; i++) {
            for (int j = 0; j <= ct; j++)
                xx[i][j] = 0;
            for (int j = 0; j < 8; j++)
                if (mm[ch[i][j]] == 0) xx[i][ch[i][j]]++;
        }
    }

    static void mul_mat(long[][] xx, long[][] yy) {
        for (int i = 0; i <= ct; i++)
            for (int j = 0; j <= ct; j++) {
                bb[i][j] = 0;
                for (int k = 0; k <= ct; k++)
                    bb[i][j] = (bb[i][j] + xx[i][k] * yy[k][j] % mod) % mod;
            }
        for (int i = 0; i <= ct; i++)
            for (int j = 0; j <= ct; j++)
                xx[i][j] = bb[i][j];
    }

    static void pow_mat(long n) {
        for (int i = 0; i <= ct; i++) {
            for (int j = 0; j <= ct; j++)
                res[i][j] = 0;
            res[i][i] = 1;
        }
        while (n > 0) {
            if ((n & 1) > 0) mul_mat(res, xx);
            mul_mat(xx, xx);
            n >>= 1;
        }
    }


}

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        printArray(arr, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(arr[i][j] + " ");

            System.out.print("\n");
        }
    }

    public static void printArray(int[][] a, int height, int width) {
        int max = 20;
        int i = 0, j = 0;

        int m = 1, s = 1;
        int x1 = 0;
        int y1 = 0;
        int x2 = height;
        int y2 = width;
        while (true) {
            if (s == 1) {
                for (; j < y2; j++) {
                    a[i][j] = m++;
                }
                j--;
                i++;
                y2--;
                for (; i < x2; i++) {
                    a[i][j] = m++;
                }
                i--;
                j--;
                x2--;
                s = -1;
            } else {
                for (; j >= y1; j--) {
                    a[i][j] = m++;
                }
                j++;
                i--;
                y1++;
                for (; i >= x1 + 1; i--) {
                    a[i][j] = m++;
                }
                i++;
                j++;
                x1++;
                s = 1;
            }
            if (m > height * width) {
                break;
            }
        }
    }*/
//}
