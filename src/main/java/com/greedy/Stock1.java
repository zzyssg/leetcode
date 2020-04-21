package com.greedy;

/**
 *121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 */
public class Stock1 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int res = 0;
        int min = prices[0];
        for(int i = 1;i < prices.length;i++){
            res = Math.max(prices[i] - min,res);
            if(prices[i] < min) min = prices[i];
        }
        return res;
    }
}
