package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/21
 * @since 3.0
 *        Given an unsorted array of integers, find the length of longest increasing subsequence.
 *        For example,
 *        Given [10, 9, 2, 5, 3, 7, 101, 18],
 *        The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 *        Your algorithm should run in O(n2) complexity.
 *        Follow up: Could you improve it to O(n log n) time complexity?
 *
 *
 *        4,5,6,1,2,3,4,5,6,7
 */
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(new int[]{}));
    }
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        int[] list = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]&&list[j]>max){
                    max=list[j];
                }
            }
            list[i]=max+1;
            if(max+1>result)result = max+1;
        }
        return result;
    }
}
