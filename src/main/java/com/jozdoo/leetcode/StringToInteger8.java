package com.jozdoo.leetcode;

import java.util.LinkedList;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/18
 * @email jozdoo@gmail.com
 *
 * 从确定有限状态自动机(DFA)实现中启发使用跳转表思想 实现该代码
 * DFA implement inspiration for me
 *
 */
public class StringToInteger8 {
    public static void main(String[] args) {
        System.out.println(new StringToInteger8().myAtoi("    10522545459"));
    }
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        boolean isNagetive = false;
        int status = 0;
        boolean hasSpace = false;
        boolean hasSign =false;
        LinkedList<Integer> queue = new LinkedList();
        for(int i=0;i<chars.length;i++){
            if(status==0) {
                if (chars[i] == ' ') {
                    continue;
                } else {
                   status=1;
                }
            }
            if(status==1) {
                if (chars[i] == '-' || chars[i] == '+') {
                    if (chars[i] == '-') isNagetive = true;
                    else if (chars[i] == '+') isNagetive = false;
                    status=3;
                    continue;
                }
                status=3;
            }
            if(status==3) {
                if (chars[i] >= '0' && chars[i] <= '9') queue.push(chars[i] - '0');
                else break;
            }
        }
        long digit =1;
        long result = 0;
        while (queue.size()>0){
            Integer pop = queue.pop();
            if(isNagetive)
            result -= pop*digit;
            else result +=pop*digit;
            digit*=10;
            if(result<Integer.MIN_VALUE)return Integer.MIN_VALUE;
            if(result>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
