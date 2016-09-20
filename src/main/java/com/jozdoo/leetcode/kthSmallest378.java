package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrong Answer
 * todo 16/9/25 上午7:00
 */
public class kthSmallest378 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,3,5},
                {10,11,13},
                {12,13,15}};
        System.out.println(kthSmallest(matrix,8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int width = matrix.length;
        int beforeLines = 0;
        int lineNum =0;
        List<Integer> theLine = new ArrayList<>();
        for(int i=0;i<2*width;i++){
            lineNum = width-1-Math.abs(width-1-i)+1;
            if(beforeLines+lineNum<k){
                beforeLines+=(lineNum);
            }else {
                lineNum=i;
                break;
            }
        }
        for (int j=0;j<=lineNum;j++){
            try {
                theLine.add(matrix[j][lineNum - j]);
            }catch (Exception e){

            }
        }
        theLine.sort((o1, o2) -> o1-o2);
        return theLine.get(k-beforeLines-1);
    }
}
