package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Wrong Answer
 * todo 16/9/25 上午7:00
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Example:
 * matrix = [
 * [ 1, 5, 9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 7,
 * return 13.
 */
public class kthSmallest378 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 3, 5 }, { 10, 11, 13 }, { 12, 13, 15 } };
        System.out.println(kthSmallest(matrix, 7));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        List<LinkedList<Integer>> arrayLists = new ArrayList<>(matrix.length);
        for (int[] ints : matrix) {
            LinkedList<Integer> integers = new LinkedList<>();
            for (int anInt : ints) {
                integers.add(anInt);
            }
            arrayLists.add(integers);
        }
        int minNum = Integer.MAX_VALUE;
        while (k>0){
            minNum = Integer.MAX_VALUE;
            int j=0;
            for (int i=0;i<arrayLists.size();i++){
                if(arrayLists.get(i).isEmpty())continue;
                if(minNum>=arrayLists.get(i).getFirst()){
                    j=i;
                    minNum = arrayLists.get(i).getFirst();
                }
            }
            arrayLists.get(j).removeFirst();
            k--;
        }
        return minNum;
    }
}
