package com.jozdoo.leetcode;

import java.util.Arrays;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/11/10
 * @email jozdoo@gmail.com
 */
public class ContainsDuplicate217 {
    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate217().containsDuplicate(new int[]{1,2,3,4,7,5,6}));
    }
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])return true;
        }
        return false;
    }
}
