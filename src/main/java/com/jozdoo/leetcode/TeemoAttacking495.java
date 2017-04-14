package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/4/14
 * @email jozdoo@gmail.com
 */
public class TeemoAttacking495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for (int i = 0; i < timeSeries.length-1; i++) {
            if(timeSeries[i]+duration-1<timeSeries[i+1]){
                sum+=duration;
            }else{
                sum+=(timeSeries[i+1]-timeSeries[i]);
            }
        }
        if(timeSeries.length>0) {
            sum += duration;
        }
        return sum;
    }
}
