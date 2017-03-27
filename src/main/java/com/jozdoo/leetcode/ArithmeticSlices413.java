package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/3/27
 * @email jozdoo@gmail.com
 */
public class ArithmeticSlices413 {
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0;
        int sum = 0;
        for(int i=1;i<A.length-1;i++){
            if(A[i]-A[i-1]==A[i+1]-A[i]){
                curr++;
                sum+=curr;
            }else {
                curr=0;
            }
        }
        return sum;
    }
}
