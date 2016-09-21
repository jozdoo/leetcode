package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/21
 * @since 3.0
 *        Implement int sqrt(int x).
 *        Compute and return the square root of x.
 */
public class SqrtX69 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(46340*46340);
        System.out.println(new SqrtX69().mySqrt(4));
    }
    public int mySqrt(int x) {
        if(x>=2147395600)return 46340;
        if(x==1)return 1;
        int begin=0;
        int end = x/2;
        if(x>46340*2) end = 46340;
        while (begin<end){
            int i = (end + begin+1) / 2;
            int i1 = i * i;
            if(i1==x)return i;
            if(i1>x){
                end=i-1;
            } else {
                begin=i;
            }
        }
        return begin;
    }
}
