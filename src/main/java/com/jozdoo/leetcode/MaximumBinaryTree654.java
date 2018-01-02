package com.jozdoo.leetcode;

public class MaximumBinaryTree654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode constract = constract(nums, 0, nums.length);
        return constract;
    }

    public TreeNode constract(int[] nums,int left ,int right){
        if(left>=right)return null;
        int max=left;
        for (int i = left; i < right; i++) {
            if(nums[i]>nums[max])max=i;
        }
        TreeNode treeNode = new TreeNode(nums[max]);
        treeNode.left=constract(nums,left,max);
        treeNode.right=constract(nums,max+1,right);
        return treeNode;
    }
}
