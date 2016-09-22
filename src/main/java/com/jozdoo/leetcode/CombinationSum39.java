package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/22
 * @since 3.0
 *        Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *        The same repeated number may be chosen from C unlimited number of times.
 *        Note:
 *        All numbers (including target) will be positive integers.
 *        The solution set must not contain duplicate combinations.
 *        For example, given candidate set [2, 3, 6, 7] and target 7,
 *        A solution set is:
 *        [
 *        [7],
 *        [2, 2, 3]
 *        ]
 *        AC
 */
public class CombinationSum39 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new CombinationSum39().combinationSum(new int[] { 1, 2, 3 }, 0);
        System.out.println(lists);
    }

    Map<String, Boolean> map = new HashMap<>();

    List<List<Integer>> lists = new ArrayList<>();

    ArrayList<Integer> list = new ArrayList<>();

    int numsCandidates;

    int[] candidaets;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidaets = candidates;
        this.numsCandidates = candidates.length;
        deepSearch(0, target);
        return lists;
    }

    public void addLists(List<Integer> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer integer : list) {
            stringBuffer.append(integer);
            stringBuffer.append(';');
        }
        String s = stringBuffer.toString();
        if (map.containsKey(s)) {
            return;
        }
        map.put(s, true);
        lists.add(list);
        return;
    }

    public void deepSearch(int p, int target) {
        if (target == 0)
            addLists(new ArrayList<>(list));
        if (p >= numsCandidates)
            return;
        for (int i = 0; i <= target / candidaets[p]; i++) {
            for (int j = 0; j < i; j++)
                list.add(candidaets[p]);
            deepSearch(p + 1, target - i * candidaets[p]);
            for (int j = 0; j < i; j++)
                list.remove(list.size() - 1);
        }
    }

}
