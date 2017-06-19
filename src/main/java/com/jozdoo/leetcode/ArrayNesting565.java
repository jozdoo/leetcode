package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/19
 * @email jozdoo@gmail.com
 */
public class ArrayNesting565 {
    public int arrayNesting(int[] nums) {
        byte[] flags = new byte[nums.length];
        int maxSize = 0;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i]==0){
                int index = i;
                int size =0;
                while (flags[index]==0){
                    flags[index]=1;
                    index = nums[index];
                    size++;
                }
                maxSize = Math.max(maxSize,size);
            }
        }
        return maxSize;
    }
}
