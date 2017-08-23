package interview.campus.lianjia;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ych0112xzz on 2017/8/19.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] input = new int[num];
        int[] sorted = new int[num];
        int[] position = new int[4];
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            int temp = sc.nextInt();
            if (temp == 1) {
                position[1]++;
            } else if (temp == 2) {
                position[2]++;
            } else {
                position[3]++;
            }
            input[i] = temp;
            sorted[i] = temp;
        }

        Arrays.sort(sorted);
        position[3] = position[2] + position[1];
        position[2] = position[1];
        position[1] = 0;

        for (int i = position[1]; i < position[2]; i++) {
            int temp = input[i];
            if (temp == 2) {
                for (int j = position[2]; j < num; j++) {
                    if (input[j] == sorted[i]) {
                        exchange(i, j, input);
                        cnt++;
                        break;
                    }
                }
            } else if (temp == 3) {
                for (int j = num - 1; j >= position[2]; j--) {
                    if (input[j] == sorted[i]) {
                        exchange(i, j, input);
                        cnt++;
                        break;
                    }
                }
            }
        }

        for (int i = position[2]; i < position[3]; i++) {
            int temp = input[i];
            if (temp == 3) {
                for (int j = num - 1; j >= position[2]; j--) {
                    if (input[j] == sorted[i]) {
                        exchange(i, j, input);
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);

    }




    public static void exchange(int i, int j, int[] target) {
        int temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }

}
