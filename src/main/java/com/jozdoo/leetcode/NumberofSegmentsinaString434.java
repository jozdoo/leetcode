package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/1/23
 * @email jozdoo@gmail.com
 */
public class NumberofSegmentsinaString434 {
    public static void main(String[] args) {
        System.out.println(countSegments("      1     321 "));
    }
    public static int countSegments(String s) {
        if(s.trim().isEmpty())return 0;
        return s.trim().split(" +").length;
    }
}
