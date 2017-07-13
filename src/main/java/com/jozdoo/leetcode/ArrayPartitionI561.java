package com.jozdoo.leetcode;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/7/5
 * @email jozdoo@gmail.com
 */
public class ArrayPartitionI561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        boolean f = true;
        int sum = 0;
        for (int num : nums) {
            if(f)sum+=num;
            f=!f;
        }
        return sum;
    }
}
