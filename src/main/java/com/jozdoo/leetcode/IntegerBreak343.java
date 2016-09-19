package com.jozdoo.leetcode;

import java.util.PriorityQueue;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/19
 * @email jozdoo@gmail.com
 */
public class IntegerBreak343 {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak343().integerBreak(58));
    }
    /**
     * 2 1*1
     * 3 1*2
     * 4 2*2
     * 5 2*3
     * 6 3*3
     * 7 3*4
     * 8 3*3*2
     * 9 3*3*3
     * 10 3*3*4
     * 11 3*3*3*2
     * 12 3*3*4*2
     * 13
     * 14 3*3*3*2*3 3*3*3*3*3*2
     * @param n
     * @return
     */
    int[] resutlList = new int[59];
    public int integerBreak(int n) {
        if(resutlList[n]>0)return resutlList[n];
        PriorityQueue<Integer> lastList  = new PriorityQueue<>();
        PriorityQueue<Integer> secondList = new PriorityQueue<>();
        if(n==2)return 1;
        if(n==3)return 2;
        resutlList[2]=1;
        resutlList[3]=2;
        lastList.offer(1);
        lastList.offer(2);
        secondList.offer(1);
        secondList.offer(1);
        for(int i=4;i<=58;i++){
            int secondInt = resutlList[i-2]*2;
            int lastInt = (resutlList[i-1]/lastList.peek())*(lastList.peek()+1);
            if(lastInt>secondInt) {
                resutlList[i] = lastInt;
                secondList = new PriorityQueue<>(lastList);
                Integer poll = lastList.poll()+1;
                lastList.offer(poll);
            }else {
                resutlList[i]= secondInt;
                secondList.offer(2);
                PriorityQueue<Integer> temp = lastList;
                lastList = secondList;
                secondList = temp;
            }
        }
        return resutlList[n];
    }
}
