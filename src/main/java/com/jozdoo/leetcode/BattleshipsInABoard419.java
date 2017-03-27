package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/3/27
 * @email jozdoo@gmail.com
 */
public class BattleshipsInABoard419 {
    public static void main(String[] args) {
        char[][] board =  new char[][]{
                {'.','X','.','.','X'},
                {'X','.','.','X','.'},
                {'.','X','.','.','X'},
                {'.','X','.','X','.'},
                {'X','.','X','.','X'},
//                {'X','X','X'}
//                {'X','.','.','X'},
//                {'.','.','.','X'},
//                {'.','.','.','X'},
//                {'X','.','.','X'},
//                {'X','.','X','.'},
//                {'X','.','.','X'},
//                {'X','.','.','X'},
        };
        System.out.println(countBattleships(board));
    }
    public static int countBattleships(char[][] board) {
        int battleshipNum = 0;
        int height = board.length;
        int width = board[0].length;
        int inLine = 0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                char c = board[i][j];
                if(c=='X'){
                    if((i-1<0||board[i-1][j]!='X')&&(i+1>=height||board[i+1][j]!='X')){
                        inLine++;
                    }
                }else {
                    if(inLine!=0){
                        battleshipNum++;
                    }
                    inLine=0;
                }
            }
            if(inLine!=0){
                battleshipNum++;
            }
            inLine=0;
        }
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                char c = board[j][i];
                if(c=='X'){
                    if((i-1<0||board[j][i-1]!='X')&&(i+1>=width||board[j][i+1]!='X')){
                        inLine++;
                    }
                }else {
                    if(inLine>1){
                        battleshipNum++;
                    }
                    inLine=0;
                }
            }
            if(inLine>1){
                battleshipNum++;
            }
            inLine=0;
        }
        return battleshipNum;
    }
}
