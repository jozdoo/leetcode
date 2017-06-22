package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/22
 * @email jozdoo@gmail.com
 */
public class BinaryTreeInorderTraversal94 {
    List<Integer> integers = new ArrayList<>();
    LinkedList<TreeNode> treeNodes = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null)return integers;
        treeNodes.add(root);
        inorderTraversal2();
        return integers;
    }
    public void inorderTraversal2() {
        while (treeNodes.size()>0) {
            TreeNode pop = treeNodes.removeLast();
            if (pop.left != null) {
                treeNodes.add(pop);
                treeNodes.add(pop.left);
                pop.left=null;
                continue;
            }
            integers.add(pop.val);
            if (pop.right != null) {
                treeNodes.add(pop.right);
                pop.right=null;
                continue;
            }
        }
    }
    public List<Integer> inorderTraversalIteratively(TreeNode root) {
        if (root==null)return null;
        inorderTraversal(root.left);
        integers.add(root.val);
        inorderTraversal(root.right);
        return integers;
    }

}
