package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/7/5
 * @email jozdoo@gmail.com
 */
public class MergeTwoBinaryTrees617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null&&t2==null)return null;
        return mergeTrees(t1,t2,null);
    }
    public TreeNode mergeTrees(TreeNode t1,TreeNode t2,TreeNode mergeTree){
        if(t1==null)t1 = new TreeNode(0);
        if(t2==null)t2 = new TreeNode(0);
        mergeTree = new TreeNode(t1.val+t2.val);
        if(t1.left!=null||t2.left!=null){
            mergeTree.left = mergeTrees(t1.left, t2.left, mergeTree.left);
        }
        if(t1.right!=null||t2.right!=null){
            mergeTree.right = mergeTrees(t1.right, t2.right, mergeTree.right);
        }
        return mergeTree;
    }
}
