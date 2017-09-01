package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/9/1
 * @email jozdoo@gmail.com
 */
public class NQueensII52 {

    public int totalNQueens(int n) {
        int[] board = new int[n];
        Arrays.fill(board,-1);
        List<List<String>> resutl = new ArrayList<>();
        return find(n,board,0,0);
    }
    public int find(int n ,int[] board,int curCol,int count){
        if(curCol>=n){
            return count+1;
        }
        for (int i = 0; i < n; i++) {
            if(isCool(board,curCol,i)){
                board[curCol]=i;
                count = find(n,board,curCol+1,count);
            }
        }
        board[curCol]=-1;
        return count;
    }
    public boolean isCool(int[] board,int curCol,int curRow) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[i] == -1) continue;
            if (board[i] == curRow) return false;
            if (Math.abs(board[i] - curRow) == Math.abs(i - curCol)) return false;
        }
        return true;
    }
}
