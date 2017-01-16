package leetcode;

/**
 * Created by ych0112xzz on 2016/9/12.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int height[] = {1, 2, 3};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int result = 0;
        if (height.length == 0) {
            return 0;
        }
        int start=0;
        int end = height.length-1;
        int sVal = height[start];
        int eVal = height[end];
        int area=0;
        while(start<end){


            int tmp = (end - start) * Math.min(height[start], height[end]);
            area = tmp > area ? tmp : area;
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return area;
    }

}
