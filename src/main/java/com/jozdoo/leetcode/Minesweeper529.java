package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/4/10
 * @email jozdoo@gmail.com
 *        Let's play the minesweeper game (Wikipedia, online game)!
 *        You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 *        Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 *        1. If a mine ('M') is revealed, then the game is over - change it to 'X'.
 *        2. If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 *        3. If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 *        4. Return the board when no more squares will be revealed.
 *
 *        Example 1:
 *        Input:
 *        [['E', 'E', 'E', 'E', 'E'],
 *        ['E', 'E', 'M', 'E', 'E'],
 *        ['E', 'E', 'E', 'E', 'E'],
 *        ['E', 'E', 'E', 'E', 'E']]
 *        Click : [3,0]
 *        Output:
 *        [['B', '1', 'E', '1', 'B'],
 *        ['B', '1', 'M', '1', 'B'],
 *        ['B', '1', '1', '1', 'B'],
 *        ['B', 'B', 'B', 'B', 'B']]
 *        Example 2:
 *        Input:
 *        [['B', '1', 'E', '1', 'B'],
 *        ['B', '1', 'M', '1', 'B'],
 *        ['B', '1', '1', '1', 'B'],
 *        ['B', 'B', 'B', 'B', 'B']]
 *        Click : [1,2]
 *        Output:
 *        [['B', '1', 'E', '1', 'B'],
 *        ['B', '1', 'X', '1', 'B'],
 *        ['B', '1', '1', '1', 'B'],
 *        ['B', 'B', 'B', 'B', 'B']]
 *
 *        The range of the input matrix's height and width is [1,50].
 *        The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
 *        The input board won't be a stage when game is over (some mines have been revealed).
 *        For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 */
public class Minesweeper529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        char c = board[click[0]][click[1]];
        if(c=='M'){
            board[click[0]][click[1]]='X';
        }else if(c=='E'){
            int sum = 0;
            for (int i = -1; i <2 ; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0)
                        continue;
                    int i1 = click[0] + i;
                    int i2 = click[1] + j;
                    if (i1 >= 0 && i1 < board.length && i2 >= 0 && i2 < board[0].length) {
                        if (board[i1][i2] == 'M') {
                            sum++;
                        }
                    }
                }
            }
            if(sum>0) {
                board[click[0]][click[1]] = (char) ('0' + sum);
            } else {
                board[click[0]][click[1]] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        int i1 = click[0] + i;
                        int i2 = click[1] + j;
                        if (i1 >= 0 && i1 < board.length && i2 >= 0 && i2 < board[0].length) {
                            updateBoard(board, new int[] { i1, i2 });
                        }
                    }
                }
            }
        }
        return board;
    }
}
