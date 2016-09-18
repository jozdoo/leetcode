package com.jozdoo.leetcode;

import java.math.BigInteger;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/18
 * @email jozdoo@gmail.com
 *
 * 记得以前又看过这道题 当时是没想出来。。。 这次写就有点怕
 * 都想了一会都没有静下心来 , 忍住看答案的心情仔细想想 哈哈
 */
public class FactorialTrailingZeroes172 {
    public static void main(String[] args) {
        BigInteger j =new BigInteger("1");
        int y=125 ;
        for(int i=1;i<=y;i++){
            j=j.multiply(new BigInteger(i+""));
        }
        String numStr = j.toString();
        char[] chars = numStr.toCharArray();
        int xx=0;
        for(int i=chars.length-1;i>0;i--){
            if(chars[i]=='0')xx++;
            else break;
        }
        System.out.println(xx);
        System.out.println(new FactorialTrailingZeroes172().trailingZeroes(125));
    }
    public int trailingZeroes(int n) {
        int zero = 0;
        while (n/5>0){
            n/=5;
            zero+=n;
        }
        return zero;
    }
}
