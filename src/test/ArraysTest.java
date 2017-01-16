package test;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/11/14.
 */
public class ArraysTest {
    public static void main(String[] args){
        /*int a[] = new int[] {1, 3, 4, 6, 8, 9};
        int x1 = Arrays.binarySearch(a, 5);
        int x2 = Arrays.binarySearch(a, 4);
        int x3 = Arrays.binarySearch(a, 0);
        int x4 = Arrays.binarySearch(a, 10);
        System.out.println("x1:" + x1 + ", x2:" + x2);
        System.out.println("x3:" + x3 + ", x4:" + x4);*/
        int a[] = new int[] {1, 3, 4, 6, 8, 9};
        int x1 = Arrays.binarySearch(a, 1, 4, 5);
        int x2 = Arrays.binarySearch(a, 1, 4, 4);
        int x3 = Arrays.binarySearch(a, 1, 4, 2);
        int x4 = Arrays.binarySearch(a, 1, 3, 10);
        System.out.println("x1:" + x1 + ", x2:" + x2);
        System.out.println("x3:" + x3 + ", x4:" + x4);
    }

}
