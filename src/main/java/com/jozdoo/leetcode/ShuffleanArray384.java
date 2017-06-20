package com.jozdoo.leetcode;

import java.util.*;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/20
 * @email jozdoo@gmail.com
 */
public class ShuffleanArray384 {

    int[] nums;
    Random random = new Random();
    public ShuffleanArray384(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> list = new ArrayList(nums.length);
        for (int num : nums) {
            list.add(num);
        }

        for (int i = list.size(); i >0 ; i-- ){
            list.add(list.remove(random.nextInt(i)));
        }
        return list.stream().mapToInt(value -> value).toArray();
    }
}
