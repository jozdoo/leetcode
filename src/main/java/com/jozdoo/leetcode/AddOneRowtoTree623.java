package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/19
 * @email jozdoo@gmail.com
 */
public class AddOneRowtoTree623 {
    int deep = 1;
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root==null){
            return null;
        }
        else if(deep==1&&d==1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left=root;
            return newRoot;
        }
        else if(deep==d-1){
            TreeNode left = new TreeNode(v);
            left.left = root.left;
            root.left = left;
            TreeNode right = new TreeNode(v);
            right.right = root.right;
            root.right = right;
            return root;
        }
        else {
            deep++;
            addOneRow(root.left, v, d);
            addOneRow(root.right, v, d);
            deep--;
            return root;
        }
    }
}
