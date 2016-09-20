package com.jozdoo.leetcode;

import java.util.PriorityQueue;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/20
 * @since 3.0
 * 按照最优子段 来思考 , 添加一个新元素 , 需要哪些信息来形成一个新的最优子段
 * 7 2 1 5 9 2 5 9
 * profit minUnpayPrice minPayedPrice
 * 0 7 -1
 * 0 2 -1
 * 3 7 5
 * 7 7 9
 * 7 2 9
 * 10 7 5
 * 14 7 9
 * AC
 */
public class BestTimeToBuyAndSellStockII122 {

    public int maxProfitForMultiTransactions(int[] prices) {
        PriorityQueue<Integer> minUnPayPrice = new PriorityQueue<>();
        PriorityQueue<Integer> minPayedPrice = new PriorityQueue<>();
        int profit = 0;
        for (int price : prices) {
            int profitFromUnpay = 0;
            int profitFromPayed = 0;
            Integer minUnPay = minUnPayPrice.peek();
            Integer minPayed = minPayedPrice.peek();
            if(minUnPay!=null){
                profitFromUnpay = price-minUnPay;
            }
            if(minPayed!=null){
                profitFromPayed = price-minPayed;
            }
            if(profitFromPayed>0||profitFromUnpay>0) {
                if (profitFromPayed > profitFromUnpay) {
                    minUnPayPrice.offer(minPayedPrice.poll());
                    minPayedPrice.offer(price);
                    profit+=profitFromPayed;
                }else{
                    minUnPayPrice.poll();
                    minPayedPrice.offer(price);
                    profit+=profitFromUnpay;
                }
            }else {
                minUnPayPrice.offer(price);
            }
        }
        return profit;

    }

    /**
     * 1 2 3 4 5 1 2 3 4
     * 0 1 0
     * 1 0 2
     * 2 0 3
     * 3 0 4
     * 4 0 5
     * 4 1 5
     * 5 0 2
     * @param prices
     * @return
     */
    public  int maxProfit(int[] prices){
        int profit = 0;
        Integer minUnpay = null;
        Integer lastPayed = null;
        for (int price : prices) {
            int profitFromUnpay = 0;
            int profitFromPayed = 0;
            if(minUnpay!=null){
                profitFromUnpay = price-minUnpay;
            }
            if(lastPayed !=null){
                profitFromPayed = price- lastPayed;
            }
            if(profitFromPayed>0||profitFromUnpay>0){
                if (profitFromPayed > profitFromUnpay) {
                    profit+=profitFromPayed;
                }else{
                    profit+=profitFromUnpay;
                }
                lastPayed=price;
                minUnpay = null;
            }else {
                minUnpay=price;
            }
        }

        return profit;
    }
}

