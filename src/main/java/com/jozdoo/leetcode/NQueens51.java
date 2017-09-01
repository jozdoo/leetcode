package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/7/18
 * @email jozdoo@gmail.com
 */
public class NQueens51 {

    public static List<List<String>> solveNQueens(int n) {
        int[] board = new int[n];
        Arrays.fill(board,-1);
        List<List<String>> resutl = new ArrayList<>();
        find(n,board,0,resutl);
        return resutl;
    }
    public static void find(int n ,int[] board,int curCol,List<List<String>> lists){
        if(curCol>=n){
            lists.add(boardIntoStrings(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isCool(board,curCol,i)){
                board[curCol]=i;
                find(n,board,curCol+1,lists);
            }
        }
        board[curCol]=-1;
    }
    public static boolean isCool(int[] board,int curCol,int curRow){
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if(board[i]==-1)continue;
            if(board[i]==curRow)return false;
            if(Math.abs(board[i]-curRow)==Math.abs(i-curCol))return false;
        }
        return true;
    }
    public static List<String> boardIntoStrings(int[] board){
        List<String> result = new ArrayList<>();
        int n = board.length;
        for (int i : board) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if(j!=i)stringBuffer.append(".");
                else stringBuffer.append("Q");
            }
            result.add(stringBuffer.toString());
        }
        return result;
    }
}
