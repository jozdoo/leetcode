package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/19
 * @email jozdoo@gmail.com
 * 看到这样的串就往dp方向想 , 这次直接使用leetCode编辑器编码的....
 * AC
 */
public class BestTimeToBuyAndSellStock121 {
    public int maxProfit(int[] prices) {
        int min =Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            int curr = prices[i];
            if((curr-min)>profit)profit=curr-min;
            if(min>curr)min = curr;
        }
        return profit;
    }
}
