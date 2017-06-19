package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/19
 * @email jozdoo@gmail.com
 */
public class TopKFrequentElements347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<int[]> elements = new ArrayList<>();
        Arrays.sort(nums);
        int[] element = null;
        for (int num : nums) {
            if(element!=null&&element[0]==num){
                element[1]++;
            }else {
                element = new int[2];
                element[0]=num;
                element[1]=1;
                elements.add(element);
            }
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        priorityQueue.addAll(elements);
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.poll()[0]);
        }
        return result;
    }
}
