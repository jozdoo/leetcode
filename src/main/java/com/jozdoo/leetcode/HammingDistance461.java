package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/7/5
 * @email jozdoo@gmail.com
 */
public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int count = 0;
        while (z>0){
            if((z&1)==1){
                count++;
            }
            z>>=1;
        }
        return count;
    }
}
