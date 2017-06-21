package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/20
 * @email jozdoo@gmail.com
 */
public class DiagonalTraverse498 {
    public static void main(String[] args) {
        int[] diagonalOrder = new DiagonalTraverse498().findDiagonalOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        });
        for (int i : diagonalOrder) {
            System.out.print(i+",");
        }

    }
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0)return new int[]{};
        int height = matrix.length,width = matrix[0].length;
        int pointNum = height*width;
        int[] result = new int[pointNum];
        int x=0,y = 0,index = 0;
        int xInc = 1,yInc = -1;
        while (index<pointNum){
            result[index++] = matrix[y][x];
            if(x+xInc>=0&&y+yInc>=0&&x+xInc<width&&y+yInc<height){
                x+=xInc;
                y+=yInc;
            }else {
                if(y+yInc<0||x+xInc>=width){
                    if(x+xInc>=width){
                        y++;
                    }else {
                        x++;
                    }
                    xInc=-1;
                    yInc=1;
                }else {
                    if(y+yInc>=height){
                        x++;
                    }else {
                        y++;
                    }
                    xInc=1;
                    yInc=-1;
                }
            }
        }
        return result;
    }
}
