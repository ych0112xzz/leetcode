package leetcode;

/**
 * Created by ych0112xzz on 2016/11/21.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
            min = min <= prices[i] ? min : prices[i];
        }
        return max;
    }
}
