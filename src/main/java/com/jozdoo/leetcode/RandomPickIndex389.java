package com.jozdoo.leetcode;

import java.util.Random;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/27
 * @email jozdoo@gmail.com
 *        Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 *        Note:
 *        The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *        Example:
 *        int[] nums = new int[] {1,2,3,3,3};
 *        Solution solution = new Solution(nums);
 *        // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 *        solution.pick(3);
 *        // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 *        solution.pick(1);
 *        ["Solution","pick"]
 *        [[[]],[-760627172]]
 */
public class RandomPickIndex389 {
    public static void main(String[] args){
        System.out.println(new RandomPickIndex389(new int[] { -1, 3, -1, 3,3,3,3,3,3, 2, 1 }).pick(3));
    }

    int[] nums;
    Random random = new Random();

    public RandomPickIndex389(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int resutl = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int rnum = random.nextInt(++total);
                if(rnum==0){
                    resutl = i;
                }
            }
        }
        return resutl;
    }
}
