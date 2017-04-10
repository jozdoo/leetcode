package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/4/7
 * @email jozdoo@gmail.com
 *
 *        Given a Binary Search Tree (BST),
  *       convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *        Example:
 *        Input: The root of a Binary Search Tree like this:
 *        5
 *        / \
 *        2 13
 *        Output: The root of a Greater Tree like this:
 *        18
 *        / \
 *        20 13
 */
public class ConvertBSTtoGreaterTree538 {
    public int sum = 0;
    public int i;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)return root;
        if(root.right!=null){
            convertBST(root.right);
        }
        i = sum + root.val;
        root.val = root.val+sum;
        sum = i;
        if(root.left!=null){
            convertBST(root.left);
        }
        return root;
    }
}
