package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/20
 * @since 3.0
 */
public class MissingNumber268 {
    public static void main(String[] args) {
        System.out.println(new MissingNumber268().missingNumber(new int[]{1,2}));
    }
    public int missingNumber(int[] nums) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num,max);
            sum+=num;
        }
        long i = ((max *(max+1))/ 2  - sum);
        if(i==0&&nums.length==max+1)return max+1;
        else if(i==0)return 0;
        else return (int)i;
    }
}
