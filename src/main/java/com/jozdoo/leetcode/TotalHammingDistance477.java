package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/20
 * @email jozdoo@gmail.com
 */
public class TotalHammingDistance477 {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int k=0;
            for (int num : nums) {
                if(((num>>i)&1)>0)k++;
            }
            result+=k*(nums.length-k);
        }
        return result;
    }
}
