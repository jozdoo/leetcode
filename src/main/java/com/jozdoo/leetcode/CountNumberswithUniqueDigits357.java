package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/22
 * @email jozdoo@gmail.com
 */
public class CountNumberswithUniqueDigits357 {
    public int countNumbersWithUniqueDigits(int n) {
        int result = 0;
        if(n>10)n=10;
        for (int j = 1; j <= n; j++) {
            int temp = 9;
            for (int i = 9; i > (10-j); i--) {
                temp*=i;
            }
            result+=temp;
        }
        return result+1;
    }
}
