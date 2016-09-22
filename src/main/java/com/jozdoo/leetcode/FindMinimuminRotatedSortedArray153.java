package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/22
 * @since 3.0
 */
public class FindMinimuminRotatedSortedArray153 {
    public int findMin(int[] nums) {
        if(nums.length==0)return 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num<min)min = num;
        }
        return min;

    }
}
