package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/19
 * @email jozdoo@gmail.com
 */
public class NextGreaterElementII503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length==0)return nums;
        int[] circular = new int[nums.length*2];
        System.arraycopy(nums,0,circular,0,nums.length);
        System.arraycopy(nums,0,circular,nums.length,nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < circular.length; j++) {
                if(circular[j]>nums[i]){
                    nums[i]=circular[j];
                    break;
                }
            }
            if(circular[i]==nums[i])nums[i]=-1;
        }
        return nums;
    }
}
