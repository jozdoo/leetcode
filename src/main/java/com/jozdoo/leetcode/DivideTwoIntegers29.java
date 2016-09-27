package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/20
 * @since 3.0
 *
 * todo 16/10/08 下午5:00
 */
public class DivideTwoIntegers29 {

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers29().divide(-2147483648,2));
    }

    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1)return Integer.MAX_VALUE;
        boolean b = true;
        if(dividend>0){
            if(divisor>0){
                b=true;
            }else {
                b=false;
            }

        }else {
            if(divisor>0){
                b=false;
            }else {
                b=true;
            }
        }
        int result = 0;
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
//        while (absDividend>=absDivisor){
//            absDividend-=absDivisor;
//            result++;
//        }
        result = absDividend/absDivisor;
        return b?result:-result;
    }
}
