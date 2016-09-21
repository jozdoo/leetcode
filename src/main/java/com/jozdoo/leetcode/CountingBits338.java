package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/21
 * @since 3.0
 *
 *        Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *        Example:
 *        For num = 5 you should return [0,1,1,2,1,2].
 *        Follow up:
 *        It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 *        Space complexity should be O(n).
 *        Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits338 {
    public static void main(String[] args) {
        int[] ints = new CountingBits338().countBits(0);
        System.out.println(new ArrayList<>(Arrays.asList(ints)));
    }
    public int[] countBits(int num) {
        int[] list = new int[num+1];
        boolean isEven =true;
        for(int i=0;i<=num;i++){
            int j = list[i>>1]+;
            list[i]=isEven?j:j+1;
            isEven=!isEven;
        }
        return list;
    }
}
