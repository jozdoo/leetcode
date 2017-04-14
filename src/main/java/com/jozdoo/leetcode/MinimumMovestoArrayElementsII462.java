package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/4/14
 * @email jozdoo@gmail.com
 *
 *        Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 *        where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *        You may assume the array's length is at most 10,000.
 *        Example:
 *        Input:
 *        [1,2,3]
 *        Output:
 *        2
 *        Explanation:
 *        Only two moves are needed (remember each move increments or decrements one element):
 *        [1,2,3] => [2,2,3] => [2,2,2]
 */
public class MinimumMovestoArrayElementsII462 {
    public static void main(String[] args) {
        int i = new MinimumMovestoArrayElementsII462().minMoves2(new int[]{1,3,8,9});
        System.out.println(i);
    }
    public int minMoves2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num<min)min=num;
            if(num>max)max=num;
        }
        int left = min;
        int right = max;
        while (left<=right){
            int mid = (left+right)>>1;
            int midTimes = 0 ;
            int midAddOneTimes = 0;
            int midSubOneTimes =  0;
            for (int num : nums) {
                midTimes+=Math.abs(mid-num);
                midAddOneTimes+=Math.abs(mid+1-num);
                midSubOneTimes+=Math.abs(mid-1-num);
            }
            if(midTimes<=midAddOneTimes&&midTimes<=midSubOneTimes)return midTimes;
            if(midTimes<=midAddOneTimes)right = mid-1;
            if(midTimes<=midSubOneTimes)left = mid+1;
        }
        return 0;
    }
}
