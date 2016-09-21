package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/21
 * @since 3.0
 *
 *        Follow up for "Remove Duplicates":
 *        What if duplicates are allowed at most twice?
 *        For example,
 *        Given sorted array nums = [1,1,1,2,2,3],
 *        Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArrayII80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
        int sum = 0;
        int a=nums[0]-1;
        int b=nums[0]-1;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(num==b&&num==a)continue;
            a=b;
            b=num;
            nums[sum]=num;
            sum++;
        }

        return sum;
    }

}
