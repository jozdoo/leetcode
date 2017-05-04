package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/5/3
 * @email jozdoo@gmail.com
 *
 *        Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *        For example:
 *        Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *        Note:
 *        The order of the result is not important. So in the above example, [5, 3] is also correct.
 *        Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *        todo
 */
public class SingleNumberIII260 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 1, 3, 2, 5};
        int[] ints1 = new SingleNumberIII260().singleNumber(ints);
        System.out.println("he");
    }
    public int[] singleNumber(int[] nums) {
        return nums;
    }
}
