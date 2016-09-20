package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/20
 * @since 3.0
 * java.lang.IndexOutOfBoundsException: Index: 1, Size: 1  missing zero situation
 * Time Limit Exceeded 忘了删除 System.out.println fuck
 * AC
 * 1 9 1 8 1 7 1 6
 */
public class BestTimeToBuyAndSellStockIV188 {

    public static void main(String[] args) {
        int[] prices = new int[] {2,9,1,9};
        System.out.println(new BestTimeToBuyAndSellStockIV188().maxProfit(1, prices));
    }

    class Tuple {
        public Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int a;

        public int b;

        @Override
        public String toString() {
            return "{" + "a=" + a + ", b=" + b + '}';
        }

        public int profit() {
            return b - a;
        }
    }

    public int maxProfit(int k, int[] prices) {
        if(k==0)return 0;
        List<Tuple> tuples = new ArrayList<>();
        int profit = 0;
        Integer minUnpay = null;
        Integer lastPayed = null;
        Tuple currTuple = null;
        for (int price : prices) {
            int profitFromUnpay = 0;
            int profitFromPayed = 0;
            if (minUnpay != null) {
                profitFromUnpay = price - minUnpay;
            }
            if (lastPayed != null) {
                profitFromPayed = price - lastPayed;
            }
            if (profitFromPayed > 0 || profitFromUnpay > 0) {
                if (profitFromPayed > profitFromUnpay) {
                    profit += profitFromPayed;
                    currTuple.b = price;
                } else {
                    profit += profitFromUnpay;
                    if (currTuple != null) {
                        tuples.add(currTuple);
                    }
                    currTuple = new Tuple(minUnpay, price);
                }
                lastPayed = price;
                minUnpay = null;
            } else {
                minUnpay = price;
            }
        }
        tuples.add(currTuple);
        while (tuples.size() > k) {

            int minWaste = Integer.MAX_VALUE;
            int minWastePos = 0;
            int minA = 0;
            int minB = 0;
            for (int i = 0; i < tuples.size() - 1; i++) {

                int twoTupleA = Integer.MAX_VALUE;
                int twoTupleB = Integer.MIN_VALUE;
                int twoTupleProfit = Integer.MIN_VALUE;

                if(tuples.get(i).profit()>twoTupleProfit){
                    twoTupleProfit = tuples.get(i).profit();
                    twoTupleA = tuples.get(i).a;
                    twoTupleB = tuples.get(i).b;
                }
                if(tuples.get(i+1).profit()>twoTupleProfit){
                    twoTupleProfit = tuples.get(i+1).profit();
                    twoTupleA = tuples.get(i+1).a;
                    twoTupleB = tuples.get(i+1).b;
                }

                if((tuples.get(i+1).b-tuples.get(i).a)>twoTupleProfit){
                    twoTupleProfit = tuples.get(i+1).b-tuples.get(i).a;
                    twoTupleA = tuples.get(i).a;
                    twoTupleB = tuples.get(i+1).b;
                }

                int waste = tuples.get(i).profit()+tuples.get(i+1).profit()-twoTupleProfit;

                if (waste < minWaste) {
                    minWaste = waste;
                    minWastePos = i;
                    minA = twoTupleA;
                    minB = twoTupleB;
                }
            }
            tuples.add(minWastePos, new Tuple(minA, minB));
            tuples.remove(minWastePos + 1);
            tuples.remove(minWastePos + 1);
            profit-=minWaste;
        }

        return profit;
    }

}