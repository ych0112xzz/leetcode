package leetcode;

import java.util.Stack;

/**
 * Created by ych0112xzz on 2017/4/24.
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int max = heights[0];
        int i = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (i < heights.length || (i == heights.length && !stack.isEmpty())) {
            if (i < heights.length && (stack.isEmpty() || heights[i] >= heights[stack.peek()])) {
                stack.push(i);
                i++;
            } else {
                int top = heights[stack.pop()];
                int curMax = stack.isEmpty() ? top * i : top * (i - 1 - stack.peek());
                max = Math.max(curMax, max);
            }
        }
        return max;
    }
}
