package leetcode;

/**
 * Created by ych0112xzz on 2016/11/21.
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            int tmp = prices[i]-prices[i-1];
            if(tmp>0){
                profit += tmp;
            }
        }

        return profit;
    }
}
