package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/4/7
 * @email jozdoo@gmail.com
 */
public class FindLargestValueinEachTreeRow515 {
    public int deep = 0;
    public List<Integer> maxNums = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)return maxNums;
        if(maxNums.size()<deep+1)maxNums.add(root.val);
        if(maxNums.get(deep)<root.val){
            maxNums.remove(deep);
            maxNums.add(deep,root.val);
        }
        if(root.left!=null){
            deep++;
            largestValues(root.left);
            deep--;
        }
        if(root.right!=null){
            deep++;
            largestValues(root.right);
            deep--;
        }
        return maxNums;
    }
}
