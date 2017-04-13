package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/4/12
 * @email jozdoo@gmail.com
 *
 *        Given the root of a tree, you are asked to find the most frequent subtree sum.
  *       The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
  *       So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *        Examples 1
 *        Input:
 *        5
 *        / \
 *        2 -3
 *        return [2, -3, 4], since all the values happen only once, return all of them in any order.
 *        Examples 2
 *        Input:
 *        5
 *        / \
 *        2 -5
 *        return [2], since 2 happens twice, however -5 only occur once.
 *        Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class MostFrequentSubtreeSum508 {
    public HashMap<Integer,Integer> sumTimes = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null)return new int[0];
        findFrequentTreeSum2(root);
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(sumTimes.entrySet());
        entries.sort((o1, o2) -> o1.getValue()-o2.getValue());
        List<Integer> integers = new ArrayList<>();
        Integer times = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue()>=times){
                integers.add(entry.getKey());
                times = entry.getValue();
            }else {
                break;
            }
        }
        int[] ints = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ints[i]=integers.get(i);
        }
        return ints;
    }
    public void findFrequentTreeSum2(TreeNode root) {
        if(root.right!=null){
            findFrequentTreeSum2(root.right);
        }
        if(root.left!=null){
            findFrequentTreeSum2(root.left);
        }
        if(root.left!=null){
            root.val+=root.left.val;
        }
        if(root.right!=null){
            root.val+=root.right.val;
        }
        Integer integer = sumTimes.get(root.val);
        if (integer==null){
            sumTimes.put(root.val,1);
        }else {
            sumTimes.put(root.val,integer+1);
        }
    }
}
