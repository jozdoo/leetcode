package com.jozdoo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/4/7
 * @email jozdoo@gmail.com
 *
 *        Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *        Find all the elements that appear twice in this array.
 *        Could you do it without extra space and in O(n) runtime?
 *        Example:
 *        Input:
 *        [4,3,2,7,8,2,3,1]
 *        Output:
 *        [2,3]
 */
public class FindAllDuplicatesinanArray442 {
    public static void main(String[] args) {
        System.out.println(new FindAllDuplicatesinanArray442().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
//        System.out.println(new FindAllDuplicatesinanArray442().findDuplicates(new int[]{1,1}));
    }
//    public List<Integer> findDuplicates(int[] nums) {
//        int[] integers = new int[nums.length];
//        List<Integer> result = new LinkedList<>();
//        for (int num : nums) {
//            int integer = integers[num - 1];
//            if(integer==0)integers[num-1]=num;
//            else result.add(num);
//        }
//        return result;
//    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int integer = nums[i];
            while (nums[integer-1]!=integer&&nums[integer-1]!=integer) {
                int temp = nums[integer-1];
                nums[integer-1]=integer;
                nums[i]=temp;
                integer = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                result.add(nums[i]);
            }
        }
        return result;
    }

}
