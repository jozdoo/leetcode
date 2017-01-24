package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/1/23
 * @since 3.0
 */
//TODO: 17/1/24 wa
public class LowestCommonAncestorofaBinaryTree236 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        TreeNode treeNode1 = lowestCommonAncestor(treeNode, null, treeNode.left);
        System.out.println(treeNode1);
    }
    static TreeNode result = null;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor(root,p,q,0);
        return result;
    }
    public static int lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q ,int num){
        int myNum = num;
        if(root==null)return 0;
        if(root.val == p.val || root.val == q.val) myNum++;
        myNum+=lowestCommonAncestor(root.left,p,q,num);
        myNum+=lowestCommonAncestor(root.right,p,q,num);
        if(myNum==2&&result==null)result=root;
        return myNum;
    }

}
