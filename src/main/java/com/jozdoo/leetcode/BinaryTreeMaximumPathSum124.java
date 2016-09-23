package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/23
 * @since 3.0
 *
 *        Given a binary tree, find the maximum path sum.
 *        For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.
 *        For example:
 *        Given the below binary tree,
 *        1
 *        / \
 *        2 3
 *        Return 6.
 */
public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(-1);
        // treeNode.left.left = new TreeNode(3);
        // treeNode.left.right = new TreeNode(4);
        // treeNode.right = new TreeNode(5);
        // treeNode.right.left = new TreeNode(6);
        // treeNode.right.right = new TreeNode(7);
        int max = new BinaryTreeMaximumPathSum124().maxPathSum(treeNode);
        System.out.println(max);
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxpath(root);
        return max;
    }

    public int maxpath(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        int left = maxpath(treeNode.left);
        int right = maxpath(treeNode.right);
        int turnMax = Math.max(Math.max(Math.max(treeNode.val, treeNode.val + left), treeNode.val + right),
                treeNode.val + left + right);
        if (turnMax > max)
            max = turnMax;
        return Math.max(Math.max(left + treeNode.val, right + treeNode.val), treeNode.val);
    }
}
